package com.java5.assignmentjava5.controllers;

import com.java5.assignmentjava5.entities.KhachHang;
import com.java5.assignmentjava5.models.KhachHangModel;
import com.java5.assignmentjava5.services.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class loginKhachHangController {

    @Autowired
    KhachHangService khachHangService;

    @Autowired
    HttpSession session;

    @GetMapping("/customer/login")
    public String login(Model model, @ModelAttribute("kh") KhachHangModel khachHangModel){
        model.addAttribute("message", "");
        return "views/KhachHang/loginKhachHang";
    }

    @PostMapping("/customer/login")
    public String loginP(Model model,  @ModelAttribute("kh") KhachHangModel khachHangModel){

        KhachHang khachHang = khachHangService.login(khachHangModel.getMa(), khachHangModel.getMatKhau());

        if (khachHang== null){
            model.addAttribute("message", "Invalid username and password");
            return "views/KhachHang/loginKhachHang";
        }

        session.setAttribute("customer", khachHang);
        Object ruri = session.getAttribute("redirect-uri-cus");
        if (ruri != null){
            session.removeAttribute("redirect-uri-cus");
            return "redirect:"+ruri;
        }
        return "forward:/list-giohang";
    }
}
