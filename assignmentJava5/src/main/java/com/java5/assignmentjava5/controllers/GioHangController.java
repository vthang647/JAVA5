package com.java5.assignmentjava5.controllers;

import com.java5.assignmentjava5.entities.ChiTietSp;
import com.java5.assignmentjava5.entities.GioHang;
import com.java5.assignmentjava5.services.ChiTietSpService;
import com.java5.assignmentjava5.services.GioHangService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class GioHangController {
    @Autowired
    GioHangService gioHangService;

    @Autowired
    ChiTietSpService chiTietSpService;

    @GetMapping("list-giohang")
    public String showGioHang(Model model) {

        return "views/GioHang/list-gioHang";
    }

    @GetMapping("list-giohang/add/{Id}")
    public String addGioHang(Model model, @PathVariable("Id") int Id) {
        List<GioHang> lsgh = gioHangService.findAll();

        GioHang gioHangDB = gioHangService.findById(Id);

        System.out.println("Gio hang in db: " + gioHangDB.getSoLuongSp());
        ChiTietSp chiTietSp = chiTietSpService.findById(Id);
        GioHang gh = new GioHang();
        gh.setIdSp(chiTietSp);
        if (gioHangDB == null) {
            gh.setSoLuongSp(1);
            gioHangService.save(gh);
        } else {
            gh.setSoLuongSp(gioHangDB.getSoLuongSp() + 1);
            gioHangService.save(gh);
        }

        model.addAttribute("lsgiohang", lsgh);
        return "views/GioHang/list-gioHang";
    }

}

