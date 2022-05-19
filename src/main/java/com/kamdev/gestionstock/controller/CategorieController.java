package com.kamdev.gestionstock.controller;

import com.kamdev.gestionstock.controller.api.CategorieApi;
import com.kamdev.gestionstock.dto.CategorieDto;
import com.kamdev.gestionstock.repository.CategorieRepository;
import com.kamdev.gestionstock.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategorieController implements CategorieApi {

    private CategorieService categorieService;

    @Autowired
    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @Override
    public CategorieDto save(CategorieDto dto) {
        return categorieService.save(dto);
    }

    @Override
    public CategorieDto fidById(Integer id) {
        return categorieService.findById(id);
    }

    @Override
    public CategorieDto findByCodeCategory(String codeCategory) {
        return categorieService.findByCode(codeCategory);
    }

    @Override
    public List<CategorieDto> findAll() {
        return categorieService.findAll();
    }

    @Override
    public void delete(Integer id) {
        categorieService.delete(id);
    }
}
