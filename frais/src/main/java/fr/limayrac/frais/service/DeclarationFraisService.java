package fr.limayrac.frais.service;

import fr.limayrac.frais.model.DeclarationFrais;
import fr.limayrac.frais.model.DeclarationFrais.StatutDeclaration;
import fr.limayrac.frais.repository.DeclarationFraisRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DeclarationFraisService {

    private final DeclarationFraisRepository declarationFraisRepository;

    public List<DeclarationFrais> getDeclarationsProfesseur(String professeur) {
        return declarationFraisRepository.findByProfesseur(professeur);
    }

    public Optional<DeclarationFrais> getDeclarationById(Long id) {
        return declarationFraisRepository.findById(id);
    }

    public void validerDeclaration(Long id) {
        declarationFraisRepository.findById(id).ifPresent(declaration -> {
            declaration.setStatut(StatutDeclaration.VALIDE);
            declarationFraisRepository.save(declaration);
        });
    }

    public void invaliderDeclaration(Long id) {
        declarationFraisRepository.findById(id).ifPresent(declaration -> {
            declaration.setStatut(StatutDeclaration.INVALIDE);
            declarationFraisRepository.save(declaration);
        });
    }

     public DeclarationFraisService(DeclarationFraisRepository declarationFraisRepository) {
        this.declarationFraisRepository = declarationFraisRepository;
    }

    public DeclarationFrais initDeclaration(String professeur) {
        DeclarationFrais declaration = new DeclarationFrais();
        declaration.setProfesseur(professeur);
        declaration.setStatut(DeclarationFrais.StatutDeclaration.EN_ATTENTE);
        declaration.setDate(LocalDate.now());
        return declarationFraisRepository.save(declaration);
    }

    public void soumettreDeclaration(DeclarationFrais declaration) {
        declaration.setStatut(DeclarationFrais.StatutDeclaration.EN_ATTENTE);
        declarationFraisRepository.save(declaration);
    }
}
