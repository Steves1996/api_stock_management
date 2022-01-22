package com.kamdev.gestionstock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kamdev.gestionstock.model.Client;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClientDto {

    private Integer id;
    private String nom;
    private String prenom;
    private AdresseDto adresse;
    private String photo;
    private String mail;
    private String numtel;
    @JsonIgnore
    private List<CommandeClientDto> commandeClientList;

    public Client toEntity(ClientDto clientDto){
        return  Client.builder()
                .build();
    }
}
