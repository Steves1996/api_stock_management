package com.kamdev.gestionstock.services;

import com.kamdev.gestionstock.dto.FournisseurDto;
import com.kamdev.gestionstock.dto.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {
    UtilisateurDto save(UtilisateurDto dto);

    UtilisateurDto findById(Integer id);

    UtilisateurDto findUtilisateurByNom(String name);

    List<UtilisateurDto> findAll();

    void delete(Integer id);
}
