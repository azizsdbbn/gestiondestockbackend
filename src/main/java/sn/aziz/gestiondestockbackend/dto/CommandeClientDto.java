package sn.aziz.gestiondestockbackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import sn.aziz.gestiondestockbackend.models.CommandeClient;
import sn.aziz.gestiondestockbackend.models.EtatCommande;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class CommandeClientDto {
    private Integer id;
    private String code;
    private Instant dateCmd;
    private ClientDto clientDto;
    private Integer idEntreprise;
    private EtatCommande etatCommande;
    @JsonIgnore
    private List<LigneCommandeClientDto> ligneCommandeClientDtos;
    public static CommandeClientDto fromEntity(CommandeClient commandeClient){
        if (commandeClient == null){
            return  null;
        }
        return CommandeClientDto.builder()
                .id(commandeClient.getId())
                .code(commandeClient.getCode())
                .clientDto(ClientDto.fromEntity(commandeClient.getClient()))
                .dateCmd(commandeClient.getDateCmd())
                .etatCommande(commandeClient.getEtatCommande())
                .idEntreprise(commandeClient.getEntrepriseId())
                .build();
    }
    public static CommandeClient toEntity(CommandeClientDto dto){
        if (dto == null){
            return  null;
        }

        CommandeClient commandeClient = new CommandeClient();

        commandeClient.setId(dto.getId());
        commandeClient.setCode(dto.getCode());
        commandeClient.setDateCmd(dto.getDateCmd());
        commandeClient.setEtatCommande(dto.getEtatCommande());
        commandeClient.setClient(ClientDto.toEntity(dto.getClientDto()));
        commandeClient.setEntrepriseId(dto.getIdEntreprise());

        return commandeClient;
    }
}
