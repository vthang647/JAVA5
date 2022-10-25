package com.java5.assignmentjava5.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NhanVienModel {
    private String ma;
    private String ten;
    private String tenDem;
    private String ho;
    private String ngaySinh;
    private String sdt;
    private String diaChi;
    private int idCh;
    private int idCv;
    private int idGuiBc;
    private int trangThai;
}
