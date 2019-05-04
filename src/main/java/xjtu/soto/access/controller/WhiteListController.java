package xjtu.soto.access.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import xjtu.soto.access.pojo.WhitelistEntity;
import xjtu.soto.access.service.WhiteListService;
import xjtu.soto.access.service.impl.WhiteListServiceImpl;

import java.util.List;

@RequestMapping("/whitelist")
@RestController
public class WhiteListController {

    @Autowired
    private WhiteListService whiteListService;

    @GetMapping(value = "/list")
    public ModelAndView list(Model model) {
        List<WhitelistEntity> lists = whiteListService.findAll();
        model.addAttribute("whiteLists", lists);
        model.addAttribute("title", "白名单列表");

        return new ModelAndView("whitelist/list", "whitelistModel", model);
    }


    @GetMapping("modify/{wid}")
    public ModelAndView modify(@PathVariable("wid") Long id, Model model) {
        WhitelistEntity whitelistEntity = whiteListService.findByID(id);

        model.addAttribute("whiteList", whitelistEntity);
        model.addAttribute("title", "白名单修改");
        return new ModelAndView("whitelist/modify", "whitelistModel", model);
    }

    @PostMapping
    public ModelAndView saveOrUpdate(WhitelistEntity whitelistEntity) {
        whiteListService.save(whitelistEntity);
        return new ModelAndView("redirect:whitelist/list");
    }

    @GetMapping("/add")
    public ModelAndView add(Model model) {
        model.addAttribute("whitelist", new WhitelistEntity());
        model.addAttribute("title", "白名单管理");
        model.addAttribute("subtitle", "添加白名单");
        return new ModelAndView("whitelist/add", "whitelistMode", model);
    }
}
