package spi.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CANDIDAT")
public class Candidat {
    @Id
    @Size(max = 50)
    @Column(name = "NO_ETUDIANT_NAT", nullable = false, length = 50)
    private String noEtudiantNat;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "ANNEE_PRO", nullable = false)
    private Promotion anneePro;

    @NotNull
    @Column(name = "SEXE", nullable = false)
    private Boolean sexe;

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
    @Column(name = "TEL_FIXE", length = 20)
    private String telFixe;

    @Size(max = 20)
    @Column(name = "TEL_PORT", length = 20)
    private String telPort;

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

    @Size(max = 2)
    @NotNull
    @Column(name = "SELECTION_ORIGINE", nullable = false, length = 2)
    private String selectionOrigine;

    @Size(max = 2)
    @NotNull
    @Column(name = "SELECTION_COURANTE", nullable = false, length = 2)
    private String selectionCourante;

    @NotNull
    @ColumnDefault("'N'")
    @Column(name = "REPONSE_ILI", nullable = false)
    private Boolean reponseIli;

    @Column(name = "DATE_REPONSE_ILI")
    private LocalDate dateReponseIli;

    @Size(max = 3)
    @ColumnDefault("'NRE'")
    @Column(name = "REPONSE_CAN", length = 3)
    private String reponseCan;

    @Column(name = "DATE_REPONSE_CAN")
    private LocalDate dateReponseCan;

    @Column(name = "NO_ORDRE")
    private Long noOrdre;


}