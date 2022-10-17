package com.java5.assignmentjava5.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cua_hang")
@Setter
@Getter
public class CuaHang {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "ma", length = 20)
    private String ma;

    @Nationalized
    @Column(name = "ten", length = 50)
    private String ten;

    @Nationalized
    @Column(name = "dia_chi", length = 100)
    private String diaChi;

    @Nationalized
    @Column(name = "thanh_pho", length = 50)
    private String thanhPho;

    @Nationalized
    @Column(name = "quoc_gia", length = 50)
    private String quocGia;
}