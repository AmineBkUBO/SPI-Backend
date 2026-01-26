package spi.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "POSTE_ENTREPRISE")
public class PosteEntreprise {
    @EmbeddedId
    private PosteEntrepriseId id;

    @MapsId("noEtudiantNat")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "NO_ETUDIANT_NAT", nullable = false)
    private Diplome noEtudiantNat;

    @MapsId("noEntreprise")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "NO_ENTREPRISE", nullable = false)
    private Entreprise noEntreprise;

    @Size(max = 5)
    @NotNull
    @Column(name = "FONCTION", nullable = false, length = 5)
    private String fonction;

    @NotNull
    @Column(name = "DATE_EMBAUCHE", nullable = false)
    private LocalDate dateEmbauche;

    @Size(max = 3)
    @NotNull
    @Column(name = "MOYEN_OBTENTION", nullable = false, length = 3)
    private String moyenObtention;

    @Size(max = 5)
    @Column(name = "SERVICE", length = 5)
    private String service;

    @Column(name = "BRUT_ANNUEL")
    private Integer brutAnnuel;


}