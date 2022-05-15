package telram.b7a.logproccessing.service;

import telram.b7a.logproccessing.model.Log;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface LogParsingService {
    List<Log> getEventsBetweenDate(LocalDate dateBefore, LocalDate dateAfter);
    Map<LocalDate, Integer> countSuccessEvents(LocalDate dateBefore, LocalDate dateAfter);
    Map<LocalDate, Integer> countUnSuccessEvents(LocalDate dateBefore, LocalDate dateAfter);
}
