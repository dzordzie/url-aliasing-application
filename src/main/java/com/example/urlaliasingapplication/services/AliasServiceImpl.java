package com.example.urlaliasingapplication.services;

import com.example.urlaliasingapplication.dtos.AliasGetSecretCodeDTO;
import com.example.urlaliasingapplication.dtos.AliasWithoutSecretCodeDTO;
import com.example.urlaliasingapplication.models.Alias;
import com.example.urlaliasingapplication.repositories.AliasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AliasServiceImpl implements AliasService{
    private final AliasRepository aliasRepository;

    @Autowired
    public AliasServiceImpl(AliasRepository aliasRepository) {
        this.aliasRepository = aliasRepository;
    }


    @Override
    public List<Alias> getAliases() {
        return aliasRepository.findAll();
    }

    @Override
    public void saveAlias(Alias alias) {
        aliasRepository.save(alias);
    }

    @Override
    public Optional<Alias> findByAlias(String alias) {
        return aliasRepository.findAliasByAlias(alias);
    }

    @Override
    public List<AliasGetSecretCodeDTO> getSecretCodeOnly() {
        List<Alias> allAliases = aliasRepository.findAll();
        return allAliases
                .stream()
                .map(alias -> new AliasGetSecretCodeDTO(alias.getSecretCode()))
                .collect(Collectors.toList());
    }

    @Override
    public List<AliasWithoutSecretCodeDTO> aliasesWithoutSecretCode() {
        List<Alias> allAliases = aliasRepository.findAll();
        return allAliases
                .stream()
                .map(alias -> new AliasWithoutSecretCodeDTO(alias.getId(), alias.getLink().getUrl(), alias.getAlias(), alias.getHitCount()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Alias> findAliasById(Long id) {
        return aliasRepository.findById(id);
    }

    @Override
    public void deleteFromDatabase(Long id) {
        aliasRepository.deleteById(id);
    }

}
