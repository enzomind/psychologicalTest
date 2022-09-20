package com.example.psychologicaltest.YJ.repository;

import com.example.psychologicaltest.YJ.entity.MbtiTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MbtiTestRepository extends JpaRepository<MbtiTest, Long> {
}
