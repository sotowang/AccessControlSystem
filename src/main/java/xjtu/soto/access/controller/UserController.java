package xjtu.soto.access.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import xjtu.soto.access.pojo.UserEntity;
import xjtu.soto.access.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有用户
     * @param model
     * @return
     */
    @GetMapping
    public ModelAndView list(Model model) {
        List<UserEntity> userlist = userService.findAll();
        model.addAttribute("userList", userlist);
        model.addAttribute("title", "用户管理");
        return new ModelAndView("users/list", "userModel", model);
    }

    /**
     * 根据id查询用户
     * @param id
     * @param model
     * @return
     */
    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") String id, Model model ) {
        UserEntity user = userService.findUserByCardid(id);

        model.addAttribute("user", user);
        model.addAttribute("title", "查看用户");
        return new ModelAndView("users/view", "userModel", model);
    }

    /**
     * 获取创建表单页面
     * @param model
     * @return
     */
    @GetMapping("/form")
    public ModelAndView createForm(Model model) {
        model.addAttribute("user", new UserEntity());
        model.addAttribute("title", "创建用户");

        return new ModelAndView("users/form", "userModel", model);
    }


    /**
     * 保存用户
     * @param user
     * @return
     */
    @PostMapping
    public ModelAndView saveOrUpdateUser(UserEntity user) {
        UserEntity res = userService.save(user);
        return new ModelAndView("redirect:/users");
    }


    /**
     * 删除用户
     * @param id
     * @return
     */
    @GetMapping(value = "delete/{cardid}")
    public ModelAndView delete(@PathVariable("cardid") String id) {
        userService.deleteUserByCardid(id);
        return new ModelAndView("redirect:/users");
    }

    /**
     * 获取修改用户的界面
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value = "modify/{cardid}")
    public ModelAndView modifyForm(@PathVariable("cardid") String id, Model model) {
        UserEntity user = userService.findUserByCardid(id);

        model.addAttribute("user", user);
        model.addAttribute("title", "修改用户");

        return new ModelAndView("users/form", "userModel", model);
    }



}
