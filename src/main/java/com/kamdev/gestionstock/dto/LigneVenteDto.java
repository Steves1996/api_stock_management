package com.kamdev.gestionstock.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class LigneVenteDto {
    private VentesDto vente;

    private BigDecimal quantite;
    private BigDecimal prixUnitaire;
}