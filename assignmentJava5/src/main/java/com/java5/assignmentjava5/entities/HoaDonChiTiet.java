package com.java5.assignmentjava5.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "hoa_don_chi_tiet")
@Getter
@Setter
public class HoaDonChiTiet {
    @EmbeddedId
    private HoaDonChiTietId id;

    @MapsId("idHoaDon")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_hoa_don", nullable = false)
    private HoaDon idHoaDon;

    @MapsId("idChiTietSp")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_chi_tiet_sp", nullable = false)
    private ChiTietSp idChiTietSp;

    @Column(name = "so_luong")
    private Integer soLuong;

    @Column(name = "don_gia", precision = 20)
    private BigDecimal donGia;

}