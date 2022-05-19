package com.kamdev.gestionstock.controller;

import com.kamdev.gestionstock.controller.api.EntrepriseApi;
import com.kamdev.gestionstock.dto.EntrepriseDto;
import com.kamdev.gestionstock.services.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EntrepriseController implements EntrepriseApi {
    private EnterpriseService enterpriseService;

    @Autowired
    public EntrepriseController(EnterpriseService enterpriseService) {
        this.enterpriseService = enterpriseService;
    }

    @Override
    public EntrepriseDto save(EntrepriseDto dto) {
        return enterpriseService.save(dto);
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        return enterpriseService.findById(id);
    }

    @Override
    public EntrepriseDto findEntrepriseByNom(String name) {
        return enterpriseService.findEntrepriseByNom(name);
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return enterpriseService.findAll();
    }

    @Override
    public void delete(Integer id) {
        enterpriseService.delete(id);
    }
}
