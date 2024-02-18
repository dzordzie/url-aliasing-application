package com.example.urlaliasingapplication.repositories;

import com.example.urlaliasingapplication.models.Alias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AliasRepository extends JpaRepository<Alias, Long> {

    Optional<Alias> findAliasByAlias(String alias);

}
