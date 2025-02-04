package fr.limayrac.frais.model;

import javax.persistence.*;

@Entity
@Table(name = "frais_transport")
public class FraisTransport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "declaration_id")
    private DeclarationFrais declarationFrais;

    @Enumerated(EnumType.STRING)
    private TypeTransport typeTransport;

    private Double montant; // Coût du transport

    public enum TypeTransport {
        TRAIN, AVION, VEHICULE_PERSONNEL
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

    public TypeTransport getTypeTransport() {
        return typeTransport;
    }

    public void setTypeTransport(TypeTransport typeTransport) {
        this.typeTransport = typeTransport;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }
}
