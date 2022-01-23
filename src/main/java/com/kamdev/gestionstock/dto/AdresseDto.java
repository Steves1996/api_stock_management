package com.kamdev.gestionstock.dto;

import com.kamdev.gestionstock.model.Adresse;
import com.kamdev.gestionstock.model.Categorie;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Data
@Builder
public class AdresseDto {
    private String adresse1;
    private String adresse2;
    private String ville;
    private String codePostale;
    private String pays;

    public static AdresseDto fromEntity(Adresse adresse) {
        if(adresse == null){
            return null;
            //TODO throw an exception
        }
        //Mapping effectue de adresse <-> AdresseDto
        return AdresseDto.builder()
                .adresse1(adresse.getAdresse1())
                .adresse2(adresse.getAdresse2())
                .codePostale(adresse.getCodePostale())
                .ville(adresse.getVille())
                .pays(adresse.getPays())
                .build();
    }

    public  Adresse toEntity(AdresseDto adresseDto){
        if(adresseDto == null){
            return null;
            //TODO throw an exception
        }
        Adresse adresse = new Adresse();
        adresse.setAdresse1(adresseDto.getAdresse1());
        adresse.setAdresse2(adresseDto.getAdresse2());
        adresse.setCodePostale(adresseDto.getCodePostale());
        adresse.setPays(adresseDto.getPays());
        adresse.setVille(adresseDto.getVille());
        return adresse;
    }
}
