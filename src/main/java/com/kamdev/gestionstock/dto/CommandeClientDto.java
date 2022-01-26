package com.kamdev.gestionstock.dto;

import com.kamdev.gestionstock.model.Client;
import com.kamdev.gestionstock.model.CommandeClient;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class CommandeClientDto {
    private Integer id;
    private String code;
    private Instant dateCommande;
    private ClientDto client;
    private List<LigneCommandeClientDto> ligneCommandeClients;

    public static CommandeClientDto fromEntity(CommandeClient commandeClient) {
        if(commandeClient == null){
            return null;
            //TODO throw an exception
        }
        return CommandeClientDto.builder()
                .id(commandeClient.getId())
                .code(commandeClient.getCode())
                .dateCommande(commandeClient.getDateCommande())
                .ligneCommandeClients(commandeClient.getLigneCommandeClients() != null ?
                        commandeClient.getLigneCommandeClients().stream()
                                .map(LigneCommandeClientDto::fromEntity)
                                .collect(Collectors.toList()):null)
                .build();
    }

    public static CommandeClient toEntity(CommandeClientDto commandeClientDto) {
        if(commandeClientDto == null){
            return null;
            //TODO throw an exception
        }
        CommandeClient commandeClient = new CommandeClient();
        commandeClient.setId(commandeClientDto.getId());
        commandeClient.setCode(commandeClientDto.getCode());
        commandeClient.setDateCommande(commandeClientDto.getDateCommande());
        return commandeClient;
    }
}
