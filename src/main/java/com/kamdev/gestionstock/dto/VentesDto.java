package com.kamdev.gestionstock.dto;

import com.kamdev.gestionstock.model.Ventes;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.time.Instant;
import java.util.List;

@Data
@Builder
public class VentesDto {
    private Integer id;
    private String code;
    private Instant dateVente;
    private String commentaire;
    private List<LigneVenteDto> ligneVente;

    public static VentesDto fromEntity(Ventes ventes){
        if(ventes == null){
            return  null;
        }
        return VentesDto.builder()
                .id(ventes.getId())
                .code(ventes.getCode())
                .commentaire(ventes.getCommentaire())
                .build();
    }

    public static Ventes toEntity(VentesDto dto){
        if(dto == null){
            return  null;
        }
        Ventes ventes = new Ventes();
        ventes.setId(dto.getId());
        ventes.setCode(dto.getCode());
        ventes.setCommentaire(dto.getCommentaire());

        return ventes;
    }
}
