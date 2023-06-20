package sn.aziz.gestiondestockbackend.models;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tb_ligne_vente")
public class LigneVente  extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "id_vente")
    private Ventes ventes;
    @Column(name = "quantite")
    private BigDecimal quantite;
    @Column(name = "entrepriseId")
    private Integer entrepriseId;
    @Column(name = "prix_unitaire")
    private BigDecimal prixUnitaire;
    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;
}
