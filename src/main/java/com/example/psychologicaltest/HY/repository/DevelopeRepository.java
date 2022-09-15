package HY.repository;

import HY.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevelopeRepository extends JpaRepository<Developer, Long> {
}