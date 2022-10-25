package com.java5.assignmentjava5.services.Imp;

import com.java5.assignmentjava5.entities.ChiTietSp;
import com.java5.assignmentjava5.responsitories.ChiTietSanPhamRepository;
import com.java5.assignmentjava5.services.ChiTietSpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@Component
public class ChiTietSpServiceImp implements ChiTietSpService {

    @Autowired
    ChiTietSanPhamRepository chiTietSanPhamRepository;

    @Override
    @Query(value = "select * from chi_tiet_sp where id_dong_sp= :code", nativeQuery = true)
    public List<ChiTietSp> findByIdDongsp(String code) {
        return chiTietSanPhamRepository.findByIdDongsp(code);
    }

    @Override
    @Query(value = "select * from chi_tiet_sp where id_dong_sp= :code order by don_gia_khi_giam DESC", nativeQuery = true)
    public List<ChiTietSp> softByIdDongspDESC(String code) {
        return chiTietSanPhamRepository.softByIdDongspDESC(code);
    }

    @Override
    @Query(value = "select * from chi_tiet_sp where id_dong_sp= :code  order by don_gia_khi_giam ASC", nativeQuery = true)
    public List<ChiTietSp> softByIdDongspASC(String code) {
        return chiTietSanPhamRepository.softByIdDongspASC(code);
    }

    @Override
    @Query(value = "select * from chi_tiet_sp where ten_sp like %:keyword%", nativeQuery = true)
    public List<ChiTietSp> findByTenSp(String keyword) {
        return chiTietSanPhamRepository.findByTenSp(keyword);
    }

    @Override
    public List<ChiTietSp> findAll() {
        return chiTietSanPhamRepository.findAll();
    }

    @Override
    @Query(value = "select * from chi_tiet_sp where id_sp= :code", nativeQuery = true)
    public ChiTietSp findById(int code) {
        return chiTietSanPhamRepository.findById(code);
    }

    @Override
    public List<ChiTietSp> findAll(Sort sort) {
        return chiTietSanPhamRepository.findAll(sort);
    }

    @Override
    public List<ChiTietSp> findAllById(Iterable<Long> longs) {
        return chiTietSanPhamRepository.findAllById(longs);
    }

    @Override
    public <S extends ChiTietSp> List<S> saveAll(Iterable<S> entities) {
        return chiTietSanPhamRepository.saveAll(entities);
    }

    @Override
    public void flush() {
        chiTietSanPhamRepository.flush();
    }

    @Override
    public <S extends ChiTietSp> S saveAndFlush(S entity) {
        return chiTietSanPhamRepository.saveAndFlush(entity);
    }

    @Override
    public <S extends ChiTietSp> List<S> saveAllAndFlush(Iterable<S> entities) {
        return chiTietSanPhamRepository.saveAllAndFlush(entities);
    }

    @Override
    @Deprecated
    public void deleteInBatch(Iterable<ChiTietSp> entities) {
        chiTietSanPhamRepository.deleteInBatch(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<ChiTietSp> entities) {
        chiTietSanPhamRepository.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {
        chiTietSanPhamRepository.deleteAllByIdInBatch(longs);
    }

    @Override
    public void deleteAllInBatch() {
        chiTietSanPhamRepository.deleteAllInBatch();
    }

    @Override
    @Deprecated
    public ChiTietSp getOne(Long aLong) {
        return chiTietSanPhamRepository.getOne(aLong);
    }

    @Override
    @Deprecated
    public ChiTietSp getById(Long aLong) {
        return chiTietSanPhamRepository.getById(aLong);
    }

    @Override
    public ChiTietSp getReferenceById(Long aLong) {
        return chiTietSanPhamRepository.getReferenceById(aLong);
    }

    @Override
    public <S extends ChiTietSp> List<S> findAll(Example<S> example) {
        return chiTietSanPhamRepository.findAll(example);
    }

    @Override
    public <S extends ChiTietSp> List<S> findAll(Example<S> example, Sort sort) {
        return chiTietSanPhamRepository.findAll(example, sort);
    }

    @Override
    public Page<ChiTietSp> findAll(Pageable pageable) {
        return chiTietSanPhamRepository.findAll(pageable);
    }

    @Override
    public <S extends ChiTietSp> S save(S entity) {
        return chiTietSanPhamRepository.save(entity);
    }

    @Override
    public Optional<ChiTietSp> findById(Long aLong) {
        return chiTietSanPhamRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return chiTietSanPhamRepository.existsById(aLong);
    }

    @Override
    public long count() {
        return chiTietSanPhamRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        chiTietSanPhamRepository.deleteById(aLong);
    }

    @Override
    public void delete(ChiTietSp entity) {
        chiTietSanPhamRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        chiTietSanPhamRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends ChiTietSp> entities) {
        chiTietSanPhamRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        chiTietSanPhamRepository.deleteAll();
    }

    @Override
    public <S extends ChiTietSp> Optional<S> findOne(Example<S> example) {
        return chiTietSanPhamRepository.findOne(example);
    }

    @Override
    public <S extends ChiTietSp> Page<S> findAll(Example<S> example, Pageable pageable) {
        return chiTietSanPhamRepository.findAll(example, pageable);
    }

    @Override
    public <S extends ChiTietSp> long count(Example<S> example) {
        return chiTietSanPhamRepository.count(example);
    }

    @Override
    public <S extends ChiTietSp> boolean exists(Example<S> example) {
        return chiTietSanPhamRepository.exists(example);
    }

    @Override
    public <S extends ChiTietSp, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return chiTietSanPhamRepository.findBy(example, queryFunction);
    }


}
