package nl.novi.web;

import nl.novi.dto.UserRegistrationDto;
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

	public RegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}

	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
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
