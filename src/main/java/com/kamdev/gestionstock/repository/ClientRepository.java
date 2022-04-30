package com.kamdev.gestionstock.repository;

import com.kamdev.gestionstock.model.Client;
import com.kamdev.gestionstock.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Integer, Client> {
}
