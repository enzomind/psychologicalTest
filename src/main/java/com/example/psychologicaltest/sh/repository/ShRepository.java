package com.example.psychologicaltest.sh.repository;

import com.example.psychologicaltest.sh.entity.ShTestResultEntity;
import com.example.psychologicaltest.sh.entity.ShUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShRepository extends JpaRepository<ShTestResultEntity, Long> {


}

