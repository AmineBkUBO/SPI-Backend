package spi.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "ETUDIANT")
public class Etudiant {
    @Id
    @Size(max = 50)
    @Column(name = "NO_ETUDIANT_NAT", nullable = false, length = 50)
    private String noEtudiantNat;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "ANNEE_PRO", nullable = false)
    private Promotion anneePro;

    @Size(max = 10)
    @Column(name = "CODE_COM", length = 10)
    private String codeCom;

    @Size(max = 20)
    @Column(name = "NO_ETUDIANT_UBO", length = 20)
    private String noEtudiantUbo;

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

    @NotNull
    @Column(name = "DATE_NAISSANCE", nullable = false)
    private LocalDate dateNaissance;

    @Size(max = 255)
    @NotNull
    @Column(name = "LIEU_NAISSANCE", nullable = false)
    private String lieuNaissance;

    @Size(max = 3)
    @NotNull
    @Column(name = "SITUATION", nullable = false, length = 3)
    private String situation;

    @Size(max = 50)
    @NotNull
    @ColumnDefault("'Fran�aise'")
    @Column(name = "NATIONALITE", nullable = false, length = 50)
    private String nationalite;

    @Size(max = 20)
    @Column(name = "TEL_PORT", length = 20)
    private String telPort;

    @Size(max = 20)
    @Column(name = "TEL_FIXE", length = 20)
    private String telFixe;

    @Size(max = 255)
    @Column(name = "EMAIL")
    private String email;

    @Size(max = 255)
    @Column(name = "ACTU_ADRESSE")
    private String actuAdresse;

    @Size(max = 10)
    @Column(name = "ACTU_CP", length = 10)
    private String actuCp;

    @Size(max = 255)
    @Column(name = "ACTU_VILLE")
    private String actuVille;

    @Size(max = 255)
    @Column(name = "ACTU_PAYS")
    private String actuPays;

    @Size(max = 255)
    @NotNull
    @Column(name = "PERM_ADRESSE", nullable = false)
    private String permAdresse;

    @Size(max = 10)
    @NotNull
    @Column(name = "PERM_CP", nullable = false, length = 10)
    private String permCp;

    @Size(max = 255)
    @NotNull
    @Column(name = "PERM_VILLE", nullable = false)
    private String permVille;

    @Size(max = 255)
    @NotNull
    @Column(name = "PERM_PAYS", nullable = false)
    private String permPays;

    @Size(max = 255)
    @NotNull
    @Column(name = "DERNIER_DIPLOME", nullable = false)
    private String dernierDiplome;

    @Size(max = 255)
    @NotNull
    @Column(name = "UNIVERSITE", nullable = false)
    private String universite;

    @Size(max = 3)
    @NotNull
    @Column(name = "SIGLE_ETU", nullable = false, length = 3)
    private String sigleEtu;

    @Size(max = 10)
    @NotNull
    @Column(name = "COMPTE_CRI", nullable = false, length = 10)
    private String compteCri;

    @Size(max = 255)
    @Column(name = "UBO_EMAIL")
    private String uboEmail;

    @Column(name = "GRPE_ANGLAIS")
    private Boolean grpeAnglais;

    @Size(max = 255)
    @Column(name = "ABANDON_MOTIF")
    private String abandonMotif;

    @Column(name = "ABANDON_DATE")
    private LocalDate abandonDate;

    @ColumnDefault("'N'")
    @Column(name = "EST_DIPLOME")
    private Boolean estDiplome;


}