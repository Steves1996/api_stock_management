package com.kamdev.gestionstock.services;

import com.kamdev.gestionstock.dto.CategorieDto;
import com.kamdev.gestionstock.dto.ClientDto;

import java.util.List;

public interface ClientService {

    ClientDto save(ClientDto dto);

    ClientDto findById(Integer id);

    ClientDto findClientByNom(String name);

    List<ClientDto> findAll();

    void delete(Integer id);
}
