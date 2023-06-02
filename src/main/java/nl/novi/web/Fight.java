package nl.novi.web;

import nl.novi.model.DTO.MatchDTO;
import nl.novi.model.Match;
import nl.novi.model.User;
import nl.novi.repository.MatchRepository;
import nl.novi.repository.UserRepository;
import nl.novi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Fight {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MatchRepository matchRepository;

    @GetMapping("/fight")
    public String populateList(Model model) {
        userService.getAll();
        model.addAttribute("users", userService.getAll());
        model.addAttribute("match", new MatchDTO());
        return "fight";
    }

    @PostMapping(path = "/fight")
    private String fight(@ModelAttribute("match") MatchDTO match, Model model) {
        User userOne = userRepository.findById(match.getUserOne()).orElseThrow(RuntimeException::new);
        User userTwo = userRepository.findById(match.getUserTwo()).orElseThrow(RuntimeException::new);
        Match newMatch = matchRepository.save(Match.builder()
                .userOne(userOne)
                .userTwo(userTwo)
                .build());
        //matchRepository.save(match);
        return "redirect:/fightlist";
    }

    @PostMapping(path = "/addwinner")
    private String addwinner(@ModelAttribute("match") MatchDTO match, Model model) {
        System.out.println(match);
        Match newMatch = matchRepository.getById(match.getId());
        newMatch.setWinner(userRepository.getById(match.getWinner()));
        matchRepository.save(newMatch);
        //matchRepository.save(match);
        return "redirect:/fightlist";
    }

    @GetMapping("/fightlist")
    public String fightlist(Model model) {
        model.addAttribute("users", userService.getAll());
        model.addAttribute("matches", matchRepository.findAll());
        model.addAttribute("match", new Match());
        model.addAttribute("winner", new User());
        return "fightlist";
    }

}
