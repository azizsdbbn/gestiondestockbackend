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
@Table(name = "tb_cmd_client")
public class CommandeClient extends AbstractEntity {

    @Column(name = "code_cmd_client")
    private String code;
    @Column(name = "date_cmd_client")
    private Instant dateCmd;
    @Column(name = "entrepriseId")
    private Integer entrepriseId;
    @ManyToOne
    @JoinColumn(name = "idclient")
    private Client client;
    @Column(name = "etatcommande")
    @Enumerated(EnumType.STRING)
    private EtatCommande etatCommande;
    @OneToMany(mappedBy = "commandeClient")
    private List<LigneCommandeClient> ligneCommandeClients;



}
