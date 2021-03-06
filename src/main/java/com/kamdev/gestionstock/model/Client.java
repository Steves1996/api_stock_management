package com.kamdev.gestionstock.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "client")
public class Client extends AbstractEntity {

    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Embedded
    private Adresse adresse;
    @Column(name = "photo")
    private String photo;
    @Column(name = "mail")
    private String mail;
    @Column(name = "idEntreprise")
    private Integer idEntreprise;
    @Column(name = "numtel")
    private String numtel;
    @OneToMany(mappedBy = "client")
    private List<CommandeClient> commandeClientList;
}
