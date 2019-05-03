package xjtu.soto.access.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import xjtu.soto.access.pojo.FacilityEntity;
import xjtu.soto.access.pojo.ThirdLocateEntity;
import xjtu.soto.access.service.FacilityService;
import xjtu.soto.access.service.ThirdLocateService;

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
    public ModelAndView save(FacilityEntity facilityEntity,Model model) {
        facilityService.save(facilityEntity);

        model.addAttribute("title", "门禁设置管理");
        model.addAttribute("subtitle", "设备管理");
        return new ModelAndView("redirect:/facility/list/","facilityModel",model);
    }

}
