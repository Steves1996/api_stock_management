package com.kamdev.gestionstock.repository;

import com.kamdev.gestionstock.model.Categorie;
import com.kamdev.gestionstock.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Integer, Categorie> {
}
