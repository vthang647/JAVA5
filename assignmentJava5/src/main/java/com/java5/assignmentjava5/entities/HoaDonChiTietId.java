package com.java5.assignmentjava5.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class HoaDonChiTietId implements Serializable {
    private static final long serialVersionUID = -3496655109174401907L;
    @Column(name = "id_hoa_don", nullable = false)
    private Integer idHoaDon;

    @Column(name = "id_chi_tiet_sp", nullable = false)
    private Integer idChiTietSp;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        HoaDonChiTietId entity = (HoaDonChiTietId) o;
        return Objects.equals(this.idHoaDon, entity.idHoaDon) &&
                Objects.equals(this.idChiTietSp, entity.idChiTietSp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHoaDon, idChiTietSp);
    }

}