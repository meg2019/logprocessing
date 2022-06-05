package telram.b7a.logprocessing.repository;

import org.springframework.data.repository.CrudRepository;
import telram.b7a.logprocessing.model.CountryEntity;

public interface CountryRepository extends CrudRepository<CountryEntity, Integer> {

}
