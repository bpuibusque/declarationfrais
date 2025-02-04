package fr.limayrac.frais.model;

import javax.persistence.*;

@Entity
@Table(name = "coordonnees_bancaires")
public class CoordonneesBancaires {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "declaration_id")
    private DeclarationFrais declarationFrais;

    private String iban;
    private String bic;
    private String titulaireCompte;

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

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getTitulaireCompte() {
        return titulaireCompte;
    }

    public void setTitulaireCompte(String titulaireCompte) {
        this.titulaireCompte = titulaireCompte;
    }
}
