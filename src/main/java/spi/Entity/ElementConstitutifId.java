package spi.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class ElementConstitutifId implements Serializable {
    private static final long serialVersionUID = 1407059250481567862L;
    @Size(max = 8)
    @NotNull
    @Column(name = "CODE_FORMATION", nullable = false, length = 8)
    private String codeFormation;

    @Size(max = 8)
    @NotNull
    @Column(name = "CODE_UE", nullable = false, length = 8)
    private String codeUe;

    @Size(max = 8)
    @NotNull
    @Column(name = "CODE_EC", nullable = false, length = 8)
    private String codeEc;


}