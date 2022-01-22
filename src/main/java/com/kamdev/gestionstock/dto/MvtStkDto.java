package com.kamdev.gestionstock.dto;

import com.kamdev.gestionstock.model.Article;
import com.kamdev.gestionstock.model.TypeMvtStk;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class MvtStkDto {
    private Instant deteMvt;

    private BigDecimal quantite;
    private ArticleDto article;

    private TypeMvtStk typeMvt;
}
