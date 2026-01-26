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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DIPLOME")
public class Diplome {
    @Id
    @Size(max = 50)
    @Column(name = "NO_ETUDIANT_NAT", nullable = false, length = 50)
    private String noEtudiantNat;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "NO_ETUDIANT_NAT", nullable = false)
    private Etudiant etudiant;

    @Size(max = 50)
    @NotNull
    @Column(name = "NOM", nullable = false, length = 50)
    private String nom;

    @Size(max = 50)
    @NotNull
    @Column(name = "PRENOM", nullable = false, length = 50)
    private String prenom;

    @NotNull
    @ColumnDefault("'N'")
    @Column(name = "AUTORISATION_ANNUAIRE", nullable = false)
    private Boolean autorisationAnnuaire;

    @Size(max = 3)
    @Column(name = "TYPE_EMPLOI", length = 3)
    private String typeEmploi;

    @Size(max = 100)
    @Column(name = "MAIL_PRO", length = 100)
    private String mailPro;

    @Size(max = 20)
    @Column(name = "TEL_PRO", length = 20)
    private String telPro;

    @Size(max = 100)
    @Column(name = "ADRESSE", length = 100)
    private String adresse;

    @Size(max = 10)
    @Column(name = "CP", length = 10)
    private String cp;

    @Size(max = 50)
    @Column(name = "VILLE", length = 50)
    private String ville;

    @Size(max = 100)
    @Column(name = "EMAIL_PERSO", length = 100)
    private String emailPerso;

    @Size(max = 20)
    @Column(name = "TEL_PERSO", length = 20)
    private String telPerso;

    @Size(max = 20)
    @Column(name = "PORTABLE", length = 20)
    private String portable;


}