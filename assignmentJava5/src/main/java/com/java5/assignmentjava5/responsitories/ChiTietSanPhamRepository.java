package com.java5.assignmentjava5.responsitories;

import com.java5.assignmentjava5.entities.ChiTietSp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChiTietSanPhamRepository extends JpaRepository<ChiTietSp, Long> {
    @Query(value = "select * from chi_tiet_sp where id_dong_sp= :code",nativeQuery = true)
    public List<ChiTietSp> findByIdDongsp(@Param("code") String code);

    @Query(value = "select * from chi_tiet_sp where id_sp= :code",nativeQuery = true)
    public ChiTietSp findById(@Param("code") int code);

    @Query(value = "select * from chi_tiet_sp where ten_sp like %:keyword%", nativeQuery = true)
    public List<ChiTietSp> findByTenSp(@Param("keyword") String keyword);
}
