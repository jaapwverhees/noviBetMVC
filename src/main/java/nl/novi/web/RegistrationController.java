package nl.novi.web;

import nl.novi.dto.UserRegistrationDto;
import nl.novi.model.DTO.MatchDTO;
import nl.novi.model.Match;
import nl.novi.model.User;
import nl.novi.repository.MatchRepository;
import nl.novi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import nl.novi.service.UserService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

	private UserService userService;

	@Autowired
	private MatchRepository matchRepository;

	@Autowired
	private UserRepository userRepository;

	public RegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}

	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}

	@ModelAttribute("userreal")
	public User User() {
		return new User();
	}

	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}

	@GetMapping("/users")
	public String showAll(Model model) {
		model.addAttribute("users", userService.getAll());
		return "users";
	}

	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		userService.save(registrationDto);
		return "redirect:/registration?success";
	}

}
