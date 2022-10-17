package com.java5.assignmentjava5.services.Imp;

import com.java5.assignmentjava5.entities.GioHang;
import com.java5.assignmentjava5.responsitories.GioHangRepository;
import com.java5.assignmentjava5.services.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class GioHangServiceImp implements GioHangService {
    @Autowired
    GioHangRepository gioHangRepository;

    @Override
    @Query(value = "select * from gio_hang where id_sp = :code", nativeQuery = true)
    public GioHang findById(int idsp) {
        return gioHangRepository.findById(idsp);
    }

    @Override
    public List<GioHang> findAll() {
        return gioHangRepository.findAll();
    }

    @Override
    public List<GioHang> findAll(Sort sort) {
        return gioHangRepository.findAll(sort);
    }

    @Override
    public List<GioHang> findAllById(Iterable<Long> longs) {
        return gioHangRepository.findAllById(longs);
    }

    @Override
    public <S extends GioHang> List<S> saveAll(Iterable<S> entities) {
        return gioHangRepository.saveAll(entities);
    }

    @Override
    public void flush() {
        gioHangRepository.flush();
    }

    @Override
    public <S extends GioHang> S saveAndFlush(S entity) {
        return gioHangRepository.saveAndFlush(entity);
    }

    @Override
    public <S extends GioHang> List<S> saveAllAndFlush(Iterable<S> entities) {
        return gioHangRepository.saveAllAndFlush(entities);
    }

    @Override
    @Deprecated
    public void deleteInBatch(Iterable<GioHang> entities) {
        gioHangRepository.deleteInBatch(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<GioHang> entities) {
        gioHangRepository.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {
        gioHangRepository.deleteAllByIdInBatch(longs);
    }

    @Override
    public void deleteAllInBatch() {
        gioHangRepository.deleteAllInBatch();
    }

    @Override
    @Deprecated
    public GioHang getOne(Long aLong) {
        return gioHangRepository.getOne(aLong);
    }

    @Override
    @Deprecated
    public GioHang getById(Long aLong) {
        return gioHangRepository.getById(aLong);
    }

    @Override
    public GioHang getReferenceById(Long aLong) {
        return gioHangRepository.getReferenceById(aLong);
    }

    @Override
    public <S extends GioHang> List<S> findAll(Example<S> example) {
        return gioHangRepository.findAll(example);
    }

    @Override
    public <S extends GioHang> List<S> findAll(Example<S> example, Sort sort) {
        return gioHangRepository.findAll(example, sort);
    }

    @Override
    public Page<GioHang> findAll(Pageable pageable) {
        return gioHangRepository.findAll(pageable);
    }

    @Override
    public <S extends GioHang> S save(S entity) {
        return gioHangRepository.save(entity);
    }

    @Override
    public Optional<GioHang> findById(Long aLong) {
        return gioHangRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return gioHangRepository.existsById(aLong);
    }

    @Override
    public long count() {
        return gioHangRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        gioHangRepository.deleteById(aLong);
    }

    @Override
    public void delete(GioHang entity) {
        gioHangRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        gioHangRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends GioHang> entities) {
        gioHangRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        gioHangRepository.deleteAll();
    }

    @Override
    public <S extends GioHang> Optional<S> findOne(Example<S> example) {
        return gioHangRepository.findOne(example);
    }

    @Override
    public <S extends GioHang> Page<S> findAll(Example<S> example, Pageable pageable) {
        return gioHangRepository.findAll(example, pageable);
    }

    @Override
    public <S extends GioHang> long count(Example<S> example) {
        return gioHangRepository.count(example);
    }

    @Override
    public <S extends GioHang> boolean exists(Example<S> example) {
        return gioHangRepository.exists(example);
    }

    @Override
    public <S extends GioHang, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return gioHangRepository.findBy(example, queryFunction);
    }
}
