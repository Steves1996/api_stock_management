package com.kamdev.gestionstock.services.impl;

import com.kamdev.gestionstock.dto.ClientDto;
import com.kamdev.gestionstock.dto.EntrepriseDto;
import com.kamdev.gestionstock.dto.RolesDto;
import com.kamdev.gestionstock.dto.UtilisateurDto;
import com.kamdev.gestionstock.exception.EntityNotFoundException;
import com.kamdev.gestionstock.exception.ErrorCodes;
import com.kamdev.gestionstock.exception.InvalidEntityException;
import com.kamdev.gestionstock.model.Client;
import com.kamdev.gestionstock.model.Entreprise;
import com.kamdev.gestionstock.repository.EntrepriseRepository;
import com.kamdev.gestionstock.repository.RolesRepository;
import com.kamdev.gestionstock.services.EnterpriseService;
import com.kamdev.gestionstock.validator.ClientValidator;
import com.kamdev.gestionstock.validator.EntrepriseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.management.relation.Role;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
public class EnterpriseServiceImpl implements EnterpriseService {

    private EntrepriseRepository entrepriseRepository;
    private UtilisateurServiceImpl utilisateurService;
    private RolesRepository rolesRepository;

    @Autowired
    public EnterpriseServiceImpl(EntrepriseRepository entrepriseRepository,
                                 UtilisateurServiceImpl utilisateurService,
                                 RolesRepository rolesRepository) {
        this.entrepriseRepository = entrepriseRepository;
        this.utilisateurService = utilisateurService;
        this.rolesRepository = rolesRepository;
    }

    @Override
    public EntrepriseDto save(EntrepriseDto dto) {
        List<String> errors = EntrepriseValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Entrprise pas valid {}", dto);
            throw new InvalidEntityException("l'entreprise n'est pas valide", ErrorCodes.ENTREPRISE_NOT_VALID, errors);
        }

        EntrepriseDto savedEntreprise = EntrepriseDto.fromEntity(
                entrepriseRepository.save(EntrepriseDto.toEntity(dto))
        );
        UtilisateurDto utilisateurDto = fromEntreprise(savedEntreprise);

        UtilisateurDto savedUser = utilisateurService.save(utilisateurDto);

        RolesDto rolesDto = RolesDto.builder()
                .roleName("ADMIN")
                .utilisateur(savedUser)
                .build();

        rolesRepository.save(RolesDto.toEntity(rolesDto));
        return savedEntreprise;
    }

    private UtilisateurDto fromEntreprise(EntrepriseDto dto) {
        return UtilisateurDto.builder()
                .adresse(dto.getAdresse())
                .nom(dto.getNom())
                .prenom(dto.getCodefiscal())
                .email(dto.getEmail())
                .motDePasse(generateRandomPassword())
                .entreprise(dto)
                .dateDeNaissance(String.valueOf(Instant.now()))
                .photo(dto.getPhoto())
                .build();
    }

    private String generateRandomPassword() {
        return "Allen1205@";
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        if (id == null) {
            log.error("Entreprise Id est null");
            return null;
        }
        Optional<Entreprise> entreprise = entrepriseRepository.findById(id);

        return Optional.of(EntrepriseDto.fromEntity(entreprise.get())).orElseThrow(() ->
                new EntityNotFoundException("Cette entreprise n'existe pas",
                        ErrorCodes.ENTREPRISE_NOT_FOUND));
    }

    @Override
    public EntrepriseDto findEntrepriseByNom(String name) {
        if (!StringUtils.hasLength(name)) {
            log.error("Nom de l'entreprise est null");
            return null;
        }
        Optional<Entreprise> entreprise = entrepriseRepository.findEntrepriseByNom(name);

        return Optional.of(EntrepriseDto.fromEntity(entreprise.get())).orElseThrow(() ->
                new EntityNotFoundException("Cette entrepreise n'existe pas",
                        ErrorCodes.ENTREPRISE_NOT_FOUND));
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseRepository.findAll().stream()
                .map(EntrepriseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("l'entreprise Id est null");
            return;
        }
        entrepriseRepository.deleteById(id);
    }
}
