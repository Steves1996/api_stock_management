package com.kamdev.gestionstock.dto;

import com.kamdev.gestionstock.model.Adresse;
import com.kamdev.gestionstock.model.Client;
import com.kamdev.gestionstock.model.Entreprise;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class EntrepriseDto {
    private Integer id;
    private String nom;
    private String description;
    private AdresseDto adresse;
    private String codefiscal;
    private String photo;
    private String email;
    private String numTel;
    private String siteWeb;
    private List<UtilisateurDto> utilisateurList;

    public static EntrepriseDto fromEntity(Entreprise entreprise) {
        if (entreprise == null) {
            return null;
            //TODO throw an exception
        }
        return EntrepriseDto.builder()
                .id(entreprise.getId())
                .nom(entreprise.getNom())
                .description(entreprise.getDescription())
                .adresse(AdresseDto.fromEntity(entreprise.getAdresse()))
                .codefiscal(entreprise.getCodefiscal())
                .photo(entreprise.getPhoto())
                .email(entreprise.getEmail())
                .numTel(entreprise.getNumTel())
                .siteWeb(entreprise.getSiteWeb())
                .utilisateurList(entreprise.getUtilisateurList() != null ?
                        entreprise.getUtilisateurList()
                                .stream()
                                .map(UtilisateurDto::fromEntity)
                                .collect(Collectors.toList()) : null)
                .build();
    }

    public static Entreprise toEntity(EntrepriseDto entrepriseDto) {
        if(entrepriseDto == null){
            return null;
            //TODO throw an exception
        }
        Entreprise entreprise = new Entreprise();
        entreprise.setId(entrepriseDto.getId());
        entreprise.setNom(entrepriseDto.getNom());
        entreprise.setEmail(entrepriseDto.getEmail());
        entreprise.setDescription(entrepriseDto.getDescription());
        entreprise.setNumTel(entrepriseDto.getNumTel());
        return entreprise;
    }
}
