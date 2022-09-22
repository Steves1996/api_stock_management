package com.kamdev.gestionstock.controller.api;

import com.kamdev.gestionstock.dto.ArticleDto;
import com.kamdev.gestionstock.dto.CategorieDto;
import com.kamdev.gestionstock.dto.ClientDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kamdev.gestionstock.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/client")
public interface ClientApi {

    @PostMapping(value = APP_ROOT + "/client/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un client", notes = "Cette methode permet d'enregistrer ou modifier un client", response = ClientDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet client cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet client n'est pas valide")
    })
    ClientDto save(@RequestBody ClientDto dto);

    @GetMapping(value = APP_ROOT+"/client/{idClient}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche un client par Id", notes = "Cette methode permet de chercher une client par son ID", response = ClientDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le client a été trouve dans la BD"),
            @ApiResponse(code = 404, message = "Aucun client n'a été trouve dans la BD")
    })
    ClientDto findById(@PathVariable("idClient") Integer id);

    @GetMapping(value = APP_ROOT+"/client/{name}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche un client pas son Nom", notes = "Cette methode permet de chercher un client par son nom", response = ClientDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le client a été trouve dans la BD"),
            @ApiResponse(code = 404, message = "Aucun client n'a été trouve dans la BD")
    })
    ClientDto findClientByName(@PathVariable("name") String name);

    @GetMapping(value = APP_ROOT+"/client/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoie la liste des clients", notes = "Cette methode permet de chercher et de renvoyer la liste des clients", responseContainer = "List<ClientDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des clients"),
    })
    List<ClientDto> findAll();

    @DeleteMapping(value = APP_ROOT+"/client/delete/{idClient}")
    @ApiOperation(value = "Supprimer un client", notes = "Cette methode permet de chercher et de supprimer un client", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Client supprimer"),
    })
    void delete(@PathVariable("idClient") Integer id);
}
