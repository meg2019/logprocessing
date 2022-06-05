package telram.b7a.logprocessing.service;

import telram.b7a.logprocessing.model.Country;
import telram.b7a.logprocessing.model.Log;
import telram.b7a.logprocessing.model.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface LogParsingService {
    List<Log> getEventsBetweenDate(LocalDate dateBefore, LocalDate dateAfter);

    Map<LocalDate, Integer> countSuccessEvents(LocalDate dateBefore, LocalDate dateAfter);

    Map<LocalDate, Integer> countUnSuccessEvents(LocalDate dateBefore, LocalDate dateAfter);

    List<Country> getAllCountries();

    List<User> getAllUsers();


}
