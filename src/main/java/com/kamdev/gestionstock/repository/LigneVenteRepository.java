package com.kamdev.gestionstock.repository;

import com.kamdev.gestionstock.model.LigneVente;
import com.kamdev.gestionstock.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneVenteRepository extends JpaRepository<Integer, LigneVente> {
}
