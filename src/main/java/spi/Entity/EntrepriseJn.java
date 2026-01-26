package spi.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "ENTREPRISE_JN")
public class EntrepriseJn {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    @Size(max = 3)
    @NotNull
    @Column(name = "JN_OPERATION", nullable = false, length = 3)
    private String jnOperation;

    @Size(max = 30)
    @NotNull
    @Column(name = "JN_ORACLE_USER", nullable = false, length = 30)
    private String jnOracleUser;

    @NotNull
    @Column(name = "JN_DATETIME", nullable = false)
    private LocalDate jnDatetime;

    @Size(max = 240)
    @Column(name = "JN_NOTES", length = 240)
    private String jnNotes;

    @Size(max = 35)
    @Column(name = "JN_APPLN", length = 35)
    private String jnAppln;

    @Column(name = "JN_SESSION")
    private Long jnSession;

    @NotNull
    @Column(name = "NO_ENTREPRISE", nullable = false)
    private Long noEntreprise;

    @Column(name = "REFERENCEE")
    private Boolean referencee;

    @Column(name = "DATE_REFERENCEMENT")
    private LocalDate dateReferencement;

    @Size(max = 8)
    @Column(name = "LOGIN_CREA", length = 8)
    private String loginCrea;

    @Column(name = "DATE_CREA")
    private LocalDate dateCrea;

    @Size(max = 100)
    @Column(name = "NOM", length = 100)
    private String nom;

    @Size(max = 100)
    @Column(name = "SIEGE_SOCIAL", length = 100)
    private String siegeSocial;

    @Size(max = 5)
    @Column(name = "DOMAINE_ACTIVITE", length = 5)
    private String domaineActivite;

    @Size(max = 255)
    @Column(name = "ADRESSE")
    private String adresse;

    @Size(max = 10)
    @Column(name = "CP", length = 10)
    private String cp;

    @Size(max = 100)
    @Column(name = "VILLE", length = 100)
    private String ville;

    @Size(max = 100)
    @Column(name = "PAYS", length = 100)
    private String pays;

    @Size(max = 20)
    @Column(name = "TEL", length = 20)
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

    @Column(name = "DATE_MAJ")
    private LocalDate dateMaj;

    @Column(name = "OFFRE_STAGE")
    private Boolean offreStage;


}