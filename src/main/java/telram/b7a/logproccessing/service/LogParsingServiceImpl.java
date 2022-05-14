package telram.b7a.logproccessing.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import telram.b7a.logproccessing.model.Log;
import telram.b7a.logproccessing.repository.LogRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

@Service
@RequiredArgsConstructor
public class LogParsingServiceImpl implements LogParsingService {
    private final LogRepository logRepository;

    @Override
    public List<Log> getEventsBetweenDate(LocalDate dateBefore, LocalDate dateAfter) {
        return logRepository.findAllByCreatedBetween(dateBefore, dateAfter);
    }

    @Override
    public Map<LocalDate, Integer> countSuccessEvents(LocalDate dateBefore, LocalDate dateAfter) {
        List<Log> allEvents = logRepository.findAllByCreatedBetween(dateBefore, dateAfter);
        return allEvents.stream().collect(groupingBy(Log::getCreated,
                reducing(0, e1 -> e1.isSuccess() ? 1 : 0, Integer::sum)));
    }

}
