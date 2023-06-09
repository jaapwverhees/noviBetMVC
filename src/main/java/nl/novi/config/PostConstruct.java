package nl.novi.config;

import nl.novi.dto.UserRegistrationDto;
import nl.novi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostConstruct {

    @Autowired
    private UserService userService;

    @javax.annotation.PostConstruct
    public void init() {
        userService.save(UserRegistrationDto.builder()
                .email("ben")
                .firstName("ben")
                .lastName("ben")
                .password("ben")
                .build());
        userService.saveAdmin(UserRegistrationDto.builder()
                .email("admin")
                .firstName("admin")
                .lastName("admin")
                .password("admin")
                .build());
    }
}
