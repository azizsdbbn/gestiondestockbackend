package sn.aziz.gestiondestockbackend.models;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tb_ligne_cmd_fournisseur")
public class LigneCommandeFournisseur extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;
    @ManyToOne
    @JoinColumn(name = "idcmdfournisseur")
    private CommandeFournisseur commandeFournisseur;
    @Column(name = "prix_unitaire")
    private BigDecimal prixUnitaire;
    @Column(name = "entrepriseId")
    private Integer entrepriseId;
    @Column(name = "quantite")
    private BigDecimal quantite;
}
