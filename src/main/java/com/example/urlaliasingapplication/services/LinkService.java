package com.example.urlaliasingapplication.services;

import com.example.urlaliasingapplication.models.Link;

import java.util.List;
import java.util.Optional;

public interface LinkService {
    List<Link> getLinks();
    void saveLink(Link link);
    Optional<Link> findByUrl(String url);
}
