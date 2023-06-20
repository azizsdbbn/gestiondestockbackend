package sn.aziz.gestiondestockbackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import sn.aziz.gestiondestockbackend.models.CommandeFournisseur;
import sn.aziz.gestiondestockbackend.models.EtatCommande;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class CommandeFournisseurDto {
    private Integer id;
    private String code;
    private Instant dateCmd;
    private FournisseurDto fournisseurDto;
    private EtatCommande etatCommande;
    private Integer idEntreprise;
    @JsonIgnore
    private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurDtos;

    public static CommandeFournisseurDto fromEntity(CommandeFournisseur commandeFournisseur){
        if (commandeFournisseur== null){
            return  null;
        }
        return CommandeFournisseurDto.builder()
                .id(commandeFournisseur.getId())
                .code(commandeFournisseur.getCode())
                .fournisseurDto(FournisseurDto.fromEntity(commandeFournisseur.getFournisseur()))
                .dateCmd(commandeFournisseur.getDateCmd())
                .etatCommande(commandeFournisseur.getEtatCommande())
                .idEntreprise(commandeFournisseur.getEntrepriseId())
                .build();
    }

    public static CommandeFournisseur toEntity(CommandeFournisseurDto dto){
        if (dto == null){
            return  null;
        }

        CommandeFournisseur commandeFournisseur = new CommandeFournisseur();

        commandeFournisseur.setId(dto.getId());
        commandeFournisseur.setCode(dto.getCode());
        commandeFournisseur.setDateCmd(dto.getDateCmd());
        commandeFournisseur.setEtatCommande(dto.getEtatCommande());
        commandeFournisseur.setFournisseur(FournisseurDto.toEntity(dto.getFournisseurDto()));
        commandeFournisseur.setEntrepriseId(dto.getIdEntreprise());

        return commandeFournisseur;
    }
}
