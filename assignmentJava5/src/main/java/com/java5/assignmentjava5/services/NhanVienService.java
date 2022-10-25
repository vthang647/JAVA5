package com.java5.assignmentjava5.services;

import com.java5.assignmentjava5.entities.NhanVien;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NhanVienService{


    @Query(value = "select * from nhan_vien where ma= :code", nativeQuery = true)
    NhanVien findByCode(String code);

    List<NhanVien> findAll();

    List<NhanVien> findAll(Sort sort);

    List<NhanVien> findAllById(Iterable<Long> longs);

    @Deprecated
    NhanVien getById(Long aLong);

    <S extends NhanVien> S save(S entity);

    void delete(NhanVien entity);

    <S extends NhanVien> boolean exists(Example<S> example);
}
