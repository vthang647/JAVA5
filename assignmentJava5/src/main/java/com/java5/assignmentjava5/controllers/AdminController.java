package com.java5.assignmentjava5.controllers;

import com.java5.assignmentjava5.entities.KhachHang;
import com.java5.assignmentjava5.entities.NhanVien;
import com.java5.assignmentjava5.models.Account;
import com.java5.assignmentjava5.models.NhanVienModel;
import com.java5.assignmentjava5.services.ChiTietSpService;
import com.java5.assignmentjava5.services.DongSpService;
import com.java5.assignmentjava5.services.KhachHangService;
import com.java5.assignmentjava5.services.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@SessionScope
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    KhachHangService khachHangService;

    @Autowired
    ChiTietSpService chiTietSpService;

    @Autowired
    DongSpService dongSpService;

    @Autowired
    NhanVienService nhanVienService;

    @Autowired
    HttpSession session;

    @GetMapping("/")
    public String getRe_admin(Model model) {
        model.addAttribute("list", khachHangService.findAll());
        return "admin/khachHang/listCustomers";
    }

    @PostMapping("/")
    public String getPo_admin(Model model) {
        model.addAttribute("list", khachHangService.findAll());
        return "admin/khachHang/listCustomers";
    }


    @GetMapping("/login")
    public String getRe_login(@ModelAttribute("account") Account account, Model model) {
        model.addAttribute("message", "");
        return "admin/adminLogin";
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("account") Account account, Model model) {


        NhanVien nhanVien = nhanVienService.findByCode(account.getMa());
        if (nhanVien != null) {
            if (nhanVien.getMa().equals(account.getMa())) {
                if (nhanVien.getMatKhau().equals(account.getMatKhau())) {
                    session.setAttribute("username", nhanVien);

                    System.out.println("login successfully!");

                    Object ruri = session.getAttribute("redirect-uri");
                    System.out.println("ruri: "+ ruri);
                    if(ruri != null){
                        session.removeAttribute("redirect-uri");
                        return new ModelAndView("redirect:"+ruri);
                    }

                    return new ModelAndView("forward:/admin/");


                } else {
                    System.out.println("mat khau nhan vien khong dung");
                    model.addAttribute("message", "Invalid username and password");
                    return new ModelAndView("admin/adminLogin");
                }
            } else {
                System.out.println("Ma nhan vien khong dung" + nhanVien.getMa() + ", " + account.getMa());
                model.addAttribute("message", "Invalid username and password");
                return new ModelAndView("admin/adminLogin");
            }
        }

        System.out.println("Nhan vien: " + account.getMatKhau());
        model.addAttribute("message", "Invalid username and password");
        return new ModelAndView("admin/adminLogin");


    }

}
