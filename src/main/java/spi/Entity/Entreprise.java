package spi.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "ENTREPRISE")
public class Entreprise {
    @Id
    @Column(name = "NO_ENTREPRISE", nullable = false)
    private Long id;

    @ColumnDefault("'N'")
    @Column(name = "REFERENCEE")
    private Boolean referencee;

    @Column(name = "DATE_REFERENCEMENT")
    private LocalDate dateReferencement;

    @Size(max = 8)
    @Column(name = "LOGIN_CREA", length = 8)
    private String loginCrea;

    @NotNull
    @ColumnDefault("SYSDATE")
    @Column(name = "DATE_CREA", nullable = false)
    private LocalDate dateCrea;

    @Size(max = 100)
    @NotNull
    @Column(name = "NOM", nullable = false, length = 100)
    private String nom;

    @Size(max = 100)
    @NotNull
    @Column(name = "SIEGE_SOCIAL", nullable = false, length = 100)
    private String siegeSocial;

    @Size(max = 5)
    @NotNull
    @Column(name = "DOMAINE_ACTIVITE", nullable = false, length = 5)
    private String domaineActivite;

    @Size(max = 255)
    @NotNull
    @Column(name = "ADRESSE", nullable = false)
    private String adresse;

    @Size(max = 10)
    @NotNull
    @Column(name = "CP", nullable = false, length = 10)
    private String cp;

    @Size(max = 100)
    @NotNull
    @Column(name = "VILLE", nullable = false, length = 100)
    private String ville;

    @Size(max = 100)
    @NotNull
    @ColumnDefault("'FRANCE'")
    @Column(name = "PAYS", nullable = false, length = 100)
    private String pays;

    @Size(max = 20)
    @NotNull
    @Column(name = "TEL", nullable = false, length = 20)
    private String tel;

    @Size(max = 150)
    @Column(name = "SITE_INTERNET", length = 150)
    private String siteInternet;

    @Size(max = 50)
    @Column(name = "NOM_REPRESENTANT", length = 50)
    private String nomRepresentant;

    @Size(max = 50)
    @Column(name = "PRENOM_REPRESENTANT", length = 50)
    private String prenomRepresentant;

    @Size(max = 8)
    @Column(name = "LOGIN_MAJ", length = 8)
    private String loginMaj;

    @ColumnDefault("SYSDATE")
    @Column(name = "DATE_MAJ")
    private LocalDate dateMaj;

    @ColumnDefault("'N'")
    @Column(name = "OFFRE_STAGE")
    private Boolean offreStage;


}