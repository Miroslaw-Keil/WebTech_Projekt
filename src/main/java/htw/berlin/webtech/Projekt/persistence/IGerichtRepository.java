package htw.berlin.webtech.Projekt.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGerichtRepository extends JpaRepository<GerichtEntity, Long> {

    List<GerichtEntity> findAllByName(String name);
}
