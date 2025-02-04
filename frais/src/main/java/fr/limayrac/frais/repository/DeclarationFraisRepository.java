package fr.limayrac.frais.repository;

import fr.limayrac.frais.model.DeclarationFrais;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DeclarationFraisRepository extends JpaRepository<DeclarationFrais, Long> {

    List<DeclarationFrais> findByProfesseur(String professeur);
}
