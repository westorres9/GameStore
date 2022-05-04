package com.wester.gamestore.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wester.gamestore.dto.PlatformDTO;
import com.wester.gamestore.entities.Platform;
import com.wester.gamestore.repositories.PlatformRepository;
import com.wester.gamestore.services.exceptions.DatabaseException;
import com.wester.gamestore.services.exceptions.ResourceNotFoundException;

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
        Platform entity = obj.orElseThrow(() -> new ResourceNotFoundException("entity not found"));
        return new PlatformDTO(entity);
    }
    
    @Transactional
    public PlatformDTO insert(PlatformDTO dto) {
    	Platform entity = new Platform();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new PlatformDTO(entity);
    }

    @Transactional
    public PlatformDTO update(Long id, PlatformDTO dto) {
        try {
        	Platform entity = repository.getOne(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new PlatformDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }

    private void copyDtoToEntity(PlatformDTO dto, Platform entity) {
    	
        entity.setName(dto.getName());
    }
}
