package com.kamdev.gestionstock.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "commandefournisseur")
public class CommandeFournisseur extends AbstractEntity{
    @Column(name = "code")
    private String code;
    @Column(name = "datecommande")
    private String dateCommande;
    @ManyToOne
    @JoinColumn(name = "idfournisseur")
    private Fournisseur fournisseur;
    @OneToMany(mappedBy = "commandefournisseur")
    private List<LigneCommandeFournisseur> ligneCommandeFournisseurList;
}
