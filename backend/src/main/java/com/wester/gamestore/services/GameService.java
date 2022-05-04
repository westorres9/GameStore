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

import com.wester.gamestore.dto.GameDTO;
import com.wester.gamestore.dto.PlatformDTO;
import com.wester.gamestore.dto.PublisherDTO;
import com.wester.gamestore.entities.Game;
import com.wester.gamestore.entities.Platform;
import com.wester.gamestore.entities.Publisher;
import com.wester.gamestore.repositories.GameRepository;
import com.wester.gamestore.repositories.PlatformRepository;
import com.wester.gamestore.repositories.PublisherRepository;
import com.wester.gamestore.services.exceptions.DatabaseException;
import com.wester.gamestore.services.exceptions.ResourceNotFoundException;

@Service
public class GameService {

    @Autowired
    private GameRepository repository;

    @Autowired
    private PlatformRepository platformRepository;
    
    @Autowired PublisherRepository publisherRepository;

    @Transactional(readOnly = true)
    public Page<GameDTO> findAllPaged(Pageable pageable) {

        Page<Game> page = repository.findAll(pageable);
        return page.map(x -> new GameDTO(x, x.getPlatforms(),x.getPublishers()));
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Optional<Game> obj = repository.findById(id);
        Game entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new GameDTO(entity, entity.getPlatforms(), entity.getPublishers());
    }

    @Transactional
    public GameDTO insert(GameDTO dto) {
        Game entity = new Game();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new GameDTO(entity, entity.getPlatforms(), entity.getPublishers());
    }

    @Transactional
    public GameDTO update(Long id, GameDTO dto) {
        try {
            Game entity = repository.getOne(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new GameDTO(entity);
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

    private void copyDtoToEntity(GameDTO dto, Game entity) {
    	
        entity.setName(dto.getName());
        entity.setReleaseDate(dto.getReleaseDate());
        entity.getPublishers().clear();
        for (PublisherDTO pubDto : dto.getPublishers()) {
        	Publisher publisher = publisherRepository.getOne(pubDto.getId());
            entity.getPublishers().add(publisher);
        }
        entity.getPlatforms().clear();
        for (PlatformDTO platDto : dto.getPlatforms()) {
            Platform platform = platformRepository.getOne(platDto.getId());
            entity.getPlatforms().add(platform);
        }
    }
}