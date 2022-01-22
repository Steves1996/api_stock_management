package com.kamdev.gestionstock.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class EntrepriseDto {
    private String nom;
    private String description;
    private AdresseDto adresse;
    private String codefiscal;
    private String photo;
    private String email;
    private String numTel;
    private String siteWeb;
    private List<UtilisateurDto> utilisateurList;
}