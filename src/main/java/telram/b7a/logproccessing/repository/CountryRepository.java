package telram.b7a.logproccessing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import telram.b7a.logproccessing.model.CountryEntity;

public interface CountryRepository extends JpaRepository<CountryEntity, Integer> {

}
