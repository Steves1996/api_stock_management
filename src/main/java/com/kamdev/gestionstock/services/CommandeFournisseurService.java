package com.kamdev.gestionstock.services;

import com.kamdev.gestionstock.dto.CommandeClientDto;
import com.kamdev.gestionstock.dto.CommandeFournisseurDto;

import java.util.List;

public interface CommandeFournisseurService {
    CommandeFournisseurDto save(CommandeFournisseurDto dto);

    CommandeFournisseurDto findById(Integer id);

    CommandeFournisseurDto findByCode(String code);

    List<CommandeFournisseurDto> findAll();

    void delete(Integer id);
}
