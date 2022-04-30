package com.kamdev.gestionstock.repository;

import com.kamdev.gestionstock.model.LigneCommandeFournisseur;
import com.kamdev.gestionstock.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeFounisseurRepository extends JpaRepository<Integer, LigneCommandeFournisseur> {
}
