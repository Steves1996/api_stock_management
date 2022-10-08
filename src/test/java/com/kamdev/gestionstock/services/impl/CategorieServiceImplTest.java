package com.kamdev.gestionstock.services.impl;

import com.kamdev.gestionstock.dto.CategorieDto;
import com.kamdev.gestionstock.exception.EntityNotFoundException;
import com.kamdev.gestionstock.exception.ErrorCodes;
import com.kamdev.gestionstock.exception.InvalidEntityException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategorieServiceImplTest {

    @Autowired
    private CategorieServiceImpl service;

    @Test
    public void shouldSaveCategoryWithSuccess(){
        CategorieDto expectedCategory = CategorieDto.builder()
                .code("cat test")
                .designation("designation test")
                .idEntreprise(1)
                .build();
        CategorieDto savedCategory = service.save(expectedCategory);
        Assertions.assertNotNull(savedCategory);
        Assertions.assertNotNull(savedCategory.getId());
        Assertions.assertEquals(expectedCategory.getCode(), savedCategory.getCode());
        Assertions.assertEquals(expectedCategory.getDesignation(), savedCategory.getDesignation());
        Assertions.assertEquals(expectedCategory.getIdEntreprise(), savedCategory.getIdEntreprise());
    }

    @Test
    public void shouldUpdateCategoryWithSuccess(){
        CategorieDto expectedCategory = CategorieDto.builder()
                .code("cat test")
                .designation("designation test")
                .idEntreprise(1)
                .build();
        CategorieDto savedCategory = service.save(expectedCategory);

        CategorieDto categorieDtoToUpdate = savedCategory;
        categorieDtoToUpdate.setCode("cat update");
        savedCategory = service.save(categorieDtoToUpdate);

        Assertions.assertNotNull(categorieDtoToUpdate);
        Assertions.assertNotNull(categorieDtoToUpdate.getId());
        Assertions.assertEquals(categorieDtoToUpdate.getCode(), savedCategory.getCode());
        Assertions.assertEquals(categorieDtoToUpdate.getDesignation(), savedCategory.getDesignation());
        Assertions.assertEquals(categorieDtoToUpdate.getIdEntreprise(), savedCategory.getIdEntreprise());
    }

    @Test
    public void shouldThrowInvalidEntityException(){
        CategorieDto expectedCategory = CategorieDto.builder().build();
        InvalidEntityException exceptedException = assertThrows(InvalidEntityException.class, ()->service.save(expectedCategory));
        assertEquals(ErrorCodes.CATEGORIE_NOT_VALID, exceptedException.getErrorCodes());
//        assertEquals(1, exceptedException.getErrors().size());
        //assertEquals("Entrez les informations de la catégorie", exceptedException.getErrors().get(0));
    }

}