package fr.limayrac.frais.controller;

import fr.limayrac.frais.model.DeclarationFrais;
import fr.limayrac.frais.service.DeclarationFraisService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProfesseurController {

    private final DeclarationFraisService declarationFraisService;

    public ProfesseurController(DeclarationFraisService declarationFraisService) {
        this.declarationFraisService = declarationFraisService;
    }

    @GetMapping("/professeur/home")
    public String home(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        List<DeclarationFrais> declarations = declarationFraisService.getDeclarationsProfesseur(username);
        model.addAttribute("username", username);
        model.addAttribute("declarations", declarations);
        
        return "professeur/home";
    }
}
