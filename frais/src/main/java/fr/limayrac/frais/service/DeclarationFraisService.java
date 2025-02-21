package fr.limayrac.frais.service;

import fr.limayrac.frais.model.CoordonneesBancaires;
import fr.limayrac.frais.model.DeclarationFrais;
import fr.limayrac.frais.model.FraisHebergement;
import fr.limayrac.frais.model.FraisRestauration;
import fr.limayrac.frais.model.DeclarationFrais.StatutDeclaration;
import fr.limayrac.frais.model.FraisTransport;
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
        declaration.setDate(LocalDate.now());
        declaration.setStatut(DeclarationFrais.StatutDeclaration.EN_ATTENTE);

        FraisTransport fraisTransport = new FraisTransport();
        fraisTransport.setDeclarationFrais(declaration);
        declaration.setFraisTransport(fraisTransport);
        
        FraisHebergement fraisHebergement = new FraisHebergement();
        fraisHebergement.setDeclarationFrais(declaration);
        declaration.setFraisHebergement(fraisHebergement);

        FraisRestauration fraisRestauration = new FraisRestauration();
        fraisRestauration.setDeclarationFrais(declaration);
        declaration.setFraisRestauration(fraisRestauration);

        CoordonneesBancaires coordonneesBancaires = new CoordonneesBancaires();
        coordonneesBancaires.setDeclarationFrais(declaration);
        declaration.setCoordonneesBancaires(coordonneesBancaires);

        return declarationFraisRepository.save(declaration);
    }


    public void soumettreDeclaration(DeclarationFrais declaration) {
        declaration.setStatut(DeclarationFrais.StatutDeclaration.EN_ATTENTE);
        declarationFraisRepository.save(declaration);
    }
}
