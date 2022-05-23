package com.kamdev.gestionstock.services.impl;

import com.kamdev.gestionstock.dto.CommandeClientDto;
import com.kamdev.gestionstock.dto.LigneCommandeClientDto;
import com.kamdev.gestionstock.exception.EntityNotFoundException;
import com.kamdev.gestionstock.exception.ErrorCodes;
import com.kamdev.gestionstock.exception.InvalidEntityException;
import com.kamdev.gestionstock.model.Article;
import com.kamdev.gestionstock.model.Client;
import com.kamdev.gestionstock.model.CommandeClient;
import com.kamdev.gestionstock.model.LigneCommandeClient;
import com.kamdev.gestionstock.repository.ArticleRepository;
import com.kamdev.gestionstock.repository.ClientRepository;
import com.kamdev.gestionstock.repository.CommandeClientRepository;
import com.kamdev.gestionstock.repository.LigneCommandeClientRepository;
import com.kamdev.gestionstock.services.CommandeClientService;
import com.kamdev.gestionstock.validator.CommandeClientValidatror;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommandeClientServiceImpl implements CommandeClientService {

    private CommandeClientRepository commandeClientRepository;
    private ClientRepository clientRepository;
    private ArticleRepository articleRepository;

    private LigneCommandeClientRepository ligneCommandeClientRepository;

    @Autowired
    public CommandeClientServiceImpl(CommandeClientRepository commandeClientRepository,
                                     ClientRepository clientRepository,
                                     ArticleRepository articleRepository,
                                     LigneCommandeClientRepository ligneCommandeClientRepository) {
        this.commandeClientRepository = commandeClientRepository;
        this.clientRepository = clientRepository;
        this.articleRepository = articleRepository;
        this.ligneCommandeClientRepository = ligneCommandeClientRepository;
    }

    @Override
    public CommandeClientDto save(CommandeClientDto dto) {

        List<String> errors = CommandeClientValidatror.validate(dto);

        if (!errors.isEmpty()) {
            log.error("Commande client n'est pas valide");
            throw new InvalidEntityException("La commande client n'est pas valide", ErrorCodes.COMMANDE_CLIENT_NOT_VALID, errors);
        }

        Optional<Client> client = clientRepository.findById((dto.getClient().getId()));
        if (client.isEmpty()) {
            log.warn("Client n'existe pas dans la base de donnée", dto.getClient().getId());
            throw new EntityNotFoundException("Aucun client avec cette information n'existe dans la BDD", ErrorCodes.CLIENT_NOT_FOUND);
        }

        List<String> articleErrors = new ArrayList<>();
        if (dto.getLigneCommandeClients() != null) {
            dto.getLigneCommandeClients().forEach(lignCmdClt -> {
                if (lignCmdClt.getArticle() != null) {
                    Optional<Article> article = articleRepository.findById(lignCmdClt.getArticle().getId());
                    if (article.isEmpty()) {
                        articleErrors.add("L'article avec cette Id " + lignCmdClt.getArticle().getId() + "n'existe pas");
                    }
                } else {
                    articleErrors.add("Enregistrement impossible avec les articles vide");
                }
            });
        }

        if (!articleErrors.isEmpty()) {
            log.warn("Article n'existe pas");
            throw new InvalidEntityException("Article n'existe pas dans la BDD", ErrorCodes.ARTICLE_NOT_FOUND, articleErrors);
        }

        CommandeClient savedCmdClt = commandeClientRepository.save(CommandeClientDto.toEntity(dto));
        if (dto.getLigneCommandeClients() != null) {
            dto.getLigneCommandeClients().forEach(liggCmdClt -> {
                LigneCommandeClient ligneCommandeClient = LigneCommandeClientDto.toEntity(liggCmdClt);
                ligneCommandeClient.setCommandeClient(savedCmdClt);
                ligneCommandeClientRepository.save(ligneCommandeClient);
            });
        }
        return CommandeClientDto.fromEntity(savedCmdClt);
    }

    @Override
    public CommandeClientDto findById(Integer id) {
        if (id == null) {
            log.error("Commande client est null");
            return null;
        }
        return commandeClientRepository.findById(id)
                .map(CommandeClientDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune commande client n'a été trouvé", ErrorCodes.COMMANDE_CLIENT_NOT_FOUND
                ));

    }

    @Override
    public CommandeClientDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Commande Client code est null");
            return null;
        }
        return commandeClientRepository.findCommandeClientByCode(code)
                .map(CommandeClientDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune commande client n'a été trouvé", ErrorCodes.COMMANDE_CLIENT_NOT_FOUND
                ));
    }

    @Override
    public List<CommandeClientDto> findAll() {
        return commandeClientRepository.findAll()
                .stream().map(CommandeClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id ==null){
            log.error("Commande client est null");
            return;
        }
        commandeClientRepository.deleteById(id);
    }
}
