package sn.aziz.gestiondestockbackend.controller;

import org.springframework.web.bind.annotation.RestController;
import sn.aziz.gestiondestockbackend.controller.api.VenteApi;
import sn.aziz.gestiondestockbackend.dto.VentesDto;
import sn.aziz.gestiondestockbackend.services.VentesService;

import java.util.List;

@RestController
public class VenteController implements VenteApi {

    private VentesService ventesService;

    public VenteController(VentesService ventesService) {
        this.ventesService = ventesService;
    }

    @Override
    public VentesDto save(VentesDto dto) {
        return ventesService.save(dto);
    }

    @Override
    public VentesDto findById(Integer id) {
        return ventesService.findById(id);
    }

    @Override
    public VentesDto findByCode(String code) {
        return ventesService.findByCode(code);
    }

    @Override
    public List<VentesDto> findAll() {
        return ventesService.findAll();
    }

    @Override
    public void delete(Integer id) {
        ventesService.delete(id);
    }
}
