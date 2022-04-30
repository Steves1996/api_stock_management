package com.kamdev.gestionstock.validator;

import com.kamdev.gestionstock.dto.CategorieDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategorieValidator {

    public static List<String> validate (CategorieDto categorieDto){
        List<String> errors = new ArrayList<>();

        if(categorieDto == null){
            errors.add("Entrez les informations de la catégorie");
            return  errors;
        }
        if(!StringUtils.hasLength(categorieDto.getCode())){
            errors.add("Veuillez renseigner le code de la categorie");
        }
        if(!StringUtils.hasLength(categorieDto.getDesignation())){
            errors.add("Veuillez renseigner la désignation de la categorie");
        }
        return  errors;
    }
}
