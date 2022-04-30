package com.kamdev.gestionstock.repository;

import com.kamdev.gestionstock.model.CommandeClient;
import com.kamdev.gestionstock.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeClientRepository extends JpaRepository<Integer, CommandeClient> {
}
