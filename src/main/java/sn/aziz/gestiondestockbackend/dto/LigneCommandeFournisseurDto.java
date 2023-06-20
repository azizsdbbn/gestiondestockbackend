package sn.aziz.gestiondestockbackend.dto;

import lombok.Builder;
import lombok.Data;
import sn.aziz.gestiondestockbackend.models.LigneCommandeClient;
import sn.aziz.gestiondestockbackend.models.LigneCommandeFournisseur;

import java.math.BigDecimal;

@Data
@Builder
public class LigneCommandeFournisseurDto {
    private Integer id;
    private ArticleDto articleDto;
    private CommandeFournisseurDto commandeFournisseurDto;

    private BigDecimal prixUnitaire;
    private BigDecimal quantite;
    private Integer idEntreprise;

    public static LigneCommandeFournisseurDto fromEntity(LigneCommandeFournisseur ligneCommandeFournisseur){
        if (ligneCommandeFournisseur == null){
            return null;
        }
        return LigneCommandeFournisseurDto.builder()
                .id(ligneCommandeFournisseur.getId())
                .prixUnitaire(ligneCommandeFournisseur.getPrixUnitaire())
                .quantite(ligneCommandeFournisseur.getQuantite())
                .articleDto(ArticleDto.fromEntity(ligneCommandeFournisseur.getArticle()))
                .idEntreprise(ligneCommandeFournisseur.getEntrepriseId())
                .build();
    }

    public static LigneCommandeFournisseur toEntity(LigneCommandeFournisseurDto dto){
        if (dto == null){
            return null;
        }

        LigneCommandeFournisseur ligneCommandeFournisseur = new LigneCommandeFournisseur();
        ligneCommandeFournisseur.setId(dto.getId());
        ligneCommandeFournisseur.setPrixUnitaire(dto.getPrixUnitaire());
        ligneCommandeFournisseur.setQuantite(dto.getQuantite());
        ligneCommandeFournisseur.setArticle(ArticleDto.toEntity(dto.getArticleDto()));
        ligneCommandeFournisseur.setEntrepriseId(dto.getIdEntreprise());

        return ligneCommandeFournisseur;
    }
}
