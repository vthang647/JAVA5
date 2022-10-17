package com.java5.assignmentjava5.models;

import com.java5.assignmentjava5.entities.DongSp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SanPham {
    private String tenSp;
    private String nsx;
    private String mauSac;
    private DongSp idDongSp;
    private Integer namBh;
    private String moTa;
    private Integer soLuongTon;
    private BigDecimal giaNhap;
    private BigDecimal giaBan;
    private BigDecimal donGiaKhiGiam;

}
