package com.kamdev.gestionstock.dto;

import com.kamdev.gestionstock.model.LigneVente;
import com.kamdev.gestionstock.model.Ventes;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class  LigneVenteDto {
    private Integer id;
    private VentesDto vente;
    private BigDecimal quantite;
    private BigDecimal prixUnitaire;
    private ArticleDto articleDto;

    public static LigneVenteDto fromEntity(LigneVente ligneVente){
        if(ligneVente == null){
            return  null;
        }
        return LigneVenteDto.builder()
                .id(ligneVente.getId())
                .build();
    }

    public static LigneVente toEntity(LigneVenteDto dto){
        if(dto == null){
            return  null;
        }
        LigneVente ligneVente = new LigneVente();
        ligneVente.setId(dto.getId());

        return ligneVente;
    }

}
