package com.example.psychologicaltest.sh.repository;

import com.example.psychologicaltest.sh.entity.ShUserEntity;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface ShUserRepository2 extends JpaRepository<ShUserEntity, Long> {

    @Select("SELECT * from intellij_pj_2.sh_entity order by mid desc;")
    List<ShUserEntity> findAll();




}
