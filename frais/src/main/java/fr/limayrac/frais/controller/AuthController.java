package fr.limayrac.frais.controller;

import fr.limayrac.frais.model.User;
import fr.limayrac.frais.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username,
                            @RequestParam String password,
                            @RequestParam String role,
                            Model model) {
        if (userService.findByUsername(username).isPresent()) {
            model.addAttribute("error", "Utilisateur deja présent dans la base");
            return "register";
        }
        userService.createUser(username, password, role);
        return "redirect:/login";
    }

}
