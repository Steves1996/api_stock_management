package com.kamdev.gestionstock.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClientDto {

    private String nom;
    private String prenom;
    private AdresseDto adresse;
    private String photo;
    private String mail;
    private String numtel;
    private List<CommandeClientDto> commandeClientList;
}