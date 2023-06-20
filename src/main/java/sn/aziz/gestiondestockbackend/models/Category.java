package sn.aziz.gestiondestockbackend.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tb_category")
public class Category extends AbstractEntity{

    @Column(name = "code_category")
    private String code;
    @Column(name = "designation")
    private String designation;
    @Column(name = "entrepriseId")
    private Integer entrepriseId;
    @OneToMany(mappedBy = "category")
    private List<Article> articles;
}
