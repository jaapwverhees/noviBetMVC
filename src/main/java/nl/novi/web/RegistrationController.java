package nl.novi.web;

import nl.novi.dto.UserRegistrationDto;
import nl.novi.model.DTO.MatchDTO;
import nl.novi.model.Match;
import nl.novi.repository.MatchRepository;
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

	@GetMapping("/fight")
	public String populateList(Model model) {
		userService.getAll();
		model.addAttribute("users", userService.getAll());
		model.addAttribute("match", new MatchDTO());
		return "fight";
	}
	@PostMapping(path = "/fight")
	private String submitEmployee(@ModelAttribute("match") MatchDTO match, Model model) {
		//matchRepository.save(match);
		return "redirect:/registration?success";
	}
}
