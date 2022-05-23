package com.kamdev.gestionstock.dto;

import com.kamdev.gestionstock.model.Article;
import com.kamdev.gestionstock.model.Categorie;
import lombok.Builder;
import lombok.Data;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;


@Data
@Builder
public class ArticleDto {
    private Integer id;
    private String codeArticle;
    private String designation;
    private BigDecimal prixUnitaireHt;
    private BigDecimal tauxTva;
    private BigDecimal prixUnitaireTtc;
    private String photo;
    private CategorieDto category;
    private  int idEntreprise;

    //TODO Add mapping of idEntreprise in all DTO


    public static ArticleDto fromEntity(Article article) {
        if(article == null){
            return null;
            //TODO throw an exception
        }
        return ArticleDto.builder()
                .id(article.getId())
                .codeArticle(article.getCodeArticle())
                .designation(article.getDesignation())
                .photo(article.getPhoto())
                .prixUnitaireHt(article.getPrixUnitaireHt())
                .prixUnitaireTtc(article.getPrixUnitaireTtc())
                .category(CategorieDto.fromEntity(article.getCategory()))
                .tauxTva(article.getTauxTva())
                .idEntreprise(article.getIdEntreprise())
                .category(CategorieDto.fromEntity(article.getCategory()))
                .build();
    }

    public static Article toEntity(ArticleDto articleDto) {
        if(articleDto == null){
            return null;
            //TODO throw an exception
        }
        Article article = new Article();
        article.setId(articleDto.getId());
        article.setCodeArticle(articleDto.getCodeArticle());
        article.setPhoto(articleDto.getPhoto());
        article.setDesignation(articleDto.getDesignation());
        article.setPrixUnitaireHt(articleDto.getPrixUnitaireHt());
        article.setPrixUnitaireTtc(articleDto.getPrixUnitaireTtc());
        article.setTauxTva(articleDto.getTauxTva());
        article.setIdEntreprise(articleDto.getIdEntreprise());
        article.setCategory(CategorieDto.toEntity(articleDto.getCategory()));
        return article;
    }

}
