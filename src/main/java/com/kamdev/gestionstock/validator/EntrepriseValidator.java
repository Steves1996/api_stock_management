package com.kamdev.gestionstock.validator;

import com.kamdev.gestionstock.dto.ClientDto;
import com.kamdev.gestionstock.dto.EntrepriseDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EntrepriseValidator {
    public static List<String> validate(EntrepriseDto entrepriseDto) {
        List<String> errors = new ArrayList<>();

        if(entrepriseDto == null){
            errors.add("Entrez les informations de l'entreprise");
            return  errors;
        }
        if (!StringUtils.hasLength(entrepriseDto.getNom())) {
            errors.add("Veuillez renseigner le nom de l'entreprise");
        }
        if (!StringUtils.hasLength(entrepriseDto.getNumTel())) {
            errors.add("Veuillez renseigner le numéro de téléphone de l'entreprise");
        }
        return errors;
    }
}
