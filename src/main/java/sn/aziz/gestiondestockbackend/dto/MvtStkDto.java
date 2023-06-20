package sn.aziz.gestiondestockbackend.dto;

import lombok.Builder;
import lombok.Data;
import sn.aziz.gestiondestockbackend.models.Article;
import sn.aziz.gestiondestockbackend.models.MvtStk;
import sn.aziz.gestiondestockbackend.models.SourceMvtStk;
import sn.aziz.gestiondestockbackend.models.TypeMvtStk;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class MvtStkDto {

    private Integer id;
    private ArticleDto articleDto;
    private Instant dateMvtStk;
    private BigDecimal quantite;
    private TypeMvtStk typeStk;
    private SourceMvtStk sourceMvtStk;
    private Integer idEntreprise;

    public  static  MvtStkDto fromEntity(MvtStk mvtStk){
        if (mvtStk== null){
            return null;
        }

        return MvtStkDto.builder()
                .id(mvtStk.getId())
                .dateMvtStk(mvtStk.getDateMvtStk())
                .quantite(mvtStk.getQuantite())
                .articleDto(ArticleDto.fromEntity(mvtStk.getArticle()))
                .idEntreprise(mvtStk.getEntrepriseId())
                .build();
    }

    public static MvtStk toEntity(MvtStkDto mvtStkDto){
        if (mvtStkDto == null){
            return null;
        }

        MvtStk mvtStk = new MvtStk();

        mvtStk.setId(mvtStkDto.getId());
        mvtStk.setDateMvtStk(mvtStkDto.getDateMvtStk());
        mvtStk.setQuantite(mvtStkDto.getQuantite());
        mvtStk.setArticle(ArticleDto.toEntity(mvtStkDto.getArticleDto()));
        mvtStk.setEntrepriseId(mvtStkDto.getIdEntreprise());

        return mvtStk;
    }

}
