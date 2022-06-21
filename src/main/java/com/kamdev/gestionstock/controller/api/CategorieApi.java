package com.kamdev.gestionstock.controller.api;


import com.kamdev.gestionstock.dto.ArticleDto;
import com.kamdev.gestionstock.dto.CategorieDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kamdev.gestionstock.utils.Constants.APP_ROOT;
@Api(APP_ROOT + "/categories")
public interface CategorieApi {

    @PostMapping(value = APP_ROOT + "/categories/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une categorie", notes = "Cette methode permet d'enregistrer ou modifier une categorie", response = CategorieDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet categorie cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet categorie n'est pas valide")
    })
    CategorieDto save(@RequestBody CategorieDto dto);

    @GetMapping(value = APP_ROOT+"/categories/{idCategory}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche une categorie par Id", notes = "Cette methode permet de chercher une categorie par son ID", response = CategorieDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La categorie a été trouve dans la BD"),
            @ApiResponse(code = 404, message = "Aucun categorie n'a été trouve dans la BD")
    })
    CategorieDto findById(@PathVariable("idCategory") Integer id);

    @GetMapping(value = APP_ROOT+"/categories/code/{codeCategory}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche une categorie pas son Code", notes = "Cette methode permet de chercher une categorie par son code", response = CategorieDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La categorie a été trouve dans la BD"),
            @ApiResponse(code = 404, message = "Aucune categori n'a été trouve dans la BD")
    })
    CategorieDto findByCodeCategory(@PathVariable("codeCategory") String codeCategory);

    @GetMapping(value = APP_ROOT+"/categories/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoie la liste des categories", notes = "Cette methode permet de chercher et de renvoyer la liste des categories", responseContainer = "List<CategorieDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des categories"),
    })
    List<CategorieDto> findAll();

    @DeleteMapping(value = APP_ROOT+"/categories/delete/{idCategory}")
    @ApiOperation(value = "Supprimer une categorie", notes = "Cette methode permet de chercher et de supprimer une categorie", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "categorie supprimer"),
    })
    void delete(@PathVariable("idCategory") Integer id);
}
