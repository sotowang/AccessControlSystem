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
//        List<SecondLocateEntity> secondLocateEntities = secondLocateService.findAll();
//        List<ThirdLocateEntity> thirdLocateEntities = thirdLocateService.findAll();
        model.addAttribute("title", "工作区设置管理");
        model.addAttribute("subtitle", "设置工作区");
        model.addAttribute("topLocateList", topLocateEntities);
//        model.addAttribute("secondLocateList", secondLocateEntities);
//        model.addAttribute("thirdLocateList", thirdLocateEntities);
        return new ModelAndView("locate/edit", "locateModel", model);
    }

    @GetMapping(value = "add")
    public ModelAndView add(Model model) {
        model.addAttribute("title", "工作区设置管理");
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
        List<SecondLocateEntity> secondLocateEntities = secondLocateService.findByTop(id);
        return secondLocateEntities;
    }
    @GetMapping(value = "selectBySecond/{id}")
    @ResponseBody
    public List<ThirdLocateEntity> selectBySecond(@PathVariable("id") Long id) {
        List<ThirdLocateEntity> thirdLocateEntities = thirdLocateService.findByTop(id);
        return thirdLocateEntities;
    }

    @GetMapping(value = "deletetop/{id}")
    @ResponseBody
    public void deleteTop(@PathVariable("id") Long id) {
        topLocateService.deleteById(id);
    }
    @GetMapping(value = "deletesecond2/{id}")
    @ResponseBody
    public void deleteSecond(@PathVariable("id") Long id) {
        secondLocateService.deleteById(id);
    }
    @GetMapping(value = "deletethird3/{id}")
    @ResponseBody
    public void deleteThird(@PathVariable("id") Long id) {
        thirdLocateService.deleteById(id);
    }

    @GetMapping(value = "save/{locate}/{address}")
    @ResponseBody
    public String save(@PathVariable("locate") String locate, @PathVariable("address") String address) {
        if (locate.equals("top")) {
            TopLocateEntity topLocateEntity = new TopLocateEntity();
            topLocateEntity.setAddress(address);
            topLocateService.save(topLocateEntity);
        } else if (locate.equals("second")) {
            SecondLocateEntity secondLocateEntity = new SecondLocateEntity();
            Long topId = Long.valueOf(address.split("-")[0]);
            address = address.split("-")[1];

            secondLocateEntity.setAddress(address);
            secondLocateEntity.setTop(topId);
            secondLocateService.save(secondLocateEntity);
        } else if (locate.equals("third")) {
            ThirdLocateEntity thirdLocateEntity = new ThirdLocateEntity();
            Long secondId = Long.valueOf(address.split("-")[0]);
            address = address.split("-")[1];

            thirdLocateEntity.setAddress(address);
            thirdLocateEntity.setTop(secondId);
            thirdLocateService.save(thirdLocateEntity);
        }
        return "success";
    }
}
