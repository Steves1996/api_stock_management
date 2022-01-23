package com.kamdev.gestionstock.dto;

import com.kamdev.gestionstock.model.Categorie;
import com.kamdev.gestionstock.model.Roles;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RolesDto {
    private Integer id;
    private String roleName;
    private UtilisateurDto utilisateur;

    public static RolesDto fromEntity(Roles roles) {
        if(roles == null){
            return null;
            //TODO throw an exception
        }
        return RolesDto.builder()
                .id(roles.getId())
                .roleName(roles.getRoleName())
                .utilisateur(UtilisateurDto.fromEntity(roles.getUtilisateur()))
                .build();
    }
}
