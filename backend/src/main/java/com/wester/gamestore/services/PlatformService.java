package com.wester.gamestore.services;

import com.wester.gamestore.dto.PlatformDTO;
import com.wester.gamestore.entities.Platform;
import com.wester.gamestore.repositories.PlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class PlatformService {

    @Autowired
    private PlatformRepository repository;

    @Transactional(readOnly = true)
    public Page<PlatformDTO> findAll(Pageable pageable){
        Page<Platform> page = repository.findAll(pageable);
        return page.map(x -> new PlatformDTO(x));
    }

    @Transactional(readOnly = true)
    public PlatformDTO findById(Long id) {
        Optional<Platform> obj = repository.findById(id);
        Platform entity = obj.orElseThrow(() -> new EntityNotFoundException("entity not found"));
        return new PlatformDTO(entity);
    }
}
