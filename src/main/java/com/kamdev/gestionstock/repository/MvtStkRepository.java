package com.kamdev.gestionstock.repository;

import com.kamdev.gestionstock.model.MvtStk;
import com.kamdev.gestionstock.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MvtStkRepository extends JpaRepository<MvtStk, Integer> {
}
