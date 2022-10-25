package com.java5.assignmentjava5.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "nhan_vien")
@Getter
@Setter
public class NhanVien {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ma", length = 20)
    private String ma;

    @Nationalized
    @Column(name = "ten", length = 30)
    private String ten;

    @Nationalized
    @Column(name = "ten_dem", length = 30)
    private String tenDem;

    @Nationalized
    @Column(name = "ho", length = 30)
    private String ho;

    @Nationalized
    @Column(name = "gioi_tinh", length = 10)
    private String gioiTinh;

    @Column(name = "ngay_sinh")
    private LocalDate ngaySinh;

    @Nationalized
    @Column(name = "dia_chi", length = 100)
    private String diaChi;

    @Column(name = "sdt", length = 30)
    private String sdt;

    @Lob
    @Column(name = "mat_khau")
    private String matKhau;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ch")
    private CuaHang idCh;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cv")
    private ChucVu idCv;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_gui_bc")
    private NhanVien idGuiBc;

    @Column(name = "trang_thai")
    private Integer trangThai;

}