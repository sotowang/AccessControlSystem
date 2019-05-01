package xjtu.soto.access.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import xjtu.soto.access.pojo.SecondLocateEntity;
import xjtu.soto.access.pojo.ThirdLocateEntity;
import xjtu.soto.access.pojo.TopLocateEntity;
import xjtu.soto.access.service.SecondLocateService;
import xjtu.soto.access.service.ThirdLocateService;
import xjtu.soto.access.service.TopLocateService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/locate")
public class LocateController {

    @Autowired
    private TopLocateService topLocateService;

    @Autowired
    private SecondLocateService secondLocateService;

    @Autowired
    private ThirdLocateService thirdLocateService;

    @GetMapping(value = "/edit")
    public ModelAndView edit(Model model) {
        List<TopLocateEntity> topLocateEntities = topLocateService.findAll();
        List<SecondLocateEntity> secondLocateEntities = secondLocateService.findAll();
        List<ThirdLocateEntity> thirdLocateEntities = thirdLocateService.findAll();
        model.addAttribute("title", "门禁设置管理");
        model.addAttribute("subtitle", "查看工作区");
        model.addAttribute("topLocateList", topLocateEntities);
        model.addAttribute("secondLocateList", secondLocateEntities);
        model.addAttribute("thirdLocateList", thirdLocateEntities);
        return new ModelAndView("locate/edit", "locateModel", model);
    }

    @GetMapping(value = "add")
    public ModelAndView add(Model model) {
        model.addAttribute("title", "门禁设置管理");
        model.addAttribute("subtitle", "添加工作区");
        TopLocateEntity topLocateEntity = new TopLocateEntity();
        SecondLocateEntity secondLocateEntity = new SecondLocateEntity();
        ThirdLocateEntity thirdLocateEntity = new ThirdLocateEntity();
        model.addAttribute("topLocate", topLocateEntity);
        model.addAttribute("secondLocate", secondLocateEntity);
        model.addAttribute("thirdLocate", thirdLocateEntity);

        return new ModelAndView("locate/add", "locateModel", model);
    }

    @GetMapping(value = "selectByTop/{id}")
    @ResponseBody
    public List<SecondLocateEntity> selectByTop(@PathVariable("id") Long id) {
        System.out.println(id);
        List<SecondLocateEntity> secondLocateEntities = secondLocateService.findByTop(id);
        return secondLocateEntities;
    }

//    @PostMapping
//    public ModelAndView save()
}
