package com.kamdev.gestionstock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kamdev.gestionstock.model.Categorie;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategorieDto {
    private Integer id;
    private  String code;
    private  String designation;
    private  Integer idEntreprise;
    @JsonIgnore
    private List<ArticleDto> articleList;

    public static CategorieDto fromEntity(Categorie categorie) {
        if(categorie == null){
            return null;
            //TODO throw an exception
        }
        //Mapping effectue de Categorie <-> CategorieDto
        return CategorieDto.builder()
                .id(categorie.getId())
                .code(categorie.getCode())
                .designation(categorie.getDesignation())
                .idEntreprise(categorie.getIdEntreprise())
                .build();
    }

    public static Categorie toEntity(CategorieDto categorieDto){
        if(categorieDto == null){
            return null;
            //TODO throw an exception
        }
        Categorie categorie = new Categorie();
        categorie.setId(categorieDto.getId());
        categorie.setCode(categorieDto.getCode());
        categorie.setDesignation(categorieDto.getDesignation());
        categorie.setIdEntreprise(categorieDto.getIdEntreprise());
        return categorie;
    }
}
