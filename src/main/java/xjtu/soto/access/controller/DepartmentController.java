package xjtu.soto.access.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import xjtu.soto.access.pojo.DepartmentEntity;
import xjtu.soto.access.service.DepartmentService;

import javax.jws.WebParam;
import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping(value = "add")
    public ModelAndView add(Model model) {
        model.addAttribute("title", "学院（部门管理）");
        model.addAttribute("subtitle", "学院添加");
        model.addAttribute("msg", " ");

        List<DepartmentEntity> departmentEntities = departmentService.findAll();

        DepartmentEntity departmentEntity = new DepartmentEntity();
        model.addAttribute("department", departmentEntities);
        model.addAttribute("departmentList", departmentEntities);

        return new ModelAndView("department/add", "departmentModel", model);
    }

    @PostMapping(value = "save")
    public ModelAndView save( DepartmentEntity departmentEntity, Model model) {
        model.addAttribute("title", "学院（部门管理）");
        model.addAttribute("subtitle", "学院添加");

        if (departmentEntity.getName().equals("")) {
            model.addAttribute("msg", "部门添加失败！请重试！");
        } else {
            departmentService.save(departmentEntity);
            model.addAttribute("msg", "部门添加成功！");
        }

        return new ModelAndView("redirect:/department/add", "departmentModel", model);
    }

    @GetMapping(value = "delete/{id}")
    public ModelAndView delete(@PathVariable String id) {
        departmentService.deleteById(Long.valueOf(id));

        return new ModelAndView("redirect:/department/add");
    }

}
