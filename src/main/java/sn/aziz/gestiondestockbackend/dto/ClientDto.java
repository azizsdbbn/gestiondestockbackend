package sn.aziz.gestiondestockbackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import sn.aziz.gestiondestockbackend.models.Client;

import java.util.List;

@Data
@Builder
public class ClientDto {
    private Integer id;
    private String nom;
    private  String prenom;
    private AdresseDto adresseDto;
    private String email;
    private String photo;
    private String numTel;
    private Integer idEntreprise;
    @JsonIgnore
    private List<CommandeClientDto> commandeClientDtos;

    public  static ClientDto fromEntity(Client client){
        if (client == null){
            return null;
        }

        return ClientDto.builder()
                .id(client.getId())
                .numTel(client.getNom())
                .prenom(client.getPrenom())
                .email(client.getEmail())
                .photo(client.getPhoto())
                .numTel(client.getNumTel())
                .adresseDto(AdresseDto.fromEntity(client.getAdresse()))
                .idEntreprise(client.getEntrepriseId())
                .build();
    }

    public static Client toEntity(ClientDto clientDto){
        if (clientDto == null){
            return null;
        }

        Client client = new Client();
        client.setId(clientDto.getId());
        client.setNom(clientDto.getNom());
        client.setPrenom(clientDto.getPrenom());
        client.setEmail(clientDto.getEmail());
        client.setPhoto(clientDto.getPhoto());
        client.setNumTel(clientDto.getNumTel());
        client.setAdresse(AdresseDto.toEntity(clientDto.getAdresseDto()));
        client.setEntrepriseId(clientDto.getIdEntreprise());
        return client;

    }


}
