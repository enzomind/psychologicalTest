package com.example.psychologicaltest.checkList.repository;

import com.example.psychologicaltest.checkList.entity.AnswerDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerDataRepository extends JpaRepository<AnswerDataEntity, Long> {
}
