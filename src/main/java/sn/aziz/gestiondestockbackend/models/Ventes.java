package sn.aziz.gestiondestockbackend.models;


import lombok.*;
import sn.aziz.gestiondestockbackend.dto.RolesDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tb_vente")
public class Ventes extends AbstractEntity{
    @Column(name = "code_vente")
    private String code;
    @Column(name = "date_vente")
    private Instant dateVente;
    @Column(name = "entrepriseId")
    private Integer entrepriseId;
    @Column(name = "commentaitre_vente")
    private  String commentaire;
    @OneToMany(mappedBy = "ventes")
    private List<LigneVente> ligneVentes;

}
