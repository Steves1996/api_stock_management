package com.kamdev.gestionstock.controller;

import com.kamdev.gestionstock.controller.api.VenteApi;
import com.kamdev.gestionstock.dto.VentesDto;
import com.kamdev.gestionstock.services.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VenteController implements VenteApi {
    private VenteService venteService;

    @Autowired
    public VenteController(VenteService venteService) {
        this.venteService = venteService;
    }

    @Override
    public VentesDto save(VentesDto dto) {
        return venteService.save(dto);
    }

    @Override
    public VentesDto findById(Integer id) {
        return venteService.findById(id);
    }

    @Override
    public VentesDto findByCode(String code) {
        return venteService.findByCode(code);
    }

    @Override
    public List<VentesDto> findAll() {
        return venteService.findAll();
    }

    @Override
    public void delete(Integer id) {
        venteService.delete(id);
    }
}
