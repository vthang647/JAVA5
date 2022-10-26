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
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
    public String getRe_view_adminCTSP(Model model,
                                       HttpSession session,
                                       @ModelAttribute("product") SanPham product,
                                       @RequestParam(required = false, name = "keywordsearch") String keyword,
                                       @RequestParam(defaultValue = "1", name = "option") String option,
                                       @RequestParam(defaultValue = "-1", name = "soft") int soft,
                                       @RequestParam(required = false, name = "Id") String Id) {
        List<DongSp> ls_dongsp = dongSpService.selectAll();
        int iddsp = Integer.parseInt(option);
        DongSp dsp = dongSpService.findByID(iddsp);
        if (Id != null) {
            session.setAttribute("IdSession", Id);
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
        }

        String[] listSoftMode = new String[]{"Giá giảm dần", "Giá Tăng dần"};

        List<ChiTietSp> lsCtsptheodongsp = new ArrayList<>();

        if (soft == -1) {
            lsCtsptheodongsp = chiTietSpService.findByIdDongsp(dsp.getId() + "");
        } else if (soft == 0) {
            lsCtsptheodongsp = chiTietSpService.softByIdDongspDESC(dsp.getId() + "");
        } else if (soft == 1) {
            lsCtsptheodongsp = chiTietSpService.softByIdDongspASC(dsp.getId() + "");
        }

        model.addAttribute("listSoftMode", listSoftMode);
        model.addAttribute("softsp", soft);
        model.addAttribute("op", iddsp);
        model.addAttribute("listDongSp", ls_dongsp);
        model.addAttribute("selectdongsp", dsp);
        model.addAttribute("lsctsptheodongsp", lsCtsptheodongsp);

        return "admin/QLSanPham/viewSanPham";
    }

    @GetMapping("/list-products/delete/{Id}")
    public String deleteSanPham(Model model,
                                @ModelAttribute("product") SanPham product,
                                @PathVariable("Id") String Id,
                                @RequestParam(required = false, name = "keywordsearch") String keyword,
                                @RequestParam(defaultValue = "1", name = "option") String option,
                                @RequestParam(defaultValue = "-1", name = "soft") int soft) {

        ChiTietSp chiTietSp = chiTietSpService.findById(Integer.parseInt(Id));
        chiTietSpService.delete(chiTietSp);

        List<DongSp> ls_dongsp = dongSpService.selectAll();
        int iddsp = Integer.parseInt(option);
        DongSp dsp = dongSpService.findByID(iddsp);

        String[] listSoftMode = new String[]{"Giá giảm dần", "Giá Tăng dần"};

        List<ChiTietSp> lsCtsptheodongsp = new ArrayList<>();

        if (soft == -1) {
            lsCtsptheodongsp = chiTietSpService.findByIdDongsp(dsp.getId() + "");
        } else if (soft == 0) {
            lsCtsptheodongsp = chiTietSpService.softByIdDongspDESC(dsp.getId() + "");
        } else if (soft == 1) {
            lsCtsptheodongsp = chiTietSpService.softByIdDongspASC(dsp.getId() + "");
        }

        model.addAttribute("listSoftMode", listSoftMode);
        model.addAttribute("softsp", soft);
        model.addAttribute("op", iddsp);
        model.addAttribute("listDongSp", ls_dongsp);
        model.addAttribute("selectdongsp", dsp);
        model.addAttribute("lsctsptheodongsp", lsCtsptheodongsp);
        return "admin/QLSanPham/viewSanPham";
    }

    @PostMapping("/list-products/add")
    public String getProductToAdd(@Validated @ModelAttribute("product") SanPham product,BindingResult result,
                                  @RequestParam(required = false, name = "dongsppp") String dongSp,
                                  @RequestParam(required = false, name = "keywordsearch") String keyword,
                                  @RequestParam(defaultValue = "1", name = "option") String option,
                                  @RequestParam(defaultValue = "-1", name = "soft") int soft,
                                  @RequestParam(required = false, name = "Id") String Id,
                                  Model model) {

        if (result.hasErrors()) {
            return "admin/error/error";
        }


        List<DongSp> ls_dongsp = dongSpService.selectAll();
        int iddsp = Integer.parseInt(option);
        DongSp dsp = dongSpService.findByID(iddsp);
        if (Id != null) {
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
        }

        String[] listSoftMode = new String[]{"Giá giảm dần", "Giá Tăng dần"};

        List<ChiTietSp> lsCtsptheodongsp = new ArrayList<>();

        if (soft == -1) {
            lsCtsptheodongsp = chiTietSpService.findByIdDongsp(dsp.getId() + "");
        } else if (soft == 0) {
            lsCtsptheodongsp = chiTietSpService.softByIdDongspDESC(dsp.getId() + "");
        } else if (soft == 1) {
            lsCtsptheodongsp = chiTietSpService.softByIdDongspASC(dsp.getId() + "");
        }
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

        chiTietSpService.save(chiTietSp);
        System.out.println("dongsp: " + dongSp);

        model.addAttribute("listSoftMode", listSoftMode);
        model.addAttribute("softsp", soft);
        model.addAttribute("op", iddsp);
        model.addAttribute("listDongSp", ls_dongsp);
        model.addAttribute("selectdongsp", dsp);
        model.addAttribute("lsctsptheodongsp", lsCtsptheodongsp);
        return "admin/QLSanPham/viewSanPham";
    }

    @PostMapping(value = "/list-products/add", params = "action=update")
    public ModelAndView Update(@Validated @ModelAttribute("product") SanPham product,
                               BindingResult result,
                               HttpSession session,
                               @RequestParam(required = false, name = "dongsppp") String dongSp,
                               @RequestParam(required = false, name = "keywordsearch") String keyword,
                               @RequestParam(defaultValue = "1", name = "option") String option,
                               @RequestParam(defaultValue = "-1", name = "soft") int soft,
                               @RequestParam(required = false, name = "Id") String Id,
                               @SessionAttribute("IdSession") String Ids) {
        ModelAndView modelAndView = new ModelAndView("admin/QLSanPham/viewSanPham");
        if (result.hasErrors()) {
            return new ModelAndView("admin/error/error");
        }


        List<DongSp> ls_dongsp = dongSpService.selectAll();
        int iddsp = Integer.parseInt(option);
        DongSp dsp = dongSpService.findByID(iddsp);
        if (Id != null) {
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
        }

        String[] listSoftMode = new String[]{"Giá giảm dần", "Giá Tăng dần"};

        List<ChiTietSp> lsCtsptheodongsp = new ArrayList<>();

        if (soft == -1) {
            lsCtsptheodongsp = chiTietSpService.findByIdDongsp(dsp.getId() + "");
        } else if (soft == 0) {
            lsCtsptheodongsp = chiTietSpService.softByIdDongspDESC(dsp.getId() + "");
        } else if (soft == 1) {
            lsCtsptheodongsp = chiTietSpService.softByIdDongspASC(dsp.getId() + "");
        }
        ChiTietSp chiTietSp = new ChiTietSp();
        DongSp dongSp1 = dongSpService.findByID(Integer.parseInt(dongSp));

        chiTietSp.setId(Integer.parseInt(Ids));
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

        chiTietSpService.save(chiTietSp);


        modelAndView.addObject("listSoftMode", listSoftMode);
        modelAndView.addObject("softsp", soft);
        modelAndView.addObject("op", iddsp);
        modelAndView.addObject("listDongSp", ls_dongsp);
        modelAndView.addObject("selectdongsp", dsp);
        modelAndView.addObject("lsctsptheodongsp", lsCtsptheodongsp);

        return modelAndView;
    }

    @GetMapping("products/detail/{Id}")
    public String detailsSanPham(Model model, @PathVariable("Id") int Id) {

        return "views/SanPham/Details";
    }

    @GetMapping("/error")
    public String getEr() {
        return "/admin/error/error";
    }

    @PostMapping("/error")
    public String poEr() {
        return "/admin/error/error";
    }
}
