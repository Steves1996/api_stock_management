package com.kamdev.gestionstock.repository;

import com.kamdev.gestionstock.model.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur, Integer > {
    Optional<CommandeFournisseur> findCommandeFournisseurByCode(String code);
}
