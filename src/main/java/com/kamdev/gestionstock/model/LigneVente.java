package com.kamdev.gestionstock.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lignevente")
public class LigneVente extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "idbente")
    private Ventes vente;

    @Column(name = "quantite")
    private BigDecimal quantite;
}
