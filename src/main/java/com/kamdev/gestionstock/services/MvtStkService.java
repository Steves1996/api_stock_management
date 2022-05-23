package com.kamdev.gestionstock.services;

import com.kamdev.gestionstock.dto.MvtStkDto;

import java.util.List;

public interface MvtStkService {

    MvtStkDto save(MvtStkDto dto);

    MvtStkDto findById(Integer id);

    List<MvtStkDto> findAll();

    void delete(Integer id);
}
