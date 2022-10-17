package com.java5.assignmentjava5.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "chi_tiet_sp")
@Getter
@Setter
public class ChiTietSp {
    @Id
    @Column(name = "id_sp", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Nationalized
    @Column(name = "ten_sp", length = 100)
    private String tenSp;

    @Nationalized
    @Column(name = "nsx", length = 100)
    private String nsx;

    @Nationalized
    @Column(name = "mau_sac", length = 100)
    private String mauSac;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dong_sp")
    private DongSp idDongSp;

    @Column(name = "nam_bh")
    private Integer namBh;

    @Nationalized
    @Column(name = "mo_ta", length = 50)
    private String moTa;

    @Column(name = "so_luong_ton")
    private Integer soLuongTon;

    @Column(name = "gia_nhap", precision = 20)
    private BigDecimal giaNhap;

    @Column(name = "gia_ban", precision = 20)
    private BigDecimal giaBan;

    @Column(name = "don_gia_khi_giam", precision = 20)
    private BigDecimal donGiaKhiGiam;

}