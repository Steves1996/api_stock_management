package com.kamdev.gestionstock.services.impl;

import com.kamdev.gestionstock.dto.MvtStkDto;
import com.kamdev.gestionstock.exception.EntityNotFoundException;
import com.kamdev.gestionstock.exception.ErrorCodes;
import com.kamdev.gestionstock.exception.InvalidEntityException;
import com.kamdev.gestionstock.model.MvtStk;
import com.kamdev.gestionstock.repository.MvtStkRepository;
import com.kamdev.gestionstock.services.MvtStkService;
import com.kamdev.gestionstock.validator.MvtStkValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MvtStkServiceImpl implements MvtStkService {

    private MvtStkRepository mvtStkRepository;

    @Autowired
    public MvtStkServiceImpl(MvtStkRepository mvtStkRepository) {
        this.mvtStkRepository = mvtStkRepository;
    }

    @Override
    public MvtStkDto save(MvtStkDto dto) {
        List<String> errors = MvtStkValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Mouvement de stock pas valid {}", dto);
            throw new InvalidEntityException("Mouvement de stock pas valide", ErrorCodes.MVT_STK_NOT_VALID, errors);
        }

        return MvtStkDto.fromEntity(mvtStkRepository.save(MvtStkDto.toEntity(dto)));
    }

    @Override
    public MvtStkDto findById(Integer id) {
        if (id == null) {
            log.error("MvtStk Id est null");
            return null;
        }
        Optional<MvtStk> mvtStk = mvtStkRepository.findById(id);

        return Optional.of(MvtStkDto.fromEntity(mvtStk.get())).orElseThrow(() ->
                new EntityNotFoundException("Ce Mouvement n'existe pas",
                        ErrorCodes.MVT_STK_NOT_FOUND));
    }

    @Override
    public List<MvtStkDto> findAll() {
        return mvtStkRepository.findAll().stream()
                .map(MvtStkDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("le Mouvement Id est null");
            return;
        }
        mvtStkRepository.deleteById(id);
    }
}
