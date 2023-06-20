package sn.aziz.gestiondestockbackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import sn.aziz.gestiondestockbackend.models.Ventes;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class VentesDto {

    private Integer id;
    private String code;
    private Instant dateVente;
    private  String commentaire;
    private Integer idEntreprise;
    @JsonIgnore
    private List<LigneVentesDto> ligneVentes;


    public static VentesDto fromEntity(Ventes ventes){
        if (ventes == null){
            return null;
        }

        return VentesDto.builder()
                .id(ventes.getId())
                .code(ventes.getCode())
                .dateVente(ventes.getDateVente())
                .commentaire(ventes.getCommentaire())
                .idEntreprise(ventes.getEntrepriseId())
                .build();
    }

    public static  Ventes toEntity(VentesDto ventesDto){
        if (ventesDto == null){
            return null;
        }

        Ventes ventes = new Ventes();

        ventes.setId(ventesDto.getId());
        ventes.setCode(ventesDto.getCode());
        ventes.setDateVente(ventesDto.getDateVente());
        ventes.setEntrepriseId(ventesDto.getIdEntreprise());
        ventes.setCommentaire(ventesDto.getCommentaire());

        return ventes;
    }

}
