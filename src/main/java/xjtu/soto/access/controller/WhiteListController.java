package xjtu.soto.access.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import xjtu.soto.access.pojo.WhitelistEntity;
import xjtu.soto.access.service.WhiteListService;

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

    @GetMapping(value = "save")
    public ModelAndView save(WhitelistEntity whitelist) {
        whiteListService.save(whitelist);
        return new ModelAndView("redirect:/whitelist/list");
    }
}
