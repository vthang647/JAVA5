package com.java5.assignmentjava5.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "hoa_don")
@Getter
@Setter
public class HoaDon {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kh")
    private KhachHang idKh;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_nv")
    private NhanVien idNv;

    @Column(name = "ma", length = 20)
    private String ma;

    @Column(name = "ngay_tao")
    private LocalDate ngayTao;

    @Column(name = "ngay_thanh_toan")
    private LocalDate ngayThanhToan;

    @Column(name = "ngay_ship")
    private LocalDate ngayShip;

    @Column(name = "ngay_nhan")
    private LocalDate ngayNhan;

    @Column(name = "tinh_trang")
    private Integer tinhTrang;

    @Nationalized
    @Column(name = "ten_nguoi_nhan", length = 50)
    private String tenNguoiNhan;

    @Nationalized
    @Column(name = "dia_chi", length = 100)
    private String diaChi;

    @Column(name = "sdt", length = 30)
    private String sdt;

    @Column(name = "thanh_tien", precision = 20)
    private BigDecimal thanhTien;

}