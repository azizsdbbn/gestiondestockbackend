package sn.aziz.gestiondestockbackend.models;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tb_fournisseur")
public class Fournisseur extends AbstractEntity{

    @Column(name = "nom_fournisseur")
    private String nom;
    @Column(name = "prenom_fournisseur")
    private  String prenom;
    @Embedded
    private Adresse adresse;
    @Column(name = "email_fournisseur")
    private String email;
    @Column(name = "photo_fournisseur")
    private String photo;
    @Column(name = "numTel_fournisseur")
    private String numTel;
    @Column(name = "entrepriseId")
    private Integer entrepriseId;
    @OneToMany(mappedBy = "fournisseur")
    private List<CommandeFournisseur> commandeFournisseurs;
}
