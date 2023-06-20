package sn.aziz.gestiondestockbackend.dto;

import lombok.Builder;
import lombok.Data;
import sn.aziz.gestiondestockbackend.models.LigneCommandeClient;

import java.math.BigDecimal;

@Data
@Builder
public class LigneCommandeClientDto {
    private Integer id;
    private ArticleDto articleDto;
    private CommandeClientDto commandeClientDto;

    private BigDecimal prixUnitaire;
    private BigDecimal quantite;
    private Integer idEntreprise;
    public static LigneCommandeClientDto fromEntity(LigneCommandeClient ligneCommandeClient){
        if (ligneCommandeClient == null){
            return null;
        }
        return LigneCommandeClientDto.builder()
                .id(ligneCommandeClient.getId())
                .articleDto(ArticleDto.fromEntity(ligneCommandeClient.getArticle()))
                .prixUnitaire(ligneCommandeClient.getPrixUnitaire())
                .quantite(ligneCommandeClient.getQuantite())
                .idEntreprise(ligneCommandeClient.getEntrepriseId())
                .build();
    }

    public static LigneCommandeClient toEntity(LigneCommandeClientDto dto){
        if (dto == null){
            return null;
        }

        LigneCommandeClient ligneCommandeClient = new LigneCommandeClient();
        ligneCommandeClient.setId(dto.getId());
        ligneCommandeClient.setPrixUnitaire(dto.getPrixUnitaire());
        ligneCommandeClient.setQuantite(dto.getQuantite());
        ligneCommandeClient.setArticle(ArticleDto.toEntity(dto.getArticleDto()));
        ligneCommandeClient.setEntrepriseId(dto.getIdEntreprise());

        return  ligneCommandeClient;
    }
}
