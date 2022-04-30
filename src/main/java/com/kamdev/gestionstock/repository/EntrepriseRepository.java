package com.kamdev.gestionstock.repository;

import com.kamdev.gestionstock.model.Entreprise;
import com.kamdev.gestionstock.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseRepository extends JpaRepository<Integer, Entreprise> {
}
