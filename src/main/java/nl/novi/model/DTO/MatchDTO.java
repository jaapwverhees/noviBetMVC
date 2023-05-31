package nl.novi.model.DTO;

import lombok.Getter;
import lombok.Setter;
import nl.novi.model.User;

@Getter
@Setter
public class MatchDTO {
    private Long userOne;
    private Long userTwo;
}
