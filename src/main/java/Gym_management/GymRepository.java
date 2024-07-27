package Gym_management;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GymRepository extends JpaRepository<Gym, Long> {
    @Query(value="Select * from School where id =?1", nativeQuery = true)
    public List<Gym> search(@Param("keyword") Long id);
}
