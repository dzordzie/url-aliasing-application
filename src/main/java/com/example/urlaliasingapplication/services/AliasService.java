package com.example.urlaliasingapplication.services;

import com.example.urlaliasingapplication.dtos.AliasGetSecretCodeDTO;
import com.example.urlaliasingapplication.dtos.AliasWithoutSecretCodeDTO;
import com.example.urlaliasingapplication.models.Alias;

import java.util.List;
import java.util.Optional;

public interface AliasService {
    List<Alias> getAliases();

    void saveAlias(Alias alias);

    Optional<Alias> findByAlias(String alias);

    List<AliasGetSecretCodeDTO> getSecretCodeOnly();

    List<AliasWithoutSecretCodeDTO> aliasesWithoutSecretCode();

    Optional<Alias> findAliasById(Long id);

    void deleteFromDatabase(Long id);
}
