package xjtu.soto.access.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import xjtu.soto.access.pojo.*;
import xjtu.soto.access.service.DepartmentService;
import xjtu.soto.access.service.RecordService;
import xjtu.soto.access.service.RoleService;
import xjtu.soto.access.service.ThirdLocateService;

import java.util.List;

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

//    @Autowired


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


        return new ModelAndView("/record/search","recordModel", model);
    }




}
