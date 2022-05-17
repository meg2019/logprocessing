package telram.b7a.logproccessing.model;

import lombok.Value;

import java.time.LocalDate;
@Value
public class User {
    int id;
    String name;
    boolean isActive;
    LocalDate created;
}
