package xjtu.soto.access.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import xjtu.soto.access.pojo.UserEntity;
import xjtu.soto.access.service.UserService;

@RestController
@Slf4j
public class MainController {

    @Autowired
    private UserService userService;


    @GetMapping("/")
    public ModelAndView root(Model model) {
        model.addAttribute("title", "门禁管理系统");
        model.addAttribute("msg", " ");
        return new ModelAndView("module/login", "mainModel", model);
    }

    @GetMapping("/login")
    public ModelAndView login(Model model) {
        model.addAttribute("msg", " ");
        return new ModelAndView("module/login","mainModel",model);
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        model.addAttribute("errorMsg", "登陆失败，用户名或者密码错误");
        return "module/login";
    }

    @PostMapping("login")
    public ModelAndView postlogin(@RequestParam String cardid,@RequestParam String password, Model model) {

        UserEntity user = userService.findUserByCardid(cardid);
        if (user != null) {
            if (cardid.equals(user.getCardid()) &&
                    password.equals(user.getPassword())) {
                return new ModelAndView("module/index");
            }
        }
        model.addAttribute("msg", "登陆失败，请检查账号或密码");
        return new ModelAndView("module/login","mainModel",model);
    }


}
