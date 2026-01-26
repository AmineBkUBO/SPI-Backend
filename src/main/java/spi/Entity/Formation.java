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
@Table(name = "FORMATION")
public class Formation {
    @Id
    @Size(max = 8)
    @Column(name = "CODE_FORMATION", nullable = false, length = 8)
    private String codeFormation;

    @Size(max = 3)
    @NotNull
    @Column(name = "DIPLOME", nullable = false, length = 3)
    private String diplome;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "N0_ANNEE", nullable = false)
    private Boolean n0Annee;

    @Size(max = 64)
    @NotNull
    @Column(name = "NOM_FORMATION", nullable = false, length = 64)
    private String nomFormation;

    @NotNull
    @Column(name = "DOUBLE_DIPLOME", nullable = false)
    private Boolean doubleDiplome;

    @Column(name = "DEBUT_HABILITATION")
    private LocalDate debutHabilitation;

    @Column(name = "FIN_HABILITATION")
    private LocalDate finHabilitation;


}