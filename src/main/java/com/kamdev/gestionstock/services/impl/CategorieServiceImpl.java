package com.kamdev.gestionstock.services.impl;

import com.kamdev.gestionstock.dto.CategorieDto;
import com.kamdev.gestionstock.exception.EntityNotFoundException;
import com.kamdev.gestionstock.exception.ErrorCodes;
import com.kamdev.gestionstock.exception.InvalidEntityException;
import com.kamdev.gestionstock.model.Categorie;
import com.kamdev.gestionstock.repository.CategorieRepository;
import com.kamdev.gestionstock.services.CategorieService;
import com.kamdev.gestionstock.validator.CategorieValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategorieServiceImpl implements CategorieService {

    private CategorieRepository categorieRepository;

    @Autowired
    public CategorieServiceImpl(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    @Override
    public CategorieDto save(CategorieDto dto) {
        List<String> errors = CategorieValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Categorie pas valid {}", dto);
            throw new InvalidEntityException("la categorie n'est pas valide", ErrorCodes.CATEGORIE_NOT_VALID, errors);
        }
        return CategorieDto.fromEntity(categorieRepository.save(CategorieDto.toEntity(dto)));
    }

    @Override
    public CategorieDto findById(Integer id) {
        if (id == null) {
            log.error("Categorie Id est null");
            return null;
        }
        Optional<Categorie> categorie = categorieRepository.findById(id);

        return Optional.of(CategorieDto.fromEntity(categorie.get())).orElseThrow(() ->
                new EntityNotFoundException("Cette categorie n'existe pas",
                        ErrorCodes.CATEGORIE_NOT_FOUND));
    }

    @Override
    public CategorieDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Code categorie est null");
            return null;
        }

        return categorieRepository.findCategorieByCode(code)
                .map(CategorieDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Cette categorie n'existe pas", ErrorCodes.CATEGORIE_NOT_FOUND));

    }

    @Override
    public List<CategorieDto> findAll() {
        return categorieRepository.findAll().stream()
                .map(CategorieDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Categorie Id est null");
            return;
        }
        categorieRepository.deleteById(id);
    }
}
