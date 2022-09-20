package com.example.psychologicaltest.checkList.repository;

import com.example.psychologicaltest.checkList.entity.QueryListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckListRepository extends JpaRepository<QueryListEntity, Long> {
}
