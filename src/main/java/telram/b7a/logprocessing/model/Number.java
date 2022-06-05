package telram.b7a.logprocessing.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "numbers")
@Data
public class Number {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_id")
    private int id;
    @Column(name = "num_number")
    private String number;
    @Column(name = "num_created")
    private LocalDate created;

    @OneToMany(mappedBy = "number", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
            CascadeType.REFRESH })
    private List<Log> logs;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cnt_id")
    private CountryEntity country;

}
