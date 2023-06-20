package sn.aziz.gestiondestockbackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import sn.aziz.gestiondestockbackend.models.Entreprise;

import java.util.List;

@Data
@Builder
public class EntrepriseDto {
    private Integer id;
    private String nom;
    private String description;
    private AdresseDto adresseDto;
    private String email;
    private String photo;
    private String codeFiscal;
    private String siteWeb;
    private  String numTel;
    @JsonIgnore
    private List<UtilisateurDto> utilisateurDtos;

    public static EntrepriseDto fromEntity(Entreprise entreprise){
        if (entreprise == null){
            return  null;
        }

        return EntrepriseDto.builder()
                .id(entreprise.getId())
                .nom(entreprise.getNom())
                .email(entreprise.getEmail())
                .photo(entreprise.getPhoto())
                .numTel(entreprise.getNumTel())
                .siteWeb(entreprise.getSiteWeb())
                .codeFiscal(entreprise.getCodeFiscal())
                .description(entreprise.getDescription())
                .adresseDto(AdresseDto.fromEntity(entreprise.getAdresse()))
                .build();
    }

    public static Entreprise toEntity(EntrepriseDto entrepriseDto){
        if (entrepriseDto == null){
            return null;
        }

        Entreprise entreprise = new Entreprise();
        entreprise.setId(entrepriseDto.getId());
        entreprise.setNom(entrepriseDto.getNom());
        entreprise.setDescription(entrepriseDto.getDescription());
        entreprise.setEmail(entrepriseDto.getEmail());
        entreprise.setNumTel(entrepriseDto.getNumTel());
        entreprise.setPhoto(entrepriseDto.getPhoto());
        entreprise.setCodeFiscal(entrepriseDto.getCodeFiscal());
        entreprise.setSiteWeb(entrepriseDto.getSiteWeb());
        entreprise.setAdresse(AdresseDto.toEntity(entrepriseDto.getAdresseDto()));

        return entreprise;
    }
}
