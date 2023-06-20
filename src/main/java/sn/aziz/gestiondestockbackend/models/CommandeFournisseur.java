package sn.aziz.gestiondestockbackend.models;


import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tb_cmd_fournisseur")
public class CommandeFournisseur extends AbstractEntity{

    @Column(name = "code_cmd_fournisseur")
    private String code;
    @Column(name = "date_cmd_fournisseur")
    private Instant dateCmd;
    @Column(name = "entrepriseId")
    private Integer entrepriseId;
    @Column(name = "etatcommande")
    @Enumerated(EnumType.STRING)
    private EtatCommande etatCommande;
    @ManyToOne
    @JoinColumn(name = "idfournisseur")
    private Fournisseur fournisseur;
    @OneToMany(mappedBy = "commandeFournisseur")
    private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;
}
