package sn.aziz.gestiondestockbackend.dto;

import lombok.Builder;
import lombok.Data;
import sn.aziz.gestiondestockbackend.models.LigneVente;

import java.math.BigDecimal;

@Data
@Builder
public class LigneVentesDto {
    private Integer id;
    private VentesDto vente;
    private ArticleDto articleDto;
    private BigDecimal quantite;
    private BigDecimal prixUnitaire;
    private Integer idEntreprise;
    public  static  LigneVentesDto fromEntity(LigneVente ligneVente){
        if (ligneVente == null){
            return null;
        }

        return  LigneVentesDto.builder()
                .id(ligneVente.getId())
                .quantite(ligneVente.getQuantite())
                .prixUnitaire(ligneVente.getPrixUnitaire())
                .vente(VentesDto.fromEntity(ligneVente.getVentes()))
                .articleDto(ArticleDto.fromEntity(ligneVente.getArticle()))
                .idEntreprise(ligneVente.getEntrepriseId())
                .build();
    }

    public static  LigneVente toEntity(LigneVentesDto dto){
        if (dto== null){
            return  null;
        }
        LigneVente ligneVente = new LigneVente();
        ligneVente.setId(dto.getId());
        ligneVente.setQuantite(dto.getQuantite());
        ligneVente.setPrixUnitaire(dto.getPrixUnitaire());
        ligneVente.setVentes(VentesDto.toEntity(dto.getVente()));
        ligneVente.setArticle(ArticleDto.toEntity(dto.getArticleDto()));
        ligneVente.setEntrepriseId(dto.getIdEntreprise());

        return ligneVente;
    }
}
