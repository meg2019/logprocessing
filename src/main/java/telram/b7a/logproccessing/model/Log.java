package telram.b7a.logproccessing.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "send_log")
@Data
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    private int id;
    @Column(name = "log_message")
    private String message;
    @Column(name = "log_success")
    private boolean isSuccess;
    @Column(name = "log_created")
    private LocalDate created;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usr_id")
    private UserEntity user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "num_id")
    private Number number;
}
