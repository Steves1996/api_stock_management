package com.kamdev.gestionstock.validator;

import com.kamdev.gestionstock.dto.CategorieDto;
import com.kamdev.gestionstock.dto.FournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FournisseurValidator {

    public static List<String> validate(FournisseurDto fournisseurDto) {
        List<String> errors = new ArrayList<>();


        if (fournisseurDto == null) {
            errors.add("Veuillez renseigner les informations du fournisseur");
            return errors;
        }
        if (!StringUtils.hasLength(fournisseurDto.getNom())) {
            errors.add("Veuillez renseigner le nom du fournisseur");
        }
        if (!StringUtils.hasLength(fournisseurDto.getMail())) {
            errors.add("Veuillez renseigner l'email du fournisseur");
        }
        if (!StringUtils.hasLength(fournisseurDto.getNumTel())) {
            errors.add("Veuillez renseigner le numéro de téléphone du fournisseur");
        }
        return errors;
    }

}
