package com.kamdev.gestionstock.services;

import com.kamdev.gestionstock.dto.ClientDto;
import com.kamdev.gestionstock.dto.EntrepriseDto;

import java.util.List;

public interface EnterpriseService {
    EntrepriseDto save(EntrepriseDto dto);

    EntrepriseDto findById(Integer id);

    EntrepriseDto findEntrepriseByNom(String name);

    List<EntrepriseDto> findAll();

    void delete(Integer id);
}
