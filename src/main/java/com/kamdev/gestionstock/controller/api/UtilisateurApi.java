package com.kamdev.gestionstock.controller.api;

import com.kamdev.gestionstock.dto.ClientDto;
import com.kamdev.gestionstock.dto.FournisseurDto;
import com.kamdev.gestionstock.dto.UtilisateurDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kamdev.gestionstock.utils.Constants.APP_ROOT;

public interface UtilisateurApi {

    @PostMapping(value = APP_ROOT + "/utilisateur/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un utilisateur", notes = "Cette methode permet d'enregistrer ou modifier un utilisateur", response = UtilisateurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet utilisateur cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet utilisateur n'est pas valide")
    })
    UtilisateurDto save(@RequestBody UtilisateurDto dto);

    @GetMapping(value = APP_ROOT+"/utilisateur/{idUtilisateur}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche un utilisateur par Id", notes = "Cette methode permet de chercher un utilisateur par son ID", response = UtilisateurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le utilisateur a été trouve dans la BD"),
            @ApiResponse(code = 404, message = "Aucun utilisateur n'a été trouve dans la BD")
    })
    UtilisateurDto findById(@PathVariable("idUtilisateur") Integer id);

    @GetMapping(value = APP_ROOT+"/utilisateur/{name}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche un utilisateur pas son Nom", notes = "Cette methode permet de chercher un utilisateur par son nom", response = UtilisateurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le utilisateur a été trouve dans la BD"),
            @ApiResponse(code = 404, message = "Aucun utilisateur n'a été trouve dans la BD")
    })
    UtilisateurDto findUtilisateurByNom(@PathVariable("name") String name);

    @GetMapping(value = APP_ROOT+"/utilisateur/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoie la liste des utilisateur", notes = "Cette methode permet de chercher et de renvoyer la liste des utilisateur", responseContainer = "List<UtilisateurDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des fournisseurs"),
    })
    List<UtilisateurDto> findAll();

    @DeleteMapping(value = APP_ROOT+"/utilisateur/delete/{idUtilisateur}")
    @ApiOperation(value = "Supprimer un utilisateur", notes = "Cette methode permet de chercher et de supprimer un utilisateur", response = FournisseurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Utilisateur supprimer"),
    })
    void delete(@PathVariable("idUtilisateur") Integer id);
}
