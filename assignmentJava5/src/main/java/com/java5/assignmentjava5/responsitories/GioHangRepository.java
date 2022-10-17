package com.java5.assignmentjava5.responsitories;

import com.java5.assignmentjava5.entities.GioHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GioHangRepository extends JpaRepository<GioHang, Long> {
    @Query(value = "select * from gio_hang where id_sp = :code", nativeQuery = true)
    public GioHang findById(@Param("code") int idsp);
}
