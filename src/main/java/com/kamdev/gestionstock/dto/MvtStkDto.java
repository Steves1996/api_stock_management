package com.kamdev.gestionstock.dto;

import com.kamdev.gestionstock.model.Article;
import com.kamdev.gestionstock.model.MvtStk;
import com.kamdev.gestionstock.model.TypeMvtStk;
import com.kamdev.gestionstock.model.Ventes;
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
    private Integer id;
    private Instant dateMvt;

    private BigDecimal quantite;
    private ArticleDto article;

    private TypeMvtStk typeMvt;

    public static MvtStkDto fromEntity(MvtStk mvtStk){
        if(mvtStk == null){
            return  null;
        }
        return MvtStkDto.builder()
                .id(mvtStk.getId())
                .dateMvt(mvtStk.getDeteMvt())
                .quantite(mvtStk.getQuantite())
                .build();
    }

    public static MvtStk toEntity(MvtStkDto dto){
        if(dto == null){
            return  null;
        }
        MvtStk mvtStk = new MvtStk();
        mvtStk.setId(dto.getId());
        mvtStk.setDeteMvt(dto.getDateMvt());
        mvtStk.setQuantite(dto.getQuantite());

        return mvtStk;
    }
}
