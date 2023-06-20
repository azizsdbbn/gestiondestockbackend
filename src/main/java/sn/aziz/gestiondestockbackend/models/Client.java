package sn.aziz.gestiondestockbackend.models;


import lombok.*;


import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tb_client")
public class Client extends AbstractEntity {

    @Column(name = "nom_client")
    private String nom;
    @Column(name = "prenom_client")
    private  String prenom;
    @Column(name = "entrepriseId")
    private Integer entrepriseId;
    @Embedded
    private Adresse adresse;
    @Column(name = "email_client")
    private String email;
    @Column(name = "photo_client")
    private String photo;
    @Column(name = "numTel_client")
    private String numTel;

    @OneToMany(mappedBy = "client")
    private List<CommandeClient> commandeClients;
}
