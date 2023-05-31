package nl.novi.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.*;

import javax.persistence.*;

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

    //@Column(name = "userOne")
    @OneToOne
    private User userOne;
    //@Column(name = "userTwo")
    @OneToOne
    private User userTwo;
}
