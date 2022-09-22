package com.kamdev.gestionstock.controller.api;

import com.kamdev.gestionstock.dto.VentesDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kamdev.gestionstock.utils.Constants.APP_ROOT;

@Api(APP_ROOT+"/ventes")
public interface VenteApi {

    @PostMapping(APP_ROOT+"/ventes/create")
    VentesDto save(@RequestBody VentesDto dto);

    @GetMapping(APP_ROOT+"/ventes/{idVente}")
    VentesDto findById(@PathVariable("idVente") Integer id);

    @GetMapping(APP_ROOT+"/ventes/{codeVente}")
    VentesDto findByCode(@PathVariable("codeVente") String code);

    @GetMapping(APP_ROOT+"/ventes/all")
    List<VentesDto> findAll();

    @DeleteMapping(APP_ROOT+"/ventes/delete/{idVente}")
    void delete(@PathVariable("idVente") Integer id);
}
