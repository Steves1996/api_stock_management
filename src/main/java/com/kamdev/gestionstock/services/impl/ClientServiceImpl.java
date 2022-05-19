package com.kamdev.gestionstock.services.impl;

import com.kamdev.gestionstock.dto.CategorieDto;
import com.kamdev.gestionstock.dto.ClientDto;
import com.kamdev.gestionstock.exception.EntityNotFoundException;
import com.kamdev.gestionstock.exception.ErrorCodes;
import com.kamdev.gestionstock.exception.InvalidEntityException;
import com.kamdev.gestionstock.model.Categorie;
import com.kamdev.gestionstock.model.Client;
import com.kamdev.gestionstock.repository.ClientRepository;
import com.kamdev.gestionstock.services.ClientService;
import com.kamdev.gestionstock.validator.CategorieValidator;
import com.kamdev.gestionstock.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDto save(ClientDto dto) {
        List<String> errors = ClientValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Client pas valid {}", dto);
            throw new InvalidEntityException("le client n'est pas valide", ErrorCodes.CLIENT_NOT_VALID, errors);
        }
        return ClientDto.fromEntity(clientRepository.save(ClientDto.toEntity(dto)));
    }

    @Override
    public ClientDto findById(Integer id) {
        if (id == null) {
            log.error("Client Id est null");
            return null;
        }
        Optional<Client> client = clientRepository.findById(id);

        return Optional.of(ClientDto.fromEntity(client.get())).orElseThrow(() ->
                new EntityNotFoundException("Ce client n'existe pas",
                        ErrorCodes.CLIENT_NOT_FOUND));
    }

    @Override
    public ClientDto findClientByNom(String name) {
        if (StringUtils.hasLength(name)) {
            log.error("Nom du client est null");
            return null;
        }
        Optional<Client> client = clientRepository.findClientByNom(name);

        return Optional.of(ClientDto.fromEntity(client.get())).orElseThrow(() ->
                new EntityNotFoundException("Ce Client n'existe pas",
                        ErrorCodes.CLIENT_NOT_FOUND));
    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream()
                .map(ClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Client Id est null");
            return;
        }
        clientRepository.deleteById(id);
    }
}
