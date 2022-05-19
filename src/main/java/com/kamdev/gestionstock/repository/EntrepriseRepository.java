package com.kamdev.gestionstock.repository;

import com.kamdev.gestionstock.model.Client;
import com.kamdev.gestionstock.model.Entreprise;
import com.kamdev.gestionstock.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EntrepriseRepository extends JpaRepository<Entreprise,Integer> {
    Optional<Entreprise> findEntrepriseByNom(String nom);
}
