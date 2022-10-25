package com.java5.assignmentjava5.responsitories;

import com.java5.assignmentjava5.entities.GioHang;
import com.java5.assignmentjava5.models.DongspJoinChitietSp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GioHangRepository extends JpaRepository<GioHang, Long> {
    @Query(value = "select * from gio_hang where id_sp = :code", nativeQuery = true)
    public Optional<GioHang> findByIdsp(@Param("code") int idsp);

    @Query(value = "select ten_sp,mo_ta,gia_ban,don_gia_khi_giam,ma,ngay_tao,so_luong_sp from gio_hang join chi_tiet_sp on gio_hang.id_sp = chi_tiet_sp.id_sp", nativeQuery = true)
    public List<Object[]> getInFoGioHang();
}
