package com.kamdev.gestionstock.dto;

import com.kamdev.gestionstock.model.Adresse;
import com.kamdev.gestionstock.model.Client;
import com.kamdev.gestionstock.model.Utilisateur;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class UtilisateurDto {
    private Integer id;
    private String nom;
    private String prenom;
    private String email;
    private String dateDeNaissance;
    private String motDePasse;
    private AdresseDto adresse;
    private String photo;
    private EntrepriseDto entreprise;
    private List<RolesDto> rolesList;

    public static UtilisateurDto fromEntity(Utilisateur utilisateur) {
        if(utilisateur == null){
            return null;
            //TODO throw an exception
        }
        return UtilisateurDto.builder()
                .id(utilisateur.getId())
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())
                .email(utilisateur.getEmail())
                .motDePasse(utilisateur.getMotDePasse())
                .dateDeNaissance(utilisateur.getDateDeNaissance())
                .adresse(AdresseDto.fromEntity(utilisateur.getAdresse()))
                .photo(utilisateur.getPhoto())
                .entreprise(EntrepriseDto.fromEntity(utilisateur.getEntreprise()))
                .rolesList(utilisateur.getRolesList()!=null ?
                        utilisateur.getRolesList()
                                .stream()
                                .map(RolesDto::fromEntity)
                                .collect(Collectors.toList()) : null)
                .build();
    }
}
