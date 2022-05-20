package com.kamdev.gestionstock.controller.api;

import com.kamdev.gestionstock.dto.FournisseurDto;
import com.kamdev.gestionstock.dto.UtilisateurDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kamdev.gestionstock.utils.Constants.APP_ROOT;

public interface UtilisateurApi {

    @PostMapping(value = APP_ROOT + "/utilisateur/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto save(@RequestBody UtilisateurDto dto);

    @GetMapping(value = APP_ROOT+"/utilisateur/{idUtilisateur}",produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto findById(@PathVariable("idUtilisateur") Integer id);

    @GetMapping(value = APP_ROOT+"/utilisateur/{name}",produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto findUtilisateurByNom(@PathVariable("name") String name);

    @GetMapping(value = APP_ROOT+"/utilisateur/all",produces = MediaType.APPLICATION_JSON_VALUE)
    List<UtilisateurDto> findAll();

    @DeleteMapping(value = APP_ROOT+"/utilisateur/delete/{idUtilisateur}")
    void delete(@PathVariable("idUtilisateur") Integer id);
}
