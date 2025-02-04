package fr.limayrac.frais.model;

import javax.persistence.*;

@Entity
@Table(name = "frais_restauration")
public class FraisRestauration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "declaration_id")
    private DeclarationFrais declarationFrais;

    @Enumerated(EnumType.STRING)
    private TypeRestauration typeRestauration;

    private Double montant; // Montant total des frais de restauration

    public enum TypeRestauration {
        AUCUN, FRAIS_DECLARES
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

    public TypeRestauration getTypeRestauration() {
        return typeRestauration;
    }

    public void setTypeRestauration(TypeRestauration typeRestauration) {
        this.typeRestauration = typeRestauration;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }
}
