package sn.aziz.gestiondestockbackend.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tb_article")
public class Article extends AbstractEntity{
    @Column(name = "codeArticle")
    private String code;
    @Column(name = "designation")
    private String designation;
    @Column(name = "prix_unitaireHt")
    private BigDecimal prixUnitaireHt;
    @Column(name = "taux_tva")
    private BigDecimal tauxTva;
    @Column(name = "entrepriseId")
    private Integer entrepriseId;
    @Column(name = "prix_unitaireTtc")
    private BigDecimal prixUnitaireTtc;
    @Column(name = "photo")
    private String photo;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "article")
    private List<LigneVente> ligneVentes;

    @OneToMany(mappedBy = "article")
    private List<LigneCommandeClient> ligneCommandeClients;
    @OneToMany(mappedBy = "article")
    private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;
    @OneToMany(mappedBy = "article")
    private List<MvtStk> mvtStks;
}
