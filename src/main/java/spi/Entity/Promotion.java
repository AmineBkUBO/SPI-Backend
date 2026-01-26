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
@Table(name = "PROMOTION")
public class Promotion {
    @Id
    @Size(max = 10)
    @Column(name = "ANNEE_PRO", nullable = false, length = 10)
    private String anneePro;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "CODE_FORMATION")
    private Formation codeFormation;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "NO_ENSEIGNANT")
    private Enseignant noEnseignant;

    @Size(max = 5)
    @NotNull
    @Column(name = "SIGLE_PRO", nullable = false, length = 5)
    private String siglePro;

    @NotNull
    @Column(name = "NB_ETU_SOUHAITE", nullable = false)
    private Short nbEtuSouhaite;

    @Size(max = 3)
    @NotNull
    @Column(name = "ETAT_PRESELECTION", nullable = false, length = 3)
    private String etatPreselection;

    @Column(name = "DATE_RENTREE")
    private LocalDate dateRentree;

    @Size(max = 255)
    @Column(name = "LIEU_RENTREE")
    private String lieuRentree;

    @Column(name = "DATE_REPONSE_LP")
    private LocalDate dateReponseLp;

    @Size(max = 255)
    @Column(name = "COMMENTAIRE")
    private String commentaire;

    @Column(name = "DATE_REPONSE_LALP")
    private LocalDate dateReponseLalp;

    @Size(max = 5)
    @ColumnDefault("'RECH'")
    @Column(name = "PROCESSUS_STAGE", length = 5)
    private String processusStage;

    @Column(name = "NO_EVALUATION")
    private Long noEvaluation;

    @Column(name = "NO_BAREME")
    private Long noBareme;


}