package com.java5.assignmentjava5.services.Imp;

import com.java5.assignmentjava5.entities.DongSp;
import com.java5.assignmentjava5.responsitories.DongSpRepository;
import com.java5.assignmentjava5.services.DongSpService;
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
public class DongSpServiceImp implements DongSpService {
    @Autowired
    DongSpRepository dongSpRepository;

    @Override
    @Query(value = "select * from dong_sp where id=:id", nativeQuery = true)
    public DongSp findByID(int id) {
        return dongSpRepository.findByID(id);
    }

    @Override
    @Query(value = "select * from dong_sp", nativeQuery = true)
    public List<DongSp> selectAll() {
        return dongSpRepository.selectAll();
    }

    @Override
    public List<DongSp> findAll() {
        return dongSpRepository.findAll();
    }

    @Override
    public List<DongSp> findAll(Sort sort) {
        return dongSpRepository.findAll(sort);
    }

    @Override
    public List<DongSp> findAllById(Iterable<Long> longs) {
        return dongSpRepository.findAllById(longs);
    }

    @Override
    public <S extends DongSp> List<S> saveAll(Iterable<S> entities) {
        return dongSpRepository.saveAll(entities);
    }

    @Override
    public void flush() {
        dongSpRepository.flush();
    }

    @Override
    public <S extends DongSp> S saveAndFlush(S entity) {
        return dongSpRepository.saveAndFlush(entity);
    }

    @Override
    public <S extends DongSp> List<S> saveAllAndFlush(Iterable<S> entities) {
        return dongSpRepository.saveAllAndFlush(entities);
    }

    @Override
    @Deprecated
    public void deleteInBatch(Iterable<DongSp> entities) {
        dongSpRepository.deleteInBatch(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<DongSp> entities) {
        dongSpRepository.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {
        dongSpRepository.deleteAllByIdInBatch(longs);
    }

    @Override
    public void deleteAllInBatch() {
        dongSpRepository.deleteAllInBatch();
    }

    @Override
    @Deprecated
    public DongSp getOne(Long aLong) {
        return dongSpRepository.getOne(aLong);
    }

    @Override
    @Deprecated
    public DongSp getById(Long aLong) {
        return dongSpRepository.getById(aLong);
    }

    @Override
    public DongSp getReferenceById(Long aLong) {
        return dongSpRepository.getReferenceById(aLong);
    }

    @Override
    public <S extends DongSp> List<S> findAll(Example<S> example) {
        return dongSpRepository.findAll(example);
    }

    @Override
    public <S extends DongSp> List<S> findAll(Example<S> example, Sort sort) {
        return dongSpRepository.findAll(example, sort);
    }

    @Override
    public Page<DongSp> findAll(Pageable pageable) {
        return dongSpRepository.findAll(pageable);
    }

    @Override
    public <S extends DongSp> S save(S entity) {
        return dongSpRepository.save(entity);
    }

    @Override
    public Optional<DongSp> findById(Long aLong) {
        return dongSpRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return dongSpRepository.existsById(aLong);
    }

    @Override
    public long count() {
        return dongSpRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        dongSpRepository.deleteById(aLong);
    }

    @Override
    public void delete(DongSp entity) {
        dongSpRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        dongSpRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends DongSp> entities) {
        dongSpRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        dongSpRepository.deleteAll();
    }

    @Override
    public <S extends DongSp> Optional<S> findOne(Example<S> example) {
        return dongSpRepository.findOne(example);
    }

    @Override
    public <S extends DongSp> Page<S> findAll(Example<S> example, Pageable pageable) {
        return dongSpRepository.findAll(example, pageable);
    }

    @Override
    public <S extends DongSp> long count(Example<S> example) {
        return dongSpRepository.count(example);
    }

    @Override
    public <S extends DongSp> boolean exists(Example<S> example) {
        return dongSpRepository.exists(example);
    }

    @Override
    public <S extends DongSp, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return dongSpRepository.findBy(example, queryFunction);
    }
}
