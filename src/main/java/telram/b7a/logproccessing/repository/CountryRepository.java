package telram.b7a.logproccessing.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import telram.b7a.logproccessing.model.CountryEntity;

public interface CountryRepository extends CrudRepository<CountryEntity, Integer> {

}
