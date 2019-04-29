package xjtu.soto.access.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import xjtu.soto.access.pojo.RecordEntity;
import xjtu.soto.access.service.RecordService;

import java.util.List;

@RestController
@RequestMapping("/record")
@Slf4j
public class RecordController {

    @Autowired
    RecordService recordService;
    @GetMapping
    public ModelAndView list(Model model) {
        List<RecordEntity> recordEntities = recordService.findAll();

        model.addAttribute("recordList", recordEntities);

        return new ModelAndView("/record/list", "recordModel", model);
    }

}
