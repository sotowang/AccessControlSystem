package xjtu.soto.access.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import xjtu.soto.access.pojo.FacilityEntity;
import xjtu.soto.access.pojo.ThirdLocateEntity;
import xjtu.soto.access.service.FacilityService;
import xjtu.soto.access.service.ThirdLocateService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "facility")
public class FacilityController {

    @Autowired
    private FacilityService facilityService;

    @Autowired
    private ThirdLocateService thirdLocateService;

    @GetMapping(value = "list")
    public ModelAndView list(Model model) {
        model.addAttribute("title", "门禁设置管理");
        model.addAttribute("subtitle", "设备管理");

        List<FacilityEntity> facilityEntityList = facilityService.findAll();
        for (FacilityEntity facility : facilityEntityList) {
            Long locate = facility.getLocate();
            if (locate != null) {
                ThirdLocateEntity thirdLocateEntity = thirdLocateService.findById(facility.getLocate());
                String address = thirdLocateEntity.getAddress();
                facility.setAddress(address);
            } else {
                facility.setAddress("NULL");
            }
        }

        model.addAttribute("facilityList", facilityEntityList);


        return new ModelAndView("/facility/list", "facilityModel", model);
    }

    @GetMapping(value = "delete/{fid}")
    public ModelAndView delete(@PathVariable("fid")String id) {
        facilityService.deleteById(Long.valueOf(id));
        return new ModelAndView("redirect:/facility/list");
    }

    @GetMapping(value = "edit/{fid}")
    public ModelAndView edit(@PathVariable String fid, Model model) {
        FacilityEntity facilityEntity = facilityService.findById(Long.valueOf(fid));

        Long locate = facilityEntity.getLocate();

        if (locate != null) {
            ThirdLocateEntity thirdLocateEntity = thirdLocateService.findById(locate);
            String address = thirdLocateEntity.getAddress();
            facilityEntity.setAddress(address);
        } else {
            facilityEntity.setAddress("NULL");
        }



        List<ThirdLocateEntity> thirdLocateEntityList = thirdLocateService.findAll();

        model.addAttribute("title", "门禁设置管理");
        model.addAttribute("subtitle", "设备管理");
        model.addAttribute("facility", facilityEntity);
        model.addAttribute("thirdLocateList", thirdLocateEntityList);


        return new ModelAndView("facility/edit", "facilityModel", model);
    }

    @PostMapping(value = "save")
    public ModelAndView save(FacilityEntity facilityEntity, BindingResult bindingResult,Model model) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date startTime = facilityEntity.getStartTime();
        Date endTime = facilityEntity.getEndTime();
        if (startTime == null) {
            try {
                facilityEntity.setStartTime(sdf.parse("00:00:01"));
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
        if (endTime == null) {
            try {
                facilityEntity.setEndTime(sdf.parse("23:59:59"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }


        facilityService.save(facilityEntity);

        model.addAttribute("title", "门禁设置管理");
        model.addAttribute("subtitle", "设备管理");
        return new ModelAndView("redirect:/facility/list/","facilityModel",model);
    }

    @GetMapping(value = "add")
    public ModelAndView add(Model model) {
        FacilityEntity facilityEntity = new FacilityEntity();
        model.addAttribute("facility", facilityEntity);
        model.addAttribute("title", "门禁设置管理");
        model.addAttribute("subtitle", "添加设备");

        List<ThirdLocateEntity> thirdLocateEntityList = thirdLocateService.findAll();
        model.addAttribute("thirdLocateList", thirdLocateEntityList);


        return new ModelAndView("/facility/add", "facilityModel", model);
    }

}
