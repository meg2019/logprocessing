package telram.b7a.logprocessing.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import telram.b7a.logprocessing.model.Country;
import telram.b7a.logprocessing.model.User;
import telram.b7a.logprocessing.service.LogParsingService;

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
    @ApiOperation(value = "Get LogEntity with result is successful")
    public Map<LocalDate, Integer> getSuccessEventsBetweenDates(

            @ApiParam(name =  "Start Date",
                    type = "String",
                    value = "Start date for log entities",
                    example = "2021-12-30",
                    required = true)
            @RequestParam(name = "startDate") String startString,
            @ApiParam(name =  "End Date",
                    type = "String",
                    value = "End date for log entities",
                    example = "2022-01-05",
                    required = true)
            @RequestParam(name = "endDate") String endString) {

        LocalDate startDate = LocalDate.parse(startString, dateTimeFormatter);
        LocalDate endDate = LocalDate.parse(endString, dateTimeFormatter);
        return logParsingService.countSuccessEvents(startDate, endDate);
    }

    @GetMapping("/unsuccess")
    @ApiOperation(value = "Get LogEntity with result is Unsuccessful")
    public Map<LocalDate, Integer> getUnSuccessEventsBetweenDates(

            @ApiParam(name =  "Start Date",
                    type = "String",
                    value = "Start date for log entities",
                    example = "2021-12-30",
                    required = true)
            @RequestParam(name = "startDate") String startString,
            @ApiParam(name =  "End Date",
                    type = "String",
                    value = "End date for log entities",
                    example = "2022-01-05",
                    required = true)
            @RequestParam(name = "endDate") String endString) {
        LocalDate startDate = LocalDate.parse(startString, dateTimeFormatter);
        LocalDate endDate = LocalDate.parse(endString, dateTimeFormatter);
        return logParsingService.countUnSuccessEvents(startDate, endDate);
    }

    @GetMapping("/countries")
    @ApiOperation(value = "Get all countries", response = Country.class)
    public List<Country> getAllCountries() {
        return logParsingService.getAllCountries();
    }

    @GetMapping("/users")
    @ApiOperation(value = "Get all users", response = User.class)
    public List<User> getAllUsers() {
        return logParsingService.getAllUsers();
    }


}