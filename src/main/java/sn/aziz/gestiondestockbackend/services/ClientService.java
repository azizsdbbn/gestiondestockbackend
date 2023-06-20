package sn.aziz.gestiondestockbackend.services;


import sn.aziz.gestiondestockbackend.dto.ClientDto;
import sn.aziz.gestiondestockbackend.dto.UtilisateurDto;

import java.util.List;

public interface ClientService {

    ClientDto save(ClientDto dto);
    ClientDto findById(Integer id);
    List<ClientDto> findAll();
    void delete(Integer id);
}
