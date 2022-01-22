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
@Table(name = "utilisateur")
public class Utilisateur extends AbstractEntity{
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "email")
    private String email;
    @Column(name = "datenaissance")
    private String dateDeNaissance;
    @Column(name = "motdepasse")
    private String motDePasse;
    @Embedded
    private Adresse adresse;
    @Column(name = "photo")
    private String photo;
    @ManyToOne
    @JoinColumn(name = "identerprise")
    private Entreprise entreprise;
    @OneToMany(mappedBy = "utilisateur")
    private List<Roles> rolesList;

}
