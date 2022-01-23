package com.kamdev.gestionstock.validator;

import com.kamdev.gestionstock.dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {
    public static List<String> validate(UtilisateurDto utilisateurDto) {
        List<String> errors = new ArrayList<>();

        if(utilisateurDto == null){
            errors.add("Veuillez renseigner les informations d'utilisateur");
            return  errors;
        }
        if (!StringUtils.hasLength(utilisateurDto.getNom())) {
            errors.add("Veuillez renseigner le nom d'utilisateur");
        }
        if (!StringUtils.hasLength(utilisateurDto.getEmail())) {
            errors.add("Veuillez renseigner l'email d'utilisateur");
        }
        if (!StringUtils.hasLength(utilisateurDto.getMotDePasse())) {
            errors.add("Veuillez renseigner le mot de passe d'utilisateur");
        }
        if (!StringUtils.hasLength(utilisateurDto.getDateDeNaissance())) {
            errors.add("Veuillez renseigner la date de naissance de d'utilisateur");
        }
        if (utilisateurDto.getAdresse() == null) {
            errors.add("Veuillez renseigner l'adresse d'utilisateur");
        } else {
            if (!StringUtils.hasLength(utilisateurDto.getAdresse().getAdresse1())) {
                errors.add("Le champs adresse 1 est obligatoire");
            }
            if (!StringUtils.hasLength(utilisateurDto.getAdresse().getVille())) {
                errors.add("Le champs ville est obligatoire");
            }
            if (!StringUtils.hasLength(utilisateurDto.getAdresse().getPays())) {
                errors.add("Le champs pays est obligatoire");
            }
        }
        return errors;

    }
}
