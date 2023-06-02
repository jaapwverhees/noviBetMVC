package nl.novi.model.DTO;

import lombok.*;
import nl.novi.model.User;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MatchDTO {
    private Long id;
    private Long userOne;
    private Long userTwo;
    private Long winner;
}
