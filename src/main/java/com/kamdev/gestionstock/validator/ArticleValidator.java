package com.kamdev.gestionstock.validator;

import com.kamdev.gestionstock.dto.ArticleDto;
import com.kamdev.gestionstock.dto.CategorieDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {

    public static List<String> validate (ArticleDto articleDto){
        List<String> errors = new ArrayList<>();

        if(articleDto == null){
            errors.add("Entrez les informations de l'article");
            return  errors;
        }
        if(!StringUtils.hasLength(articleDto.getCodeArticle())){
            errors.add("Veuillez renseigner le code de l'article");
        }
        if(!StringUtils.hasLength(articleDto.getDesignation())){
            errors.add("Veuillez renseigner la designation l'article");
        }
        if(articleDto.getPrixUnitaireHt() == null){
            errors.add("Veuillez renseigner le prix unitaire HT de l'article");
        }
        if(articleDto.getTauxTva() == null){
            errors.add("Veuillez renseigner le taux TVA de l'article");
        }
        if(articleDto.getPrixUnitaireTtc() == null){
            errors.add("Veuillez renseigner le prix TTC de l'article");
        }
        if(articleDto.getCategory() == null){
            errors.add("Veuillez renseigner la categorie de l'article");
        }
        return  errors;
    }
}
