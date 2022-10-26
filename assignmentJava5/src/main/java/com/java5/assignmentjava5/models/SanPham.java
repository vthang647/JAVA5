package com.java5.assignmentjava5.models;

import com.java5.assignmentjava5.entities.DongSp;
import lombok.*;

import javax.persistence.Entity;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SanPham {
    @NotEmpty
    private String tenSp;

    @NotEmpty
    private String nsx;

    @NotEmpty
    private String mauSac;

    private DongSp idDongSp;

    @NotNull
    private Integer namBh;

    private String moTa;

    @NotNull
    private Integer soLuongTon;

    @NotNull
    @DecimalMin(value = "0")
    private BigDecimal giaNhap;

    @NotNull
    @DecimalMin(value = "0")
    private BigDecimal giaBan;

    @NotNull
    @DecimalMin(value = "0")
    private BigDecimal donGiaKhiGiam;

}
