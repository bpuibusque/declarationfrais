package fr.limayrac.frais.controller;

import fr.limayrac.frais.model.DeclarationFrais;
import fr.limayrac.frais.service.DeclarationFraisService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/professeur/declaration")
public class DeclarationFraisController {

    private final DeclarationFraisService declarationFraisService;

    public DeclarationFraisController(DeclarationFraisService declarationFraisService) {
        this.declarationFraisService = declarationFraisService;
    }

    @GetMapping
    public String voirDeclarations(Model model, Principal principal) {
        String professeur = principal.getName();
        List<DeclarationFrais> declarations = declarationFraisService.getDeclarationsProfesseur(professeur);
        model.addAttribute("declarations", declarations);
        return "professeur/declarations";
    }

    @GetMapping("/new")
    public String initDeclaration(Model model, Principal principal) {
        String professeur = principal.getName();
        DeclarationFrais declaration = declarationFraisService.initDeclaration(professeur);
        model.addAttribute("declaration", declaration);
        return "declaration/preparer";  // Redirige vers l'étape 1
    }

    @PostMapping("/save")
    public String saveDeclaration(@ModelAttribute DeclarationFrais declaration) {
        declarationFraisService.soumettreDeclaration(declaration);
        return "redirect:/professeur/declaration/recapitulatif"; // Étape 7
    }

    @GetMapping("/{id}")
    public String afficherDeclaration(@PathVariable Long id, Model model) {
        Optional<DeclarationFrais> declaration = declarationFraisService.getDeclarationById(id);
        if (declaration.isPresent()) {
            model.addAttribute("declaration", declaration.get());
            return "declaration/recapitulatif";
        } else {
            return "redirect:/professeur/declaration";
        }
    }
}
