package xjtu.soto.access.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import xjtu.soto.access.pojo.SecondLocateEntity;
import xjtu.soto.access.pojo.ThirdLocateEntity;
import xjtu.soto.access.pojo.TopLocateEntity;
import xjtu.soto.access.service.SecondLocateService;
import xjtu.soto.access.service.TopLocateService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/locate")
public class LocateController {

    @Autowired
    private TopLocateService topLocateService;

    @Autowired
    private SecondLocateService secondLocateService;

    @GetMapping(value = "/edit")
    public ModelAndView edit(Model model) {
        List<TopLocateEntity> topLocateEntities = topLocateService.findAll();
        List<SecondLocateEntity> secondLocateEntities = secondLocateService.findAll();
        model.addAttribute("title", "门禁设置管理");
        model.addAttribute("subtitle", "查看工作区");
        model.addAttribute("topLocateList", topLocateEntities);
        model.addAttribute("secondLocateList", secondLocateEntities);
//        model.addAttribute("thirdLocate", new ThirdLocateEntity());
        return new ModelAndView("locate/edit", "locateModel", model);
    }
}
