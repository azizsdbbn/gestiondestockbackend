package sn.aziz.gestiondestockbackend.models;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tb_mvtstk")
public class MvtStk extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;
    @Column(name = "dateMst")
    private Instant dateMvtStk;
    @Column(name = "entrepriseId")
    private Integer entrepriseId;
    @Column(name = "quantite")
    private BigDecimal quantite;
    @Column(name = "typemvt")
    @Enumerated(EnumType.STRING)
    private TypeMvtStk TypeStk;
    @Column(name = "sourcemvt")
    @Enumerated(EnumType.STRING)
    private SourceMvtStk sourceMvt;
}
