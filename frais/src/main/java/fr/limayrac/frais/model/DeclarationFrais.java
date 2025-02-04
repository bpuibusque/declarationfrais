package fr.limayrac.frais.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "declarations")
public class DeclarationFrais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String professeur;  
    private String formation; 
    private LocalDate date;   
    private String lieu;       

    @Enumerated(EnumType.STRING)
    private StatutDeclaration statut; 

    @OneToOne(mappedBy = "declarationFrais", cascade = CascadeType.ALL)
    private FraisTransport fraisTransport;

    @OneToOne(mappedBy = "declarationFrais", cascade = CascadeType.ALL)
    private FraisHebergement fraisHebergement;

    @OneToOne(mappedBy = "declarationFrais", cascade = CascadeType.ALL)
    private FraisRestauration fraisRestauration;

    @OneToOne(mappedBy = "declarationFrais", cascade = CascadeType.ALL)
    private CoordonneesBancaires coordonneesBancaires;

    public enum StatutDeclaration {
        EN_ATTENTE, INVALIDE, VALIDE
    }

    public DeclarationFrais() {
        this.statut = StatutDeclaration.EN_ATTENTE;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfesseur() {
        return professeur;
    }

    public void setProfesseur(String professeur) {
        this.professeur = professeur;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public StatutDeclaration getStatut() {
        return statut;
    }

    public void setStatut(StatutDeclaration statut) {
        this.statut = statut;
    }

    public FraisTransport getFraisTransport() {
        return fraisTransport;
    }

    public void setFraisTransport(FraisTransport fraisTransport) {
        this.fraisTransport = fraisTransport;
    }

    public FraisHebergement getFraisHebergement() {
        return fraisHebergement;
    }

    public void setFraisHebergement(FraisHebergement fraisHebergement) {
        this.fraisHebergement = fraisHebergement;
    }

    public FraisRestauration getFraisRestauration() {
        return fraisRestauration;
    }

    public void setFraisRestauration(FraisRestauration fraisRestauration) {
        this.fraisRestauration = fraisRestauration;
    }

    public CoordonneesBancaires getCoordonneesBancaires() {
        return coordonneesBancaires;
    }

    public void setCoordonneesBancaires(CoordonneesBancaires coordonneesBancaires) {
        this.coordonneesBancaires = coordonneesBancaires;
    }
}
