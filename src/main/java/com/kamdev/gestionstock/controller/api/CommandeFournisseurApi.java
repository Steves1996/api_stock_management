package com.kamdev.gestionstock.controller.api;

import com.kamdev.gestionstock.dto.CommandeFournisseurDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kamdev.gestionstock.utils.Constants.FOURNISSEUR_ENDPOINT;

@Api(FOURNISSEUR_ENDPOINT)
public interface CommandeFournisseurApi {
    @PostMapping(FOURNISSEUR_ENDPOINT+"/create")
    CommandeFournisseurDto save(@RequestBody CommandeFournisseurDto dto);

    @GetMapping(FOURNISSEUR_ENDPOINT+"/{idCommandeFournisseur}")
    CommandeFournisseurDto findById(@PathVariable("idCommandeFournisseur") Integer id);

    @GetMapping(FOURNISSEUR_ENDPOINT+"/{codeCommandeFournisseur}")
    CommandeFournisseurDto findByCode(@PathVariable("codeCommandeFournisseur") String code);

    @GetMapping(FOURNISSEUR_ENDPOINT+"/all")
    List<CommandeFournisseurDto> findAll();

    @DeleteMapping(FOURNISSEUR_ENDPOINT+"/delete/{idCommandeFournisseur}")
    void delete(@PathVariable("idCommandeFournisseur") Integer id);
}
