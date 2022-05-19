package com.kamdev.gestionstock.controller.api;


import com.kamdev.gestionstock.dto.ArticleDto;
import com.kamdev.gestionstock.dto.CategorieDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kamdev.gestionstock.utils.Constants.APP_ROOT;
public interface CategorieApi {

    @PostMapping(value = APP_ROOT + "/categories/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CategorieDto save(@RequestBody CategorieDto dto);

    @GetMapping(value = APP_ROOT+"/categories/{idCategory}",produces = MediaType.APPLICATION_JSON_VALUE)
    CategorieDto fidById(@PathVariable("idCategory") Integer id);

    @GetMapping(value = APP_ROOT+"/categories/{codeCategory}",produces = MediaType.APPLICATION_JSON_VALUE)
    CategorieDto findByCodeCategory(@PathVariable("codeCategory") String codeCategory);

    @GetMapping(value = APP_ROOT+"/categories/all",produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategorieDto> findAll();

    @DeleteMapping(value = APP_ROOT+"/categories/delete/{idCategory}")
    void delete(@PathVariable("idCategory") Integer id);
}
