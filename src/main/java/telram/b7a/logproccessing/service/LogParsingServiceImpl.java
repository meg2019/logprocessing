package telram.b7a.logproccessing.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import telram.b7a.logproccessing.mapper.CountryToCountryModelMapper;
import telram.b7a.logproccessing.mapper.UserToUserEntityMapper;
import telram.b7a.logproccessing.model.*;
import telram.b7a.logproccessing.repository.CountryRepository;
import telram.b7a.logproccessing.repository.LogRepository;
import telram.b7a.logproccessing.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.*;

@Service
@RequiredArgsConstructor
public class LogParsingServiceImpl implements LogParsingService {
    private final LogRepository logRepository;
    private final CountryRepository countryRepository;
    private final UserRepository userRepository;
    private final CountryToCountryModelMapper countryModelMapper;
    private final UserToUserEntityMapper userEntityMapper;

    @Override
    public List<Log> getEventsBetweenDate(LocalDate dateBefore, LocalDate dateAfter) {
        Iterable<Log> iterable = logRepository.findAllByCreatedBetween(dateBefore, dateAfter);
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(toList());
    }

    @Override
    public Map<LocalDate, Integer> countSuccessEvents(LocalDate dateBefore, LocalDate dateAfter) {
        Iterable<Log> iterable = logRepository.findAllByCreatedBetween(dateBefore, dateAfter);
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(groupingBy(Log::getCreated,
                        reducing(0, logEntry -> logEntry.isSuccess() ? 1 : 0, Integer::sum)));
    }

    @Override
    public Map<LocalDate, Integer> countUnSuccessEvents(LocalDate dateBefore, LocalDate dateAfter) {
        Iterable<Log> iterable = logRepository.findAllByCreatedBetween(dateBefore, dateAfter);
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(groupingBy(Log::getCreated,
                        reducing(0, logEntry -> logEntry.isSuccess() ? 0 : 1, Integer::sum)));
    }

    @Override
    public List<Country> getAllCountries() {
        Iterable<CountryEntity> iterable = countryRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false)
                .map(countryModelMapper::countryEntityToCountry)
                .collect(toList());
    }

    @Override
    public List<User> getAllUsers() {
//      Iterable<UserEntity> iterable = userRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        Iterable<UserEntity> iterable = userRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false)
                .map(userEntityMapper::userEntityToUser)
                .collect(toList());
    }

}
