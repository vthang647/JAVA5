package com.java5.assignmentjava5.services;

import com.java5.assignmentjava5.entities.GioHang;
import com.java5.assignmentjava5.models.DongspJoinChitietSp;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface GioHangService {


//    @Query(value = "select * from gio_hang where id_sp = :code", nativeQuery = true)
    GioHang findByIdsp(int idsp);


    @Query(value = "select ten_sp,mo_ta,gia_ban,don_gia_khi_giam,ma,ngay_tao,so_luong_sp from gio_hang join chi_tiet_sp on gio_hang.id_sp = chi_tiet_sp.id_sp", nativeQuery = true)
    List<Object[]> getInFoGioHang();

    List<GioHang> findAll();

    List<GioHang> findAll(Sort sort);

    List<GioHang> findAllById(Iterable<Long> longs);

    <S extends GioHang> List<S> saveAll(Iterable<S> entities);

    void flush();

    <S extends GioHang> S saveAndFlush(S entity);

    <S extends GioHang> List<S> saveAllAndFlush(Iterable<S> entities);

    @Deprecated
    void deleteInBatch(Iterable<GioHang> entities);

    void deleteAllInBatch(Iterable<GioHang> entities);

    void deleteAllByIdInBatch(Iterable<Long> longs);

    void deleteAllInBatch();

    @Deprecated
    GioHang getOne(Long aLong);

    @Deprecated
    GioHang getById(Long aLong);

    GioHang getReferenceById(Long aLong);

    <S extends GioHang> List<S> findAll(Example<S> example);

    <S extends GioHang> List<S> findAll(Example<S> example, Sort sort);

    Page<GioHang> findAll(Pageable pageable);

    <S extends GioHang> S save(S entity);

    Optional<GioHang> findById(Long aLong);

    boolean existsById(Long aLong);

    long count();

    void deleteById(Long aLong);

    void delete(GioHang entity);

    void deleteAllById(Iterable<? extends Long> longs);

    void deleteAll(Iterable<? extends GioHang> entities);

    void deleteAll();

    <S extends GioHang> Optional<S> findOne(Example<S> example);

    <S extends GioHang> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends GioHang> long count(Example<S> example);

    <S extends GioHang> boolean exists(Example<S> example);

    <S extends GioHang, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}
