package com.kamdev.gestionstock.repository;

import com.kamdev.gestionstock.model.LigneCommandeClient;
import com.kamdev.gestionstock.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeClientRepository extends JpaRepository<Integer, LigneCommandeClient> {
}
