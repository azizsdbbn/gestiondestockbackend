package sn.aziz.gestiondestockbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tb_utilisateur")
public class Utilisateur extends AbstractEntity {
    @Column(name = "FirstName")
    private  String firstName;
    @Column(name = "LastName")
    private  String lastName;
    @Column(name = "email")
    private  String email;
    @Column(name = "password")
    private  String password;
    @Column(name = "date_Naissance")
    private Instant dateNaissance;
    @Embedded
    private Adresse adresse;
    @ManyToOne
    @JoinColumn(name = "id_entreprise")
    private Entreprise entreprise;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "utilisateur")
    @JsonIgnore
    private List<Roles> roles;

}
