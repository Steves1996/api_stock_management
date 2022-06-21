package com.kamdev.gestionstock.repository;

import com.kamdev.gestionstock.model.Article;
import com.kamdev.gestionstock.model.Categorie;
import com.kamdev.gestionstock.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
    Optional<Categorie> findCategorieByCode(String code);
}
