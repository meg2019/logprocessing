package telram.b7a.logprocessing.model;

import lombok.Value;

import java.time.LocalDate;
@Value
public class User {
    int id;
    String name;
    boolean active;
    LocalDate created;
}
