package telram.b7a.logprocessing.repository;

import org.springframework.data.repository.CrudRepository;
import telram.b7a.logprocessing.model.Log;

import java.time.LocalDate;
import java.util.List;

public interface LogRepository extends CrudRepository<Log, Integer> {
    List<Log> findAllByCreatedBetween(LocalDate startDate, LocalDate endDate);
}
