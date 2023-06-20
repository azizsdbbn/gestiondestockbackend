package sn.aziz.gestiondestockbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import sn.aziz.gestiondestockbackend.controller.api.CommandeFournisseurApi;
import sn.aziz.gestiondestockbackend.dto.CommandeFournisseurDto;
import sn.aziz.gestiondestockbackend.services.CommandeFournisseurService;

import java.util.List;
@RestController
public class CommandeFournisseurController implements CommandeFournisseurApi {

    private CommandeFournisseurService commandeFournisseurService;

    @Autowired
    public CommandeFournisseurController(CommandeFournisseurService commandeFournisseurService) {
        this.commandeFournisseurService = commandeFournisseurService;
    }
    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto dto) {
        return commandeFournisseurService.save(dto);
    }
    @Override
    public CommandeFournisseurDto findById(Integer id) {
        return commandeFournisseurService.findById(id);
    }
    @Override
    public CommandeFournisseurDto findByCode(String code) {
        return commandeFournisseurService.findByCode(code);
    }
    @Override
    public List<CommandeFournisseurDto> findAll() {
        return commandeFournisseurService.findAll();
    }
    @Override
    public void delete(Integer id) {
        commandeFournisseurService.delete(id);
    }
}
