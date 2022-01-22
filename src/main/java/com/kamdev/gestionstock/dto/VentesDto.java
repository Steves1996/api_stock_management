package com.kamdev.gestionstock.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.time.Instant;

@Data
@Builder
public class VentesDto {
    private String code;
    private Instant dateVente;
    private String commentaire;
}