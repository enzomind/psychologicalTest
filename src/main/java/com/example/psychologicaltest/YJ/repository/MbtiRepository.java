package com.example.psychologicaltest.YJ.repository;

import com.example.psychologicaltest.YJ.entity.Mbti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MbtiRepository extends JpaRepository<Mbti, Long> {
}
