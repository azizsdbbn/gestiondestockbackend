package sn.aziz.gestiondestockbackend.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import sn.aziz.gestiondestockbackend.models.Article;



import java.math.BigDecimal;
@Getter @Setter
@Builder
public class ArticleDto {

    private Integer id;
    private String code;
    private String designation;
    private BigDecimal prixUnitaireHt;
    private BigDecimal tauxTva;
    private BigDecimal prixUnitaireTtc;
    private String photo;
    private CategoryDto categoryDto;
    private Integer idEntreprise;

    public static ArticleDto fromEntity(Article article){
        if (article== null){
            return  null;

        }

        return ArticleDto.builder()
                .id(article.getId())
                .code(article.getCode())
                .designation(article.getDesignation())
                .prixUnitaireHt(article.getPrixUnitaireHt())
                .tauxTva(article.getTauxTva())
                .prixUnitaireTtc(article.getPrixUnitaireTtc())
                .photo(article.getPhoto())
                .idEntreprise(article.getEntrepriseId())
                .categoryDto(CategoryDto.fromEntity(article.getCategory()))
                .build();
    }

    public static Article toEntity(ArticleDto articleDto){
        if (articleDto== null){
            return null;
        }

        Article article = new Article();
        article.setId(articleDto.getId());
        article.setCode(articleDto.getCode());
        article.setDesignation(articleDto.getDesignation());
        article.setPrixUnitaireHt(articleDto.getPrixUnitaireHt());
        article.setTauxTva(articleDto.getTauxTva());
        article.setPrixUnitaireTtc(articleDto.getPrixUnitaireTtc());
        article.setPhoto(article.getPhoto());
        article.setEntrepriseId(articleDto.getIdEntreprise());
        article.setCategory(CategoryDto.toEntity(articleDto.getCategoryDto()));
        return  article;
    }
}
