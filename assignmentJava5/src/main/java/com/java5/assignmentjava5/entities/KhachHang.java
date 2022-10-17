package com.java5.assignmentjava5.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "khach_hang")
@Getter
@Setter
public class KhachHang {
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

    @Column(name = "ngay_sinh")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngaySinh;

    @Column(name = "sdt", length = 30)
    private String sdt;

    @Nationalized
    @Column(name = "dia_chi", length = 100)
    private String diaChi;

    @Nationalized
    @Column(name = "thanh_pho", length = 50)
    private String thanhPho;

    @Nationalized
    @Column(name = "quoc_gia", length = 50)
    private String quocGia;

    @Lob
    @Column(name = "mat_khau")
    private String matKhau;

}