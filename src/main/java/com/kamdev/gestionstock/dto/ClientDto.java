package com.kamdev.gestionstock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kamdev.gestionstock.model.Article;
import com.kamdev.gestionstock.model.Client;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

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


    public static ClientDto fromEntity(Client client) {
        if(client == null){
            return null;
            //TODO throw an exception
        }
        return ClientDto.builder()
                .id(client.getId())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .photo(client.getPhoto())
                .mail(client.getMail())
                .numtel(client.getNumtel())
                .commandeClientList(client.getCommandeClientList() != null ?
                        client.getCommandeClientList().stream()
                                .map(CommandeClientDto::fromEntity)
                                .collect(Collectors.toList()) : null)
                .build();
    }

    public static Client toEntity(ClientDto clientDto) {
        if(clientDto == null){
            return null;
            //TODO throw an exception
        }
        Client client = new Client();
        client.setId(clientDto.getId());
        client.setNom(clientDto.getNom());
        client.setPrenom(clientDto.getPrenom());
        client.setPhoto(clientDto.getPhoto());
        client.setMail(clientDto.getMail());
        client.setNumtel(clientDto.getNumtel());
        return client;
    }
}
