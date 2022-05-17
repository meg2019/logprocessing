package telram.b7a.logproccessing.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import telram.b7a.logproccessing.model.Country;
import telram.b7a.logproccessing.model.User;
import telram.b7a.logproccessing.service.LogParsingService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/logs")
@RequiredArgsConstructor
public class LogProcessingController {
    private final LogParsingService logParsingService;
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @GetMapping("/success")
    public Map<LocalDate, Integer> getSuccessEventsBetweenDates(@RequestParam(name = "startDate") String startString,
                                                                @RequestParam(name = "endDate") String endString) {

        LocalDate startDate = LocalDate.parse(startString, dateTimeFormatter);
        LocalDate endDate = LocalDate.parse(endString, dateTimeFormatter);
        return logParsingService.countSuccessEvents(startDate, endDate);
    }

    @GetMapping("/unsuccess")
    public Map<LocalDate, Integer> getUnSuccessEventsBetweenDates(@RequestParam(name = "startDate") String startString,
                                                                  @RequestParam(name = "endDate") String endString) {
        LocalDate startDate = LocalDate.parse(startString, dateTimeFormatter);
        LocalDate endDate = LocalDate.parse(endString, dateTimeFormatter);
        return logParsingService.countUnSuccessEvents(startDate, endDate);
    }
    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        return logParsingService.getAllCountries();
    }
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return logParsingService.getAllUsers();
    }


}