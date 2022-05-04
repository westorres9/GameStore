package com.wester.gamestore.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wester.gamestore.dto.PublisherDTO;
import com.wester.gamestore.entities.Publisher;
import com.wester.gamestore.repositories.PublisherRepository;

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
        Publisher entity = obj.orElseThrow(() -> new EntityNotFoundException("entity not found"));
        return new PublisherDTO(entity);
    }
}
