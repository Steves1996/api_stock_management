package com.kamdev.gestionstock.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class LigneCommandeFournisseurDto {
    private ArticleDto article;
    private CommandeFournisseurDto commandefournisseur;
    private BigDecimal quantite;
    private BigDecimal prixUnitaire;
}
