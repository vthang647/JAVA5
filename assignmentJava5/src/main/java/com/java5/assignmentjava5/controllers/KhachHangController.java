package com.java5.assignmentjava5.controllers;

import com.java5.assignmentjava5.entities.KhachHang;
import com.java5.assignmentjava5.responsitories.KhachHangResponsitory;
import com.java5.assignmentjava5.services.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping("/admin")
public class KhachHangController {

    @Autowired
    KhachHangService khachHangService;

    @GetMapping("list-customers")
    public String getList(Model model){
        model.addAttribute("list", khachHangService.findAll());
        return "admin/khachHang/listCustomers";
    }

    @GetMapping("addOrEdit")
    public String getAddOrEdit(Model model,@ModelAttribute("khachhang") KhachHang khachHang){
        return "admin/khachHang/addOrEdit";
    }

    @PostMapping("addOrEdit")
    public String postAddOrEdit(Model model, @ModelAttribute("khachhang") KhachHang khachHang){
        try {
            khachHangService.save(khachHang);
        }catch (Exception e){
            System.out.println(e);
        }
        return "admin/khachHang/listCustomers";
    }



//    public String searchByCode(){
//        khachHangService.fi
//    }
}
