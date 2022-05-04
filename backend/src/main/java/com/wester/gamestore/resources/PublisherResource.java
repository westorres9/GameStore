package com.wester.gamestore.resources;

import com.wester.gamestore.dto.PublisherDTO;
import com.wester.gamestore.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
