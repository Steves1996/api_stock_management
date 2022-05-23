package com.kamdev.gestionstock.services.impl;

import com.kamdev.gestionstock.dto.CommandeFournisseurDto;
import com.kamdev.gestionstock.dto.LigneCommandeFournisseurDto;
import com.kamdev.gestionstock.exception.EntityNotFoundException;
import com.kamdev.gestionstock.exception.ErrorCodes;
import com.kamdev.gestionstock.exception.InvalidEntityException;
import com.kamdev.gestionstock.model.Article;
import com.kamdev.gestionstock.model.CommandeFournisseur;
import com.kamdev.gestionstock.model.Fournisseur;
import com.kamdev.gestionstock.model.LigneCommandeFournisseur;
import com.kamdev.gestionstock.repository.ArticleRepository;
import com.kamdev.gestionstock.repository.CommandeFournisseurRepository;
import com.kamdev.gestionstock.repository.FournisseurRepository;
import com.kamdev.gestionstock.repository.LigneCommandeFounisseurRepository;
import com.kamdev.gestionstock.services.CommandeFournisseurService;
import com.kamdev.gestionstock.validator.CommandeFournisseurValidator;
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
public class CommandeFournisseurServiceImpl implements CommandeFournisseurService {

    private CommandeFournisseurRepository commandeFournisseurRepository;
    private LigneCommandeFounisseurRepository ligneCommandeFounisseurRepository;
    private FournisseurRepository fournisseurRepository;
    private ArticleRepository articleRepository;

    @Autowired
    public CommandeFournisseurServiceImpl(CommandeFournisseurRepository commandeFournisseurRepository,
                                          LigneCommandeFounisseurRepository ligneCommandeFounisseurRepository,
                                          FournisseurRepository fournisseurRepository,
                                          ArticleRepository articleRepository) {
        this.commandeFournisseurRepository = commandeFournisseurRepository;
        this.ligneCommandeFounisseurRepository = ligneCommandeFounisseurRepository;
        this.fournisseurRepository = fournisseurRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto dto) {

        List<String> errors = CommandeFournisseurValidator.validate(dto);

        if (!errors.isEmpty()) {
            log.error("Commande fournisseur n'est pas valide");
            throw new InvalidEntityException("La commande fournisseur n'est pas valide", ErrorCodes.COMMANDE_FOURNISSEUR_NOT_VALID, errors);
        }

        Optional<Fournisseur> fournisseur = fournisseurRepository.findById((dto.getFournisseur().getId()));
        if (fournisseur.isEmpty()) {
            log.warn("fpournisseur n'existe pas dans la base de donnée", dto.getFournisseur().getId());
            throw new EntityNotFoundException("Aucun fournisseur avec cette information n'existe dans la BDD", ErrorCodes.FOURNISSEUR_NOT_FOUND);
        }

        List<String> articleErrors = new ArrayList<>();
        if (dto.getLigneCommandeFournisseurList() != null) {
            dto.getLigneCommandeFournisseurList().forEach(lignCmdClt -> {
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

        CommandeFournisseur savedCmdFrs = commandeFournisseurRepository.save(CommandeFournisseurDto.toEntity(dto));
        if (dto.getLigneCommandeFournisseurList() != null) {
            dto.getLigneCommandeFournisseurList().forEach(liggCmdClt -> {
                LigneCommandeFournisseur ligneCommandeFournisseur = LigneCommandeFournisseurDto.toEntity(liggCmdClt);
                ligneCommandeFournisseur.setCommandefournisseur(savedCmdFrs);
                ligneCommandeFounisseurRepository.save(ligneCommandeFournisseur);
            });
        }
        return CommandeFournisseurDto.fromEntity(savedCmdFrs);
    }

    @Override
    public CommandeFournisseurDto findById(Integer id) {
        if (id == null) {
            log.error("Commande fournisseur est null");
            return null;
        }
        return commandeFournisseurRepository.findById(id)
                .map(CommandeFournisseurDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune commande fournisseur n'a été trouvé", ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND
                ));

    }

    @Override
    public CommandeFournisseurDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Commande fournisseur code est null");
            return null;
        }
        return commandeFournisseurRepository.findCommandeFournisseurByCode(code)
                .map(CommandeFournisseurDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune commande fournisseur n'a été trouvé", ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND
                ));
    }

    @Override
    public List<CommandeFournisseurDto> findAll() {
        return commandeFournisseurRepository.findAll()
                .stream().map(CommandeFournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id ==null){
            log.error("Commande fournisseur est null");
            return;
        }
        commandeFournisseurRepository.deleteById(id);
    }
}
