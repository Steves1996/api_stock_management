package com.kamdev.gestionstock.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "categorie")
public class Categorie  extends  AbstractEntity{

    @Column(name = "code")
    private  String code;
    @Column(name = "designation")
    private  String designation;
    @OneToMany(mappedBy = "category")
    private List<Article> articleList;
    @Column(name = "idEntreprise")
    private int idEntreprise;
}
