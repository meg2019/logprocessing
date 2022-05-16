package telram.b7a.logproccessing.model;

import lombok.Value;

import java.time.LocalDate;
@Value
public class Country {
    int id;
    String code;
    String title;
    LocalDate created;
}
