package telram.b7a.logprocessing.model;

import lombok.Data;

import javax.persistence.*;


import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id")
    private int id;
    @Column(name = "usr_name")
    private String name;
    @Column(name = "usr_active")
    private boolean isActive;
    @Column(name = "usr_created")
    private LocalDate created;

    @OneToMany(mappedBy = "user", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
            CascadeType.REFRESH })
    private List<Log> logs;

}
