package com.kamdev.gestionstock.controller.api;

import com.kamdev.gestionstock.dto.ArticleDto;
import com.kamdev.gestionstock.dto.EntrepriseDto;
import com.kamdev.gestionstock.dto.FournisseurDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kamdev.gestionstock.utils.Constants.APP_ROOT;

public interface FournisseurApi {

    @PostMapping(value = APP_ROOT + "/fournisseur/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un fournisseur", notes = "Cette methode permet d'enregistrer ou modifier un fournisseur", response = FournisseurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet fournisseur cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet fournisseur n'est pas valide")
    })
    FournisseurDto save(@RequestBody FournisseurDto dto);

    @GetMapping(value = APP_ROOT+"/fournisseur/{idFournisseur}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche un fournisseur par Id", notes = "Cette methode permet de chercher un fournisseur par son ID", response = FournisseurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le fournisseur a été trouve dans la BD"),
            @ApiResponse(code = 404, message = "Aucun fournisseur n'a été trouve dans la BD")
    })
    FournisseurDto findById(@PathVariable("idFournisseur") Integer id);

    @GetMapping(value = APP_ROOT+"/fournisseur/{name}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche un fournisseur pas son Nom", notes = "Cette methode permet de chercher un fournisseur par son nom", response = FournisseurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le fournisseur a été trouve dans la BD"),
            @ApiResponse(code = 404, message = "Aucun fournisseur n'a été trouve dans la BD")
    })
    FournisseurDto findEntrepriseByNom(@PathVariable("name") String name);

    @GetMapping(value = APP_ROOT+"/fournisseur/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoie la liste des fournisseurs", notes = "Cette methode permet de chercher et de renvoyer la liste des fournisseur", responseContainer = "List<FournisseurDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des fournisseurs"),
    })
    List<FournisseurDto> findAll();

    @DeleteMapping(value = APP_ROOT+"/fournisseur/delete/{idFournisseur}")
    @ApiOperation(value = "Supprimer un fournisseur", notes = "Cette methode permet de chercher et de supprimer un fournisseur", response = FournisseurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Fournisseur supprimer"),
    })
    void delete(@PathVariable("idFournisseur") Integer id);
}
