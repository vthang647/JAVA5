package com.java5.assignmentjava5.controllers;

import com.java5.assignmentjava5.entities.ChiTietSp;
import com.java5.assignmentjava5.entities.DongSp;
import com.java5.assignmentjava5.entities.GioHang;
import com.java5.assignmentjava5.models.SanPham;
import com.java5.assignmentjava5.services.ChiTietSpService;
import com.java5.assignmentjava5.services.DongSpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes({"AddId"})
@RequestMapping("/admin")
public class ChiTietSanPhamController {

    @Autowired
    ChiTietSpService chiTietSpService;

    @Autowired
    DongSpService dongSpService;

    @GetMapping("/list-products")
    public String getRe_view_adminCTSP(Model model, @ModelAttribute("product") SanPham product,
                                       @RequestParam( required = false,name="keywordsearch") String keyword){
        List<DongSp> ls_dongsp = dongSpService.selectAll();
        model.addAttribute("listDongSp", ls_dongsp);
        return "admin/QLSanPham/viewSanPham";
    }

    @GetMapping("/list-products/delete/{Id}")
    public String deleteSanPham(Model model,
                                @ModelAttribute("product") SanPham product ,
                                @PathVariable("Id") String Id){

        System.out.println("Id remove: "+ Id);
        List<DongSp> ls_dongsp = dongSpService.selectAll();
        model.addAttribute("listDongSp", ls_dongsp);
        return "admin/QLSanPham/viewSanPham";
    }

    @GetMapping("/list-products/{Id}")
    public String getRe_edit_adminCTSP(Model model,
                                       @ModelAttribute("product") SanPham product ,
                                       @PathVariable("Id") String Id){
        List<DongSp> ls_dongsp = dongSpService.selectAll();

        ChiTietSp chiTietSp = chiTietSpService.findById(Integer.parseInt(Id));

        product.setTenSp(chiTietSp.getTenSp());
        product.setNsx(chiTietSp.getNsx());
        product.setMauSac(chiTietSp.getMauSac());
        product.setNamBh(chiTietSp.getNamBh());
        product.setMoTa(chiTietSp.getMoTa());
        product.setIdDongSp(chiTietSp.getIdDongSp());
        product.setSoLuongTon(chiTietSp.getSoLuongTon());
        product.setGiaNhap(chiTietSp.getGiaNhap());
        product.setGiaBan(chiTietSp.getGiaBan());
        product.setDonGiaKhiGiam(chiTietSp.getDonGiaKhiGiam());

        model.addAttribute("listDongSp", ls_dongsp);

        return "admin/QLSanPham/viewSanPham";
    }

    @PostMapping("/list-products/add")
    public String getProductToAdd(@ModelAttribute("product") SanPham product,
                                  @RequestParam( required = false, name = "dongsppp") String dongSp ,Model model){
        ChiTietSp chiTietSp = new ChiTietSp();
        DongSp dongSp1 = dongSpService.findByID(Integer.parseInt(dongSp));
        chiTietSp.setTenSp(product.getTenSp());
        chiTietSp.setNsx(product.getNsx());
        chiTietSp.setMauSac(product.getMauSac());
        chiTietSp.setIdDongSp(dongSp1);
        chiTietSp.setNamBh(product.getNamBh());
        chiTietSp.setMoTa(product.getMoTa());
        chiTietSp.setSoLuongTon(product.getSoLuongTon());
        chiTietSp.setGiaNhap(product.getGiaNhap());
        chiTietSp.setGiaBan(product.getGiaBan());
        chiTietSp.setDonGiaKhiGiam(product.getDonGiaKhiGiam());
        System.out.println("chi tiet san pham: "+ chiTietSp.getTenSp());
        chiTietSpService.save(chiTietSp);
        List<DongSp> ls_dongsp = dongSpService.selectAll();
        model.addAttribute("listDongSp", ls_dongsp);
        return "admin/QLSanPham/viewSanPham";
    }


    @GetMapping("products/detail/{Id}")
    public String detailsSanPham(Model model, @PathVariable("Id") int Id) {

        return "views/SanPham/Details";
    }


}
