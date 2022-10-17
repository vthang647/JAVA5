package com.java5.assignmentjava5.controllers;

import com.java5.assignmentjava5.entities.DongSp;
import com.java5.assignmentjava5.services.ChiTietSpService;
import com.java5.assignmentjava5.services.DongSpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    ChiTietSpService chiTietSpService;

    @Autowired
    DongSpService dongSpService;

    @GetMapping("")
    public String getRe_home(Model model){
        List<DongSp> ls_dongsp = dongSpService.selectAll();
        model.addAttribute("listDongSp", ls_dongsp);
        model.addAttribute("add", "ADD");
        return "views/Home/home";
    }
}
