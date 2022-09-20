package com.example.psychologicaltest.checkList.repository;

import com.example.psychologicaltest.checkList.entity.QuerySaveDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaveQueryRepository extends JpaRepository<QuerySaveDataEntity, Long> {
}
