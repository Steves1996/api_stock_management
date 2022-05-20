package com.kamdev.gestionstock.repository;

import com.kamdev.gestionstock.model.Fournisseur;
import com.kamdev.gestionstock.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer> {

    Optional<Fournisseur> findFournisseurByNom(String nom);
}
