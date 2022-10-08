package com.kamdev.gestionstock.services.auth;

import com.kamdev.gestionstock.dto.UtilisateurDto;
import com.kamdev.gestionstock.exception.EntityNotFoundException;
import com.kamdev.gestionstock.exception.ErrorCodes;
import com.kamdev.gestionstock.model.Utilisateur;
import com.kamdev.gestionstock.model.auth.ExtendedUser;
import com.kamdev.gestionstock.repository.UtilisateurRepository;
import com.kamdev.gestionstock.services.impl.UtilisateurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    @Autowired
    private UtilisateurServiceImpl service;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UtilisateurDto utilisateur = service.findUtilisateurByEmail(email);

        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        utilisateur.getRolesList().forEach(rolesDto -> authorityList.add(new SimpleGrantedAuthority(rolesDto.getRoleName())));
        return new ExtendedUser(utilisateur.getEmail(), utilisateur.getMotDePasse(), utilisateur.getEntreprise().getId(), authorityList );
    }
}
