package nl.novi.model;

import lombok.*;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "match")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User userOne;
    @OneToOne
    private User userTwo;
    @OneToOne
    private User winner;

    public String getWinnerName() {
        return winner != null ? winner.getFirstName() : "";
    }
}
