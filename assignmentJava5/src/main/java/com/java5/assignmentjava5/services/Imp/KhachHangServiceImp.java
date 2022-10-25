package com.java5.assignmentjava5.services.Imp;

import com.java5.assignmentjava5.entities.KhachHang;
import com.java5.assignmentjava5.responsitories.KhachHangResponsitory;
import com.java5.assignmentjava5.services.KhachHangService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class KhachHangServiceImp implements KhachHangService {
    KhachHangResponsitory khachHangResponsitory;

    @Override
    public KhachHang login(String user, String passwd){
        Optional<KhachHang> khachHang = findByCode(user);
        if(khachHang.isPresent() && khachHang.get().getMatKhau().equals(passwd)){
            return khachHang.get();
        }
        return null;
    }

    @Override
    @Query(value = "select * from khach_hang where ma= :code", nativeQuery = true)
    public Optional<KhachHang> findByCode(String code) {
        return khachHangResponsitory.findByCode(code);
    }

    public KhachHangServiceImp(KhachHangResponsitory khachHangResponsitory) {
        this.khachHangResponsitory = khachHangResponsitory;
    }

    @Override
    public List<KhachHang> findAll() {
        return khachHangResponsitory.findAll();
    }

    @Override
    public List<KhachHang> findAll(Sort sort) {
        return khachHangResponsitory.findAll(sort);
    }

    @Override
    public List<KhachHang> findAllById(Iterable<Long> longs) {
        return khachHangResponsitory.findAllById(longs);
    }

    @Override
    public <S extends KhachHang> List<S> saveAll(Iterable<S> entities) {
        return khachHangResponsitory.saveAll(entities);
    }

    @Override
    public void flush() {
        khachHangResponsitory.flush();
    }

    @Override
    public <S extends KhachHang> S saveAndFlush(S entity) {
        return khachHangResponsitory.saveAndFlush(entity);
    }

    @Override
    public <S extends KhachHang> List<S> saveAllAndFlush(Iterable<S> entities) {
        return khachHangResponsitory.saveAllAndFlush(entities);
    }

    @Override
    @Deprecated
    public void deleteInBatch(Iterable<KhachHang> entities) {
        khachHangResponsitory.deleteInBatch(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<KhachHang> entities) {
        khachHangResponsitory.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {
        khachHangResponsitory.deleteAllByIdInBatch(longs);
    }

    @Override
    public void deleteAllInBatch() {
        khachHangResponsitory.deleteAllInBatch();
    }

    @Override
    @Deprecated
    public KhachHang getOne(Long aLong) {
        return khachHangResponsitory.getOne(aLong);
    }

    @Override
    @Deprecated
    public KhachHang getById(Long aLong) {
        return khachHangResponsitory.getById(aLong);
    }

    @Override
    public KhachHang getReferenceById(Long aLong) {
        return khachHangResponsitory.getReferenceById(aLong);
    }

    @Override
    public <S extends KhachHang> List<S> findAll(Example<S> example) {
        return khachHangResponsitory.findAll(example);
    }

    @Override
    public <S extends KhachHang> List<S> findAll(Example<S> example, Sort sort) {
        return khachHangResponsitory.findAll(example, sort);
    }

    @Override
    public Page<KhachHang> findAll(Pageable pageable) {
        return khachHangResponsitory.findAll(pageable);
    }

    @Override
    public <S extends KhachHang> S save(S entity) {
        return khachHangResponsitory.save(entity);
    }

    @Override
    public Optional<KhachHang> findById(Long aLong) {
        return khachHangResponsitory.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return khachHangResponsitory.existsById(aLong);
    }

    @Override
    public long count() {
        return khachHangResponsitory.count();
    }

    @Override
    public void deleteById(Long aLong) {
        khachHangResponsitory.deleteById(aLong);
    }

    @Override
    public void delete(KhachHang entity) {
        khachHangResponsitory.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        khachHangResponsitory.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends KhachHang> entities) {
        khachHangResponsitory.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        khachHangResponsitory.deleteAll();
    }

    @Override
    public <S extends KhachHang> Optional<S> findOne(Example<S> example) {
        return khachHangResponsitory.findOne(example);
    }

    @Override
    public <S extends KhachHang> Page<S> findAll(Example<S> example, Pageable pageable) {
        return khachHangResponsitory.findAll(example, pageable);
    }

    @Override
    public <S extends KhachHang> long count(Example<S> example) {
        return khachHangResponsitory.count(example);
    }

    @Override
    public <S extends KhachHang> boolean exists(Example<S> example) {
        return khachHangResponsitory.exists(example);
    }

    @Override
    public <S extends KhachHang, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return khachHangResponsitory.findBy(example, queryFunction);
    }
}
