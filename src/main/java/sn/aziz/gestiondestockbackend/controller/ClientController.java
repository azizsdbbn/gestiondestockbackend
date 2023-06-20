package sn.aziz.gestiondestockbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import sn.aziz.gestiondestockbackend.controller.api.ClientApi;
import sn.aziz.gestiondestockbackend.dto.ClientDto;
import sn.aziz.gestiondestockbackend.services.ClientService;

import java.util.List;

@RestController
public class ClientController implements ClientApi {

    private ClientService clientService;
    @Autowired
    public void setArticleService(ClientService clientService) {
        this.clientService = clientService;
    }
    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @Override
    public ClientDto save(ClientDto dto) {
        return clientService.save(dto);
    }
    @Override
    public ClientDto findById(Integer id) {
        return clientService.findById(id);
    }
    @Override
    public List<ClientDto> findAll() {
        return clientService.findAll();
    }
    @Override
    public void delete(Integer id) {
        clientService.delete(id);
    }
}
