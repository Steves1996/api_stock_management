package com.kamdev.gestionstock.repository;

import com.kamdev.gestionstock.model.Utilisateur;
import com.kamdev.gestionstock.model.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenteRepository extends JpaRepository<Integer, Ventes> {
}
