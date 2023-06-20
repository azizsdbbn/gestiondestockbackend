package sn.aziz.gestiondestockbackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import sn.aziz.gestiondestockbackend.models.Client;
import sn.aziz.gestiondestockbackend.models.Fournisseur;

import java.util.List;

@Data
@Builder
public class FournisseurDto {
    private Integer id;
    private String nom;
    private  String prenom;
    private AdresseDto adresseDto;
    private String email;
    private String photo;
    private String numTel;
    private Integer idEntreprise;
    @JsonIgnore
    private List<CommandeFournisseurDto> commandeFournisseurDtos;

    public  static FournisseurDto fromEntity(Fournisseur fournisseur){
        if (fournisseur == null){
            return null;
        }

        return FournisseurDto.builder()
                .id(fournisseur.getId())
                .numTel(fournisseur.getNom())
                .prenom(fournisseur.getPrenom())
                .email(fournisseur.getEmail())
                .photo(fournisseur.getPhoto())
                .numTel(fournisseur.getNumTel())
                .adresseDto(AdresseDto.fromEntity(fournisseur.getAdresse()))
                .idEntreprise(fournisseur.getEntrepriseId())
                .build();
    }

    public static Fournisseur toEntity(FournisseurDto dto){
        if (dto == null){
            return null;
        }

        Fournisseur fournisseur= new Fournisseur();

        fournisseur.setId(dto.getId());
        fournisseur.setNom(dto.getNom());
        fournisseur.setPrenom(dto.getPrenom());
        fournisseur.setEmail(dto.getEmail());
        fournisseur.setPhoto(dto.getPhoto());
        fournisseur.setNumTel(dto.getNumTel());
        fournisseur.setAdresse(AdresseDto.toEntity(dto.getAdresseDto()));
        fournisseur.setEntrepriseId(dto.getIdEntreprise());

        return fournisseur;

    }
}
