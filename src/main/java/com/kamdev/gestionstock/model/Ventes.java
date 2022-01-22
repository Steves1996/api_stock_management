package com.kamdev.gestionstock.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "ventes")
public class Ventes extends AbstractEntity{
    @Column(name = "code")
    private String code;
    @Column(name = "datevente")
    private Instant dateVente;
    @Column(name = "commentaire")
    private String commentaire;
}
