package telram.b7a.logproccessing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import telram.b7a.logproccessing.model.Log;

import java.time.LocalDate;
import java.util.List;

public interface LogRepository extends JpaRepository<Log, Integer> {
    List<Log> findAllByCreatedBetween(LocalDate startDate, LocalDate endDate);
}
