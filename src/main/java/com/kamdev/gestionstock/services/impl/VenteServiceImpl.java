package com.kamdev.gestionstock.services.impl;

import com.kamdev.gestionstock.dto.CommandeClientDto;
import com.kamdev.gestionstock.dto.LigneVenteDto;
import com.kamdev.gestionstock.dto.VentesDto;
import com.kamdev.gestionstock.exception.EntityNotFoundException;
import com.kamdev.gestionstock.exception.ErrorCodes;
import com.kamdev.gestionstock.exception.InvalidEntityException;
import com.kamdev.gestionstock.model.Article;
import com.kamdev.gestionstock.model.LigneVente;
import com.kamdev.gestionstock.model.Ventes;
import com.kamdev.gestionstock.repository.ArticleRepository;
import com.kamdev.gestionstock.repository.LigneVenteRepository;
import com.kamdev.gestionstock.repository.VenteRepository;
import com.kamdev.gestionstock.services.VenteService;
import com.kamdev.gestionstock.validator.VentesValidator;
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
public class VenteServiceImpl implements VenteService {

    private ArticleRepository articleRepository;
    private VenteRepository venteRepository;
    private LigneVenteRepository ligneVenteRepository;

    @Autowired
    public VenteServiceImpl(ArticleRepository articleRepository,
                            VenteRepository venteRepository,
                            LigneVenteRepository ligneVenteRepository) {
        this.articleRepository = articleRepository;
        this.venteRepository = venteRepository;
        this.ligneVenteRepository = ligneVenteRepository;
    }

    @Override
    public VentesDto save(VentesDto dto) {

        List<String> errors = VentesValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Ventes n'est pas valide");
            throw new InvalidEntityException("L'objet vete n'est pas valide", ErrorCodes.VENTE_NOT_VALID, errors);
        }
        List<String> articleErrors = new ArrayList<>();
        dto.getLigneVente().forEach(ligneVenteDto -> {
            Optional<Article> article = articleRepository.findById(ligneVenteDto.getArticleDto().getId());
            if (article.isEmpty()) {
                articleErrors.add("Aucun article avec l'id " + ligneVenteDto.getArticleDto().getId() + " n'a été trouve");
            }
        });

        if (!articleErrors.isEmpty()) {
            log.error("Un ou Plusieurs article(s) n'existe pas dans la BDD", errors);
            throw new InvalidEntityException("Un ou Plusieurs article(s) n'existe pas dans la BDD", ErrorCodes.VENTE_NOT_VALID, errors);
        }

        Ventes savedVente = venteRepository.save(dto.toEntity(dto));
        dto.getLigneVente().forEach(ligneVenteDto -> {
            LigneVente ligneVente = LigneVenteDto.toEntity(ligneVenteDto);
            ligneVente.setVente(savedVente);
            ligneVenteRepository.save(ligneVente);
        });

        return VentesDto.fromEntity(savedVente);
    }

    @Override
    public VentesDto findById(Integer id) {
        if (id == null) {
            log.error("Ventes Id est null");
            return null;
        }
        return venteRepository.findById(id)
                .map(VentesDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Aucune vente n'a été trouve dans la BDD", ErrorCodes.VENTE_NOT_FOUND));
    }

    @Override
    public VentesDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Vente code est null");
            return null;
        }
        return venteRepository.findVentesByCode(code)
                .map(VentesDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune vente n'a été trouvé", ErrorCodes.VENTE_NOT_FOUND
                ));
    }

    @Override
    public List<VentesDto> findAll() {
        return venteRepository.findAll().stream()
                .map(VentesDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id ==null){
            log.error("Vente est null");
            return;
        }
        venteRepository.deleteById(id);
    }
}
