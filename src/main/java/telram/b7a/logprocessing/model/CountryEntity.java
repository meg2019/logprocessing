package telram.b7a.logprocessing.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "countries")
@Data

public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cnt_id")
    private int id;
    @Column(name = "cnt_code")
    private String code;
    @Column(name = "cnt_title")
    private String title;
    @Column(name = "cnt_created")
    private LocalDate created;
    @OneToMany(mappedBy = "country", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
            CascadeType.REFRESH })
    private List<Number>numbers;

}
