package sn.aziz.gestiondestockbackend.models;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tb_entreprise")
public class Entreprise  extends AbstractEntity{
    @Column(name = "nom_entreprise")
    private String nom;
    @Column(name = "description")
    private String description;
    @Embedded
    private Adresse adresse;
    @Column(name = "email")
    private String email;
    @Column(name = "photo")
    private String photo;
    @Column(name = "codefiscal")
    private String codeFiscal;
    @Column(name = "siteWeb")
    private String siteWeb;
    @Column(name = "numTel")
    private  String numTel;
    @OneToMany(mappedBy = "entreprise")
    private List<Utilisateur> utilisateurs;
}
