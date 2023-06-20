package sn.aziz.gestiondestockbackend.dto;

import lombok.Builder;
import lombok.Data;
import sn.aziz.gestiondestockbackend.models.Roles;
import sn.aziz.gestiondestockbackend.models.Utilisateur;

@Data
@Builder
public class RolesDto {
    private Integer id;
    private String roleName;
    private UtilisateurDto utilisateurDto;

    public static RolesDto fromEntity(Roles roles){
        if (roles == null){
            return null;
        }

        return RolesDto.builder()
                .id(roles.getId())
                .roleName(roles.getRoleName())
                .utilisateurDto(UtilisateurDto.fromEntity(roles.getUtilisateur()))
                .build();
    }

    public static Roles toEntity(RolesDto rolesDto){
        if (rolesDto== null){
            return null;
        }

        Roles roles = new Roles();
        roles.setId(rolesDto.getId());
        roles.setRoleName(rolesDto.getRoleName());
        roles.setUtilisateur(UtilisateurDto.toEntity(rolesDto.getUtilisateurDto()));
        return roles;
    }
}
