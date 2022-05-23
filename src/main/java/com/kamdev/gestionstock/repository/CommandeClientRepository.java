package com.kamdev.gestionstock.repository;

import com.kamdev.gestionstock.model.CommandeClient;
import com.kamdev.gestionstock.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface CommandeClientRepository extends JpaRepository<CommandeClient, Integer > {
    Optional<CommandeClient> findCommandeClientByCode(String code);
}
