package com.wester.gamestore.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wester.gamestore.dto.PlatformDTO;
import com.wester.gamestore.services.PlatformService;

@RestController
@RequestMapping(value = "/platforms")
public class PlatformResource {

    @Autowired
    private PlatformService service;

    @GetMapping
    public ResponseEntity<Page<PlatformDTO>> findAll(Pageable pageable) {
        Page<PlatformDTO> page = service.findAll(pageable);
        return ResponseEntity.ok().body(page);
    }

    @GetMapping(value = "/{id}")
public ResponseEntity<PlatformDTO> findById(@PathVariable Long id) {
        PlatformDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

}