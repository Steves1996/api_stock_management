package com.kamdev.gestionstock.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "entreprise")
public class Entreprise extends AbstractEntity{
    @Column(name = "nom")
    private String nom;
    @Column(name = "description")
    private String description;
    @Embedded
    private Adresse adresse;
    @Column(name = "codefiscal")
    private String codefiscal;
    @Column(name = "photo")
    private String photo;
    @Column(name = "email")
    private String email;
    @Column(name = "numtel")
    private String numTel;
    @Column(name = "siteweb")
    private String siteWeb;
    @OneToMany(mappedBy = "entreprise")
    private List<Utilisateur> utilisateurList;
}
