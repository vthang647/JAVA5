package com.java5.assignmentjava5.responsitories;

import com.java5.assignmentjava5.entities.KhachHang;
import com.java5.assignmentjava5.entities.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Long> {

    @Query(value = "select * from nhan_vien where ma= :code",nativeQuery = true)
    public Optional<NhanVien> findByCode(@Param("code") String code);
}
