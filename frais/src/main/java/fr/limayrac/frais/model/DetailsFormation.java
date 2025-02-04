package fr.limayrac.frais.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "details_formation")
public class DetailsFormation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "declaration_id")
    private DeclarationFrais declarationFrais;

    private LocalDate dateFormation;
    private String lieuFormation;
    private String intituleFormation;

    public LocalDate getDateFormation() {
        return dateFormation;
    }

    public void setDateFormation(LocalDate dateFormation) {
        this.dateFormation = dateFormation;
    }

    public String getLieuFormation() {
        return lieuFormation;
    }

    public void setLieuFormation(String lieuFormation) {
        this.lieuFormation = lieuFormation;
    }

    public String getIntituleFormation() {
        return intituleFormation;
    }

    public void setIntituleFormation(String intituleFormation) {
        this.intituleFormation = intituleFormation;
    }

}
