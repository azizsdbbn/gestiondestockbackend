package sn.aziz.gestiondestockbackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import sn.aziz.gestiondestockbackend.models.Article;
import sn.aziz.gestiondestockbackend.models.Category;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class CategoryDto {
    private Integer id;
    private String code;

    private String designation;
    private Integer idEntreprise;
    @JsonIgnore
    private List<ArticleDto> articleDtos;

    public static CategoryDto fromEntity(Category category){
     if (category ==null){
         return null;
         // TODO throw exception
     }
       return CategoryDto.builder()
               .id(category.getId())
               .code(category.getCode())
               .designation(category.getCode())
               .idEntreprise(category.getEntrepriseId())
               .build();
    }
    public static Category toEntity(CategoryDto categoryDto){
        if (categoryDto == null){
            return null;
            //TODO THROW EXCEPTION
        }

        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setCode(categoryDto.getCode());
        category.setDesignation(categoryDto.getDesignation());
        category.setEntrepriseId(categoryDto.getIdEntreprise());

        return category;
    }
}
