package fr.limayrac.frais.model;

import javax.persistence.*;

@Entity
@Table(name = "frais_hebergement")
public class FraisHebergement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "declaration_id")
    private DeclarationFrais declarationFrais;

    @Enumerated(EnumType.STRING)
    private TypeHebergement typeHebergement;

    private Double montant; // Coût de l'hébergement

    public enum TypeHebergement {
        GRATUIT, PAYANT
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DeclarationFrais getDeclarationFrais() {
        return declarationFrais;
    }

    public void setDeclarationFrais(DeclarationFrais declarationFrais) {
        this.declarationFrais = declarationFrais;
    }

    public TypeHebergement getTypeHebergement() {
        return typeHebergement;
    }

    public void setTypeHebergement(TypeHebergement typeHebergement) {
        this.typeHebergement = typeHebergement;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }
}
