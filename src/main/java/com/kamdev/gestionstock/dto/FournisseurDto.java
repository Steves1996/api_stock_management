package com.kamdev.gestionstock.dto;

import com.kamdev.gestionstock.model.Fournisseur;
import com.kamdev.gestionstock.model.LigneCommandeClient;
import lombok.Builder;
import lombok.Data;
import org.apache.tomcat.jni.Address;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class FournisseurDto {
    private Integer id;
    private String nom;
    private String prenom;
    private AdresseDto adresse;
    private String photo;
    private String mail;
    private String numTel;
    private List<CommandeFournisseurDto> commandeFournisseurList;

    public static FournisseurDto fromEntity(Fournisseur fournisseur) {
        if(fournisseur == null){
            return null;
            //TODO throw an exception
        }
        //Mapping effectue de Categorie <-> CategorieDto
        return FournisseurDto.builder()
                .id(fournisseur.getId())
                .nom(fournisseur.getNom())
                .prenom(fournisseur.getPrenom())
                .adresse(AdresseDto.fromEntity(fournisseur.getAdresse()))
                .photo(fournisseur.getPhoto())
                .mail(fournisseur.getMail())
                .numTel(fournisseur.getNumTel())
                .commandeFournisseurList(fournisseur.getCommandeFournisseurList() != null ?
                        fournisseur.getCommandeFournisseurList().stream()
                                .map(CommandeFournisseurDto::fromEntity)
                                .collect(Collectors.toList()):null)
                .build();
    }

    public static Fournisseur toEntity(FournisseurDto fournisseurDto){
        if(fournisseurDto == null){
            return null;
            //TODO throw an exception
        }
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(fournisseurDto.getId());
        fournisseur.setNom(fournisseurDto.getNom());
        fournisseur.setPhoto(fournisseurDto.getPhoto());
        fournisseur.setPrenom(fournisseurDto.getPrenom());
        fournisseur.setMail(fournisseurDto.getMail());
        fournisseur.setNumTel(fournisseurDto.getNumTel());
        fournisseur.setAdresse(AdresseDto.toEntity(fournisseurDto.getAdresse()));
        return fournisseur;
    }
}
