package xjtu.soto.access.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import xjtu.soto.access.pojo.IdentityEntity;
import xjtu.soto.access.service.RoleService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/list")
    public ModelAndView list(Model model) {
        model.addAttribute("title", "角色管理");
        model.addAttribute("subtitle", "角色列表");
        List<IdentityEntity> identityEntities = roleService.findAll();

        model.addAttribute("roleList", identityEntities);

        return new ModelAndView("/role/list", "roleModel", model);
    }

    @GetMapping(value = "delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id, Model model) {
        roleService.deleteById(Long.valueOf(id));
        return new ModelAndView("redirect:/role/list");
    }

    /**
     * 页面跳转
     * @param model
     * @return
     */
    @GetMapping(value = "add")
    public ModelAndView add(Model model) {
        IdentityEntity role = new IdentityEntity();
        model.addAttribute("title", "角色管理");
        model.addAttribute("subtitle", "角色新增");
        model.addAttribute("role", role);
        return new ModelAndView("/role/add", "roleModel",model);
    }

    @PostMapping(value = "save")
    public ModelAndView save(IdentityEntity role) {
        roleService.save(role);
        return new ModelAndView("redirect:/role/list");
    }
}