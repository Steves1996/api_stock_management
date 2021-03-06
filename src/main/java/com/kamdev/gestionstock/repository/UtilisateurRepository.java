package com.kamdev.gestionstock.repository;

import com.kamdev.gestionstock.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {
    Optional<Utilisateur> findUtilisateurByNom(String name);
}
