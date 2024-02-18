package com.example.urlaliasingapplication.repositories;

import com.example.urlaliasingapplication.models.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long> {
    Optional<Link> findLinkByUrl(String url);
}
