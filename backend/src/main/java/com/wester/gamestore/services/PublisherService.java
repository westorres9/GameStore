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

import com.wester.gamestore.dto.PublisherDTO;
import com.wester.gamestore.entities.Publisher;
import com.wester.gamestore.repositories.PublisherRepository;
import com.wester.gamestore.services.exceptions.DatabaseException;
import com.wester.gamestore.services.exceptions.ResourceNotFoundException;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository repository;

    @Transactional(readOnly = true)
    public Page<PublisherDTO> findAll(Pageable pageable){
        Page<Publisher> page = repository.findAll(pageable);
        return page.map(x -> new PublisherDTO(x));
    }

    @Transactional(readOnly = true)
    public PublisherDTO findById(Long id) {
        Optional<Publisher> obj = repository.findById(id);
        Publisher entity = obj.orElseThrow(() -> new ResourceNotFoundException("entity not found"));
        return new PublisherDTO(entity);
    }
    
    @Transactional
    public PublisherDTO insert(PublisherDTO dto) {
    	Publisher entity = new Publisher();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new PublisherDTO(entity);
    }

    @Transactional
    public PublisherDTO update(Long id, PublisherDTO dto) {
        try {
        	Publisher entity = repository.getOne(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new PublisherDTO(entity);
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

    private void copyDtoToEntity(PublisherDTO dto, Publisher entity) {
    	
        entity.setName(dto.getName());
    }
}

