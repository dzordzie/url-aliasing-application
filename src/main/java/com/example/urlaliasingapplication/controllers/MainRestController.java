package com.example.urlaliasingapplication.controllers;

import com.example.urlaliasingapplication.dtos.AliasGetSecretCodeDTO;
import com.example.urlaliasingapplication.models.Alias;
import com.example.urlaliasingapplication.services.AliasService;
import com.example.urlaliasingapplication.services.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MainRestController {

    private final LinkService linkService;
    private final AliasService aliasService;

    @Autowired
    public MainRestController(LinkService linkService, AliasService aliasService) {
        this.linkService = linkService;
        this.aliasService = aliasService;
    }

    @GetMapping("/aliases")
    public ResponseEntity getAllAliases() {
        return ResponseEntity.status(200).body(aliasService.aliasesWithoutSecretCode());
    }

    @DeleteMapping("/aliases/{id}")
    public ResponseEntity getSecretCode(@PathVariable Long id, @RequestBody AliasGetSecretCodeDTO alias) {
        Optional<Alias> foundAlias = aliasService.findAliasById(id);
        if (!foundAlias.isPresent()) {
            return ResponseEntity.status(404).build();
        } else if (foundAlias.isPresent() && !foundAlias.get().getSecretCode().equals(alias.getSecretCode())) {
            return ResponseEntity.status(403).build();
        } else {
            aliasService.deleteFromDatabase(id);
            return ResponseEntity.status(204).build();
        }
    }

    @GetMapping("/error")
    public ResponseEntity error(){
        return ResponseEntity.notFound().build();
    }
}
