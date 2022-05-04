package com.wester.gamestore.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.wester.gamestore.dto.PublisherDTO;
import com.wester.gamestore.services.PublisherService;

@RestController
@RequestMapping(value = "/publishers")
public class PublisherResource {

    @Autowired
    private PublisherService service;

    @GetMapping
    public ResponseEntity<Page<PublisherDTO>> findAll(Pageable pageable) {
        Page<PublisherDTO> page = service.findAll(pageable);
        return ResponseEntity.ok().body(page);
    }

    @GetMapping(value = "/{id}")
public ResponseEntity<PublisherDTO> findById(@PathVariable Long id) {
        PublisherDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }
    
    @PostMapping
    public ResponseEntity<PublisherDTO> insert(@Valid @RequestBody PublisherDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PublisherDTO> update(@PathVariable Long id, @Valid @RequestBody PublisherDTO dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
