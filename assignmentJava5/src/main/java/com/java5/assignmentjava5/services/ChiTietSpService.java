package com.java5.assignmentjava5.services;

import com.java5.assignmentjava5.entities.ChiTietSp;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface ChiTietSpService {

    @Query(value = "select * from chi_tiet_sp where id_dong_sp= :code", nativeQuery = true)
    List<ChiTietSp> findByIdDongsp(String code);

    @Query(value = "select * from chi_tiet_sp where ten_sp like %:keyword%", nativeQuery = true)
    List<ChiTietSp> findByTenSp(String keyword);

    List<ChiTietSp> findAll();

    @Query(value = "select * from chi_tiet_sp where id_sp= :code", nativeQuery = true)
    ChiTietSp findById(int code);

    List<ChiTietSp> findAll(Sort sort);

    List<ChiTietSp> findAllById(Iterable<Long> longs);

    <S extends ChiTietSp> List<S> saveAll(Iterable<S> entities);

    void flush();

    <S extends ChiTietSp> S saveAndFlush(S entity);

    <S extends ChiTietSp> List<S> saveAllAndFlush(Iterable<S> entities);

    @Deprecated
    void deleteInBatch(Iterable<ChiTietSp> entities);

    void deleteAllInBatch(Iterable<ChiTietSp> entities);

    void deleteAllByIdInBatch(Iterable<Long> longs);

    void deleteAllInBatch();

    @Deprecated
    ChiTietSp getOne(Long aLong);

    @Deprecated
    ChiTietSp getById(Long aLong);

    ChiTietSp getReferenceById(Long aLong);

    <S extends ChiTietSp> List<S> findAll(Example<S> example);

    <S extends ChiTietSp> List<S> findAll(Example<S> example, Sort sort);

    Page<ChiTietSp> findAll(Pageable pageable);

    <S extends ChiTietSp> S save(S entity);

    Optional<ChiTietSp> findById(Long aLong);

    boolean existsById(Long aLong);

    long count();

    void deleteById(Long aLong);

    void delete(ChiTietSp entity);

    void deleteAllById(Iterable<? extends Long> longs);

    void deleteAll(Iterable<? extends ChiTietSp> entities);

    void deleteAll();

    <S extends ChiTietSp> Optional<S> findOne(Example<S> example);

    <S extends ChiTietSp> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends ChiTietSp> long count(Example<S> example);

    <S extends ChiTietSp> boolean exists(Example<S> example);

    <S extends ChiTietSp, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}
