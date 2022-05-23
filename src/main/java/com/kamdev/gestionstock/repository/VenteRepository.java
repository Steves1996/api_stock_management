package com.kamdev.gestionstock.repository;

import com.kamdev.gestionstock.model.Utilisateur;
import com.kamdev.gestionstock.model.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VenteRepository extends JpaRepository<Ventes,Integer> {
    Optional<Ventes> findVentesByCode(String code);
}
