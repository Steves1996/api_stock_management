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
@Table(name = "fournisseur")
public class Fournisseur extends AbstractEntity {

    @Column(name = "nom")
    private String nom;
    private String prenom;
    @Column(name = "prenom")
    @Embedded
    private Adresse adresse;
    @Column(name = "photo")
    private String photo;
    @Column(name = "mail")
    private String mail;
    @Column(name = "numtel")
    private String numTel;
    @OneToMany(mappedBy = "fournisseur")
    private List<CommandeFournisseur> commandeFournisseurList;
}
