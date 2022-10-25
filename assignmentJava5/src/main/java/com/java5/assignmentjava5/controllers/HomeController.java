package com.java5.assignmentjava5.controllers;

import com.java5.assignmentjava5.entities.ChiTietSp;
import com.java5.assignmentjava5.entities.DongSp;
import com.java5.assignmentjava5.services.ChiTietSpService;
import com.java5.assignmentjava5.services.DongSpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    ChiTietSpService chiTietSpService;

    @Autowired
    DongSpService dongSpService;

    @GetMapping("/")
    public String getRe_home(Model model,
                             @RequestParam(value = "option", defaultValue = "1") String option,
                             @RequestParam(defaultValue = "-1", name = "soft") int soft){
        List<DongSp> ls_dongsp = dongSpService.selectAll();
        int iddsp = Integer.parseInt(option);
        DongSp dsp = dongSpService.findByID(iddsp);
        List<ChiTietSp> lsCtsptheodongsp = new ArrayList<>();

        if (soft == -1){
            lsCtsptheodongsp = chiTietSpService.findByIdDongsp(dsp.getId()+"");
        } else if (soft == 0) {
            lsCtsptheodongsp = chiTietSpService.softByIdDongspDESC(dsp.getId()+"");
        } else if (soft == 1) {
            lsCtsptheodongsp = chiTietSpService.softByIdDongspASC(dsp.getId()+"");
        }

        model.addAttribute("lsctsptheodongsp", lsCtsptheodongsp);
        model.addAttribute("listDongSp", ls_dongsp);
        model.addAttribute("option", option);
        return "views/Home/home";
    }
}
