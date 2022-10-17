package com.java5.assignmentjava5.responsitories;

import com.java5.assignmentjava5.entities.DongSp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DongSpRepository extends JpaRepository<DongSp, Long> {
    @Query(value = "select * from dong_sp", nativeQuery = true)
    public List<DongSp> selectAll();
    @Query(value = "select * from dong_sp where id=:id", nativeQuery = true)
    public DongSp findByID(@Param("id") int id);
}
