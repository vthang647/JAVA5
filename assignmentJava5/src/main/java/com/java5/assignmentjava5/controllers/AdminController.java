package com.java5.assignmentjava5.controllers;

import com.java5.assignmentjava5.services.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    KhachHangService khachHangService;
    @GetMapping("/")
    public String getRe_admin(Model model){
        model.addAttribute("list", khachHangService.findAll());
        return "admin/khachHang/listCustomers";
    }

    @GetMapping("/login")
    public String getRe_login(){
        return "admin/adminLogin";
    }
}
