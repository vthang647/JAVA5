package com.java5.assignmentjava5.controllers;

import com.java5.assignmentjava5.entities.ChiTietSp;
import com.java5.assignmentjava5.entities.GioHang;
import com.java5.assignmentjava5.entities.KhachHang;
import com.java5.assignmentjava5.models.DongspJoinChitietSp;
import com.java5.assignmentjava5.services.ChiTietSpService;
import com.java5.assignmentjava5.services.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class GioHangController {
    @Autowired
    GioHangService gioHangService;

    @Autowired
    HttpSession session;

    @Autowired
    ChiTietSpService chiTietSpService;

    @GetMapping("/list-giohang")
    public String showGioHang(Model model) {
        List<GioHang> gioHangList = gioHangService.findAll();
        List<ChiTietSp> chiTietSpList = new ArrayList<>();

        for (int i = 0; i< gioHangList.size();i++){
            int iddddd = gioHangList.get(i).getIdSp().getId();
            ChiTietSp cd  = chiTietSpService.findById(iddddd);
            chiTietSpList.add(cd);
        }

        model.addAttribute("gioHangList", gioHangList);
        model.addAttribute("chiTietSpList", chiTietSpList);
        return "views/GioHang/list-gioHang";
    }

    @PostMapping("/list-giohang")
    public String showGioHangPo(Model model) {

        return "views/GioHang/list-gioHang";
    }

    @GetMapping("/list-giohang/decrease/{Id}")
    public String decreaseSoLuong(Model model, @PathVariable("Id") String Id){

        GioHang gioHang = gioHangService.findByIdsp(Integer.parseInt(Id));

            int soluongsp = gioHang.getSoLuongSp();
            gioHang.setSoLuongSp(soluongsp - 1);

            gioHangService.save(gioHang);


        List<GioHang> gioHangList = gioHangService.findAll();
        List<ChiTietSp> chiTietSpList = new ArrayList<>();

        for (int i = 0; i< gioHangList.size();i++){
            int iddddd = gioHangList.get(i).getIdSp().getId();
            ChiTietSp cd  = chiTietSpService.findById(iddddd);
            chiTietSpList.add(cd);
        }

        model.addAttribute("gioHangList", gioHangList);
        model.addAttribute("chiTietSpList", chiTietSpList);

        return "views/GioHang/list-gioHang";
    }

    @GetMapping("/list-giohang/delete/{Id}")
    public String deletespinGioHang(Model model, @PathVariable("Id") String Id){
        GioHang gioHang = gioHangService.findByIdsp(Integer.parseInt(Id));
        gioHangService.delete(gioHang);


        List<GioHang> gioHangList = gioHangService.findAll();
        List<ChiTietSp> chiTietSpList = new ArrayList<>();

        for (int i = 0; i< gioHangList.size();i++){
            int iddddd = gioHangList.get(i).getIdSp().getId();
            ChiTietSp cd  = chiTietSpService.findById(iddddd);
            chiTietSpList.add(cd);
        }

        model.addAttribute("gioHangList", gioHangList);
        model.addAttribute("chiTietSpList", chiTietSpList);

        return "views/GioHang/list-gioHang";
    }

    @GetMapping("/list-giohang/add/{Id}")
    public String addGioHang(Model model, @PathVariable("Id") String Id) {

        ChiTietSp chiTietSp = chiTietSpService.findById(Integer.parseInt(Id));

        GioHang gioHang = gioHangService.findByIdsp(Integer.parseInt(Id));


        if (gioHang == null) {
            System.out.println("gio hang is null");
            LocalDate localDate = LocalDate.now();

            GioHang gh_add = new GioHang();
            //get id khach hang
            Object khachHang = session.getAttribute("customer");
            KhachHang kh = (KhachHang) khachHang;
            //get ma gio hang
            String a = System.currentTimeMillis() + "";
            String b = a.substring(6);
            String ma = b + "-" + Id + kh.getMa();

            //set gio hang them moi
            gh_add.setIdKh(kh);
            gh_add.setIdSp(chiTietSp);
            gh_add.setSoLuongSp(1);
            gh_add.setNgayTao(localDate);
            gh_add.setMa(ma);

            //them moi
            gioHangService.save(gh_add);
        } else {
            int soluongsp = gioHang.getSoLuongSp();
            gioHang.setSoLuongSp(soluongsp + 1);

            gioHangService.save(gioHang);
        }
        List<GioHang> gioHangList = gioHangService.findAll();
        List<ChiTietSp> chiTietSpList = new ArrayList<>();

        for (int i = 0; i< gioHangList.size();i++){
            int iddddd = gioHangList.get(i).getIdSp().getId();
            ChiTietSp cd  = chiTietSpService.findById(iddddd);
            chiTietSpList.add(cd);
        }

        model.addAttribute("gioHangList", gioHangList);
        model.addAttribute("chiTietSpList", chiTietSpList);
        return "views/GioHang/list-gioHang";
    }

}

