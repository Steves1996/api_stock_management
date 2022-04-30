package com.kamdev.gestionstock.repository;

import com.kamdev.gestionstock.model.Fournisseur;
import com.kamdev.gestionstock.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<Integer, Fournisseur> {
}
