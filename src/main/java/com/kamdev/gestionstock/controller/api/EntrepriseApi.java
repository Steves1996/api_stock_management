package com.kamdev.gestionstock.controller.api;

import com.kamdev.gestionstock.dto.ArticleDto;
import com.kamdev.gestionstock.dto.ClientDto;
import com.kamdev.gestionstock.dto.EntrepriseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kamdev.gestionstock.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/entreprise")
public interface EntrepriseApi {

    @PostMapping(value = APP_ROOT + "/entreprise/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une entreprise", notes = "Cette methode permet d'enregistrer ou modifier une entreprise", response = EntrepriseDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet entreprise cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet entreprise n'est pas valide")
    })
    EntrepriseDto save(@RequestBody EntrepriseDto dto);

    @GetMapping(value = APP_ROOT+"/entreprise/{idEntreprise}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche une entreprise par Id", notes = "Cette methode permet de chercher une entreprise par son ID", response = EntrepriseDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'entrerpise a été trouve dans la BD"),
            @ApiResponse(code = 404, message = "Aucune entreprise n'a été trouve dans la BD")
    })
    EntrepriseDto findById(@PathVariable("idEntreprise") Integer id);

    @GetMapping(value = APP_ROOT+"/entreprise/{name}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche une entreprise pas son Nom", notes = "Cette methode permet de chercher une entreprise par son nom", response = EntrepriseDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'entreprise a été trouve dans la BD"),
            @ApiResponse(code = 404, message = "Aucune entreprise n'a été trouve dans la BD")
    })
    EntrepriseDto findEntrepriseByNom(@PathVariable("name") String name);

    @GetMapping(value = APP_ROOT+"/entreprise/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoie la liste des entreprises", notes = "Cette methode permet de chercher et de renvoyer la liste des entreprises", responseContainer = "List<EntrepriseDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des entreprises"),
    })
    List<EntrepriseDto> findAll();

    @DeleteMapping(value = APP_ROOT+"/entreprise/delete/{idEntreprise}")
    @ApiOperation(value = "Supprimer un client", notes = "Cette methode permet de chercher et de supprimer un client", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Client supprimer"),
    })
    void delete(@PathVariable("idEntreprise") Integer id);
}
