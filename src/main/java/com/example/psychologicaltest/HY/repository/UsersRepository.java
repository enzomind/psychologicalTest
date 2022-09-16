package com.example.psychologicaltest.HY.repository;



import com.example.psychologicaltest.HY.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {
}
