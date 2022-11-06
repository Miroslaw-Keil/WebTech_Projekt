package htw.berlin.webtech.Projekt.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITestRepository extends JpaRepository<TestEntity, Long> {

    List<TestEntity> findAllByName(String name);
}
