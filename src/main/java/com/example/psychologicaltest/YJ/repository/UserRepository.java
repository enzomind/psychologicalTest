package com.example.psychologicaltest.YJ.repository;

import com.example.psychologicaltest.YJ.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
