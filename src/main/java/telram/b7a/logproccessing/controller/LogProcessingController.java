package telram.b7a.logproccessing.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import telram.b7a.logproccessing.model.Log;
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

    @GetMapping()
    public Map<LocalDate, Integer> getSuccessEventsBetweenDates(@RequestParam(name = "startDate") String startString,
                                                                @RequestParam(name = "endDate") String endString) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(startString, dateTimeFormatter);
        LocalDate endDate = LocalDate.parse(endString, dateTimeFormatter);
        return logParsingService.countSuccessEvents(startDate, endDate);
    }

}