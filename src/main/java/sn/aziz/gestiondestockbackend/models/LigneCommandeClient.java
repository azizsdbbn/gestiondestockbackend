package sn.aziz.gestiondestockbackend.models;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tb_ligne_cmd_client")
public class LigneCommandeClient extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;
    @Column(name = "entrepriseId")
    private Integer entrepriseId;
    @ManyToOne
    @JoinColumn(name = "idcmdclient")
    private CommandeClient commandeClient;
    @Column(name = "prix_unitaire")
    private BigDecimal prixUnitaire;
    @Column(name = "quantite")
    private BigDecimal quantite;
}
