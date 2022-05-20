package com.kamdev.gestionstock.services;

import com.kamdev.gestionstock.dto.EntrepriseDto;
import com.kamdev.gestionstock.dto.FournisseurDto;

import java.util.List;

public interface FournisseurService {
    FournisseurDto save(FournisseurDto dto);

    FournisseurDto findById(Integer id);

    FournisseurDto findFournisseurByNom(String name);

    List<FournisseurDto> findAll();

    void delete(Integer id);
}
