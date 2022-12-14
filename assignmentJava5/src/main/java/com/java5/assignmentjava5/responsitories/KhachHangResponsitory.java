package com.java5.assignmentjava5.responsitories;

import com.java5.assignmentjava5.entities.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface KhachHangResponsitory extends JpaRepository<KhachHang, Long> {

    @Query(value = "select * from khach_hang where ma= :code",nativeQuery = true)
    public Optional<KhachHang> findByCode(@Param("code") String code);
}
