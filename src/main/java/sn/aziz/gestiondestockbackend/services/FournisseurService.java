package sn.aziz.gestiondestockbackend.services;


import sn.aziz.gestiondestockbackend.dto.ClientDto;
import sn.aziz.gestiondestockbackend.dto.FournisseurDto;

import java.util.List;

public interface FournisseurService {

    FournisseurDto save(FournisseurDto dto);
    FournisseurDto findById(Integer id);
    List<FournisseurDto> findAll();
    void delete(Integer id);
}
