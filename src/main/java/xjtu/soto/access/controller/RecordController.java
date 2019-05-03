package xjtu.soto.access.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import xjtu.soto.access.pojo.*;
import xjtu.soto.access.service.*;
import xjtu.soto.access.utils.ParamsUtil;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/record")
@Slf4j
public class RecordController {

    @Autowired
    private RecordService recordService;
    @Autowired
    private ThirdLocateService thirdLocateService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private FacilityService facilityService;

    @GetMapping("list")
    public ModelAndView list(Model model) {
        List<RecordEntity> recordEntities = recordService.findAll();

        model.addAttribute("recordList", recordEntities);

        return new ModelAndView("/record/list", "recordModel", model);
    }


    @GetMapping(value = "search")
    public ModelAndView showSearch(Model model) {
        model.addAttribute("title", "流水信息管理");
        model.addAttribute("subtitle", "流水信息查询");
        List<ThirdLocateEntity> thirdLocateList = thirdLocateService.findAll();
        model.addAttribute("thirdLocateList", thirdLocateList);
        List<DepartmentEntity> departmentEntityList = departmentService.findAll();
        model.addAttribute("departmentList", departmentEntityList);

        List<IdentityEntity> roleList = roleService.findAll();
        model.addAttribute("roleList", roleList);

        List<FacilityEntity> facilityEntityList = facilityService.findAll();
        model.addAttribute("facilityList", facilityEntityList);
        return new ModelAndView("/record/search", "recordModel", model);
    }


    @ResponseBody
    @GetMapping(value = "find/{params}")
    public Map<String,Object> search1(@PathVariable String params, Model model) throws ParseException {
        Map<String, String> paramMap = ParamsUtil.parse(params);
        Map<String, Object> res = new HashMap<>();
        res.put("msg", "error");


        Integer type = Integer.valueOf(paramMap.get("type"));
        Long role = Long.valueOf(paramMap.get("role"));
        Long department = Long.valueOf(paramMap.get("department"));
        String cardid = paramMap.get("cardid");
        Long fid = Long.valueOf(paramMap.get("fid"));
        Long locate = Long.valueOf(paramMap.get("locate"));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


        Date time1 = sdf.parse(paramMap.get("time1"));
        Date time2 = sdf.parse(paramMap.get("time2"));

        List<RecordEntity> recordEntityList;
        if ("选填".equals(paramMap.get("cardid"))) {
            recordEntityList = recordService.findByTypeAndRoleAndDepartmentAndFidAndLocateAndTimeBetween(
                    type, role, department, fid,locate, time1, time2
            );
            res.put("msg", "success");
        } else {
            recordEntityList = recordService.findByTypeAndRoleAndDepartmentAndCardidAndFidAndLocateAndTimeBetween(
                    type, role, department, cardid, fid, locate, time1, time2);
            res.put("msg", "success");
        }
        res.put("recordList", recordEntityList);
        return res ;
    }


}
