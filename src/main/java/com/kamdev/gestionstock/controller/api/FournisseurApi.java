package com.kamdev.gestionstock.controller.api;

import com.kamdev.gestionstock.dto.EntrepriseDto;
import com.kamdev.gestionstock.dto.FournisseurDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kamdev.gestionstock.utils.Constants.APP_ROOT;

public interface FournisseurApi {

    @PostMapping(value = APP_ROOT + "/fournisseur/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto save(@RequestBody FournisseurDto dto);

    @GetMapping(value = APP_ROOT+"/fournisseur/{idFournisseur}",produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto findById(@PathVariable("idFournisseur") Integer id);

    @GetMapping(value = APP_ROOT+"/fournisseur/{name}",produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto findEntrepriseByNom(@PathVariable("name") String name);

    @GetMapping(value = APP_ROOT+"/fournisseur/all",produces = MediaType.APPLICATION_JSON_VALUE)
    List<FournisseurDto> findAll();

    @DeleteMapping(value = APP_ROOT+"/fournisseur/delete/{idFournisseur}")
    void delete(@PathVariable("idFournisseur") Integer id);
}
