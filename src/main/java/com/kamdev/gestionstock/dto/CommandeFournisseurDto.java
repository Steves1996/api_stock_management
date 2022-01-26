package com.kamdev.gestionstock.dto;

import com.kamdev.gestionstock.model.CommandeClient;
import com.kamdev.gestionstock.model.CommandeFournisseur;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class CommandeFournisseurDto {
    private Integer id;
    private String code;
    private String dateCommande;
    private FournisseurDto fournisseur;
    private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurList;

    public static CommandeFournisseurDto fromEntity(CommandeFournisseur commandeFournisseur) {
        if(commandeFournisseur == null){
            return null;
            //TODO throw an exception
        }
        return CommandeFournisseurDto.builder()
                .id(commandeFournisseur.getId())
                .code(commandeFournisseur.getCode())
                .dateCommande(commandeFournisseur.getDateCommande())
                .ligneCommandeFournisseurList(commandeFournisseur.getLigneCommandeFournisseurList() != null ?
                        commandeFournisseur.getLigneCommandeFournisseurList().stream()
                                .map(LigneCommandeFournisseurDto::fromEntity)
                                .collect(Collectors.toList()):null)
                .build();
    }

    public static CommandeFournisseur toEntity(CommandeFournisseurDto commandeFournisseurDto) {
        if(commandeFournisseurDto == null){
            return null;
            //TODO throw an exception
        }
        CommandeFournisseur commandeFournisseur = new CommandeFournisseur();
        commandeFournisseur.setId(commandeFournisseurDto.getId());
        commandeFournisseur.setCode(commandeFournisseurDto.getCode());
        commandeFournisseur.setDateCommande(commandeFournisseurDto.getDateCommande());
        return commandeFournisseur;
    }
}
