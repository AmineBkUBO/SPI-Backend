package spi.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ENSEIGNANT")
public class Enseignant {
    @Id
    @Column(name = "NO_ENSEIGNANT", nullable = false)
    private Integer id;

    @Size(max = 10)
    @NotNull
    @Column(name = "\"TYPE\"", nullable = false, length = 10)
    private String type;

    @Size(max = 1)
    @NotNull
    @Column(name = "SEXE", nullable = false, length = 1)
    private String sexe;

    @Size(max = 50)
    @NotNull
    @Column(name = "NOM", nullable = false, length = 50)
    private String nom;

    @Size(max = 50)
    @NotNull
    @Column(name = "PRENOM", nullable = false, length = 50)
    private String prenom;

    @Size(max = 255)
    @NotNull
    @Column(name = "ADRESSE", nullable = false)
    private String adresse;

    @Size(max = 10)
    @NotNull
    @Column(name = "CP", nullable = false, length = 10)
    private String cp;

    @Size(max = 255)
    @NotNull
    @Column(name = "VILLE", nullable = false)
    private String ville;

    @Size(max = 255)
    @NotNull
    @Column(name = "PAYS", nullable = false)
    private String pays;

    @Size(max = 20)
    @Column(name = "TEL_PORT", length = 20)
    private String telPort;

    @Size(max = 20)
    @Column(name = "ENC_PERSO_TEL", length = 20)
    private String encPersoTel;

    @Size(max = 20)
    @Column(name = "ENC_UBO_TEL", length = 20)
    private String encUboTel;

    @Size(max = 255)
    @Column(name = "ENC_PERSO_EMAIL")
    private String encPersoEmail;

    @Size(max = 255)
    @Column(name = "ENC_UBO_EMAIL")
    private String encUboEmail;

    @Size(max = 50)
    @Column(name = "INT_NO_INSEE", length = 50)
    private String intNoInsee;

    @Size(max = 50)
    @Column(name = "INT_SOC_NOM", length = 50)
    private String intSocNom;

    @Size(max = 255)
    @Column(name = "INT_SOC_ADRESSE")
    private String intSocAdresse;

    @Size(max = 10)
    @Column(name = "INT_SOC_CP", length = 10)
    private String intSocCp;

    @Size(max = 255)
    @Column(name = "INT_SOC_VILLE")
    private String intSocVille;

    @Size(max = 255)
    @Column(name = "INT_SOC_PAYS")
    private String intSocPays;

    @Size(max = 50)
    @Column(name = "INT_FONCTION", length = 50)
    private String intFonction;

    @Size(max = 255)
    @Column(name = "INT_PROF_EMAIL")
    private String intProfEmail;

    @Size(max = 20)
    @Column(name = "INT_PROF_TEL", length = 20)
    private String intProfTel;


}