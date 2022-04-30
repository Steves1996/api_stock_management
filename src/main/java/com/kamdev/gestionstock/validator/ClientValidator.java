package com.kamdev.gestionstock.validator;

import com.kamdev.gestionstock.dto.CategorieDto;
import com.kamdev.gestionstock.dto.ClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {

    public static List<String> validate(ClientDto clientDto) {
        List<String> errors = new ArrayList<>();

        if(clientDto == null){
            errors.add("Entrez les informations du client");
            return  errors;
        }
        if (!StringUtils.hasLength(clientDto.getNom())) {
            errors.add("Veuillez renseigner le nom client");
        }
        if (!StringUtils.hasLength(clientDto.getNumtel())) {
            errors.add("Veuillez renseigner le numéro de téléphone du client");
        }
        return errors;
    }
}
