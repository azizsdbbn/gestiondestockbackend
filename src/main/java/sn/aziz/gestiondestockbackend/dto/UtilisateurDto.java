package sn.aziz.gestiondestockbackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import sn.aziz.gestiondestockbackend.models.Utilisateur;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class UtilisateurDto {
    private Integer id;
    private  String firstName;
    private  String lastName;
    private  String email;
    private  String password;
    private Instant dateNaissance;
    private AdresseDto adresseDto;
    @JsonIgnore
    private EntrepriseDto entrepriseDto;
    @JsonIgnore
    private List<RolesDto> rolesDtos;

    public static UtilisateurDto fromEntity(Utilisateur utilisateur){
        if (utilisateur==null){
            return null;
        }

        return UtilisateurDto.builder()
                .id(utilisateur.getId())
                .firstName(utilisateur.getFirstName())
                .lastName(utilisateur.getLastName())
                .email(utilisateur.getEmail())
                .password(utilisateur.getPassword())
                .dateNaissance(utilisateur.getDateNaissance())
                .adresseDto(AdresseDto.fromEntity(utilisateur.getAdresse()))
                .entrepriseDto(EntrepriseDto.fromEntity(utilisateur.getEntreprise()))
                .rolesDtos(utilisateur.getRoles()!=null?
                        utilisateur.getRoles().stream()
                                .map(RolesDto::fromEntity)
                                .collect(Collectors.toList()): null )
                .build();
    }

    public static Utilisateur toEntity(UtilisateurDto utilisateurDto){
        if (utilisateurDto == null){
            return null;
        }

        Utilisateur utilisateur = new Utilisateur();

        utilisateur.setId(utilisateurDto.getId());
        utilisateur.setFirstName(utilisateurDto.getFirstName());
        utilisateur.setLastName(utilisateurDto.getLastName());
        utilisateur.setEmail(utilisateurDto.getEmail());
        utilisateur.setPassword(utilisateurDto.getPassword());
        utilisateur.setDateNaissance(utilisateurDto.getDateNaissance());
        utilisateur.setAdresse(AdresseDto.toEntity(utilisateurDto.getAdresseDto()));
        utilisateur.setEntreprise(EntrepriseDto.toEntity(utilisateurDto.getEntrepriseDto()));
        return utilisateur;
    }
}
