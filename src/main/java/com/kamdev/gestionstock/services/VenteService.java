package com.kamdev.gestionstock.services;

import com.kamdev.gestionstock.dto.CommandeClientDto;
import com.kamdev.gestionstock.dto.VentesDto;

import java.util.List;

public interface VenteService {

    VentesDto save(VentesDto dto);

    VentesDto findById(Integer id);

    VentesDto findByCode(String code);

    List<VentesDto> findAll();

    void delete(Integer id);
}
