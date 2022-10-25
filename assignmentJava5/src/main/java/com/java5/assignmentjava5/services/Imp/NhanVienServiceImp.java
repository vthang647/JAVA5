package com.java5.assignmentjava5.services.Imp;

import com.java5.assignmentjava5.entities.NhanVien;
import com.java5.assignmentjava5.responsitories.NhanVienRepository;
import com.java5.assignmentjava5.services.NhanVienService;
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
public class NhanVienServiceImp implements NhanVienService {

    @Autowired
    NhanVienRepository nhanVienRepository;

    @Override
    @Query(value = "select * from nhan_vien where ma= :code", nativeQuery = true)
    public NhanVien findByCode(String code) {
        Optional<NhanVien> nhanVien = nhanVienRepository.findByCode(code);

        if(nhanVien.isPresent()){
            return nhanVien.get();
        }
        return null;
    }

    @Override
    public List<NhanVien> findAll() {
        return nhanVienRepository.findAll();
    }

    @Override
    public List<NhanVien> findAll(Sort sort) {
        return nhanVienRepository.findAll(sort);
    }

    @Override
    public List<NhanVien> findAllById(Iterable<Long> longs) {
        return nhanVienRepository.findAllById(longs);
    }

    public <S extends NhanVien> List<S> saveAll(Iterable<S> entities) {
        return nhanVienRepository.saveAll(entities);
    }

    public void flush() {
        nhanVienRepository.flush();
    }

    public <S extends NhanVien> S saveAndFlush(S entity) {
        return nhanVienRepository.saveAndFlush(entity);
    }

    public <S extends NhanVien> List<S> saveAllAndFlush(Iterable<S> entities) {
        return nhanVienRepository.saveAllAndFlush(entities);
    }

    @Deprecated
    public void deleteInBatch(Iterable<NhanVien> entities) {
        nhanVienRepository.deleteInBatch(entities);
    }

    public void deleteAllInBatch(Iterable<NhanVien> entities) {
        nhanVienRepository.deleteAllInBatch(entities);
    }

    public void deleteAllByIdInBatch(Iterable<Long> longs) {
        nhanVienRepository.deleteAllByIdInBatch(longs);
    }

    public void deleteAllInBatch() {
        nhanVienRepository.deleteAllInBatch();
    }

    @Deprecated
    public NhanVien getOne(Long aLong) {
        return nhanVienRepository.getOne(aLong);
    }

    @Override
    @Deprecated
    public NhanVien getById(Long aLong) {
        return nhanVienRepository.getById(aLong);
    }

    public NhanVien getReferenceById(Long aLong) {
        return nhanVienRepository.getReferenceById(aLong);
    }

    public <S extends NhanVien> List<S> findAll(Example<S> example) {
        return nhanVienRepository.findAll(example);
    }

    public <S extends NhanVien> List<S> findAll(Example<S> example, Sort sort) {
        return nhanVienRepository.findAll(example, sort);
    }

    public Page<NhanVien> findAll(Pageable pageable) {
        return nhanVienRepository.findAll(pageable);
    }

    @Override
    public <S extends NhanVien> S save(S entity) {
        return nhanVienRepository.save(entity);
    }

    public Optional<NhanVien> findById(Long aLong) {
        return nhanVienRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return nhanVienRepository.existsById(aLong);
    }

    public long count() {
        return nhanVienRepository.count();
    }

    public void deleteById(Long aLong) {
        nhanVienRepository.deleteById(aLong);
    }

    @Override
    public void delete(NhanVien entity) {
        nhanVienRepository.delete(entity);
    }

    public void deleteAllById(Iterable<? extends Long> longs) {
        nhanVienRepository.deleteAllById(longs);
    }

    public void deleteAll(Iterable<? extends NhanVien> entities) {
        nhanVienRepository.deleteAll(entities);
    }

    public void deleteAll() {
        nhanVienRepository.deleteAll();
    }

    public <S extends NhanVien> Optional<S> findOne(Example<S> example) {
        return nhanVienRepository.findOne(example);
    }

    public <S extends NhanVien> Page<S> findAll(Example<S> example, Pageable pageable) {
        return nhanVienRepository.findAll(example, pageable);
    }

    public <S extends NhanVien> long count(Example<S> example) {
        return nhanVienRepository.count(example);
    }

    @Override
    public <S extends NhanVien> boolean exists(Example<S> example) {
        return nhanVienRepository.exists(example);
    }

    public <S extends NhanVien, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return nhanVienRepository.findBy(example, queryFunction);
    }
}
