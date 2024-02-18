package com.example.urlaliasingapplication.services;

import com.example.urlaliasingapplication.models.Link;
import com.example.urlaliasingapplication.repositories.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LinkServiceImpl implements LinkService{
    private final LinkRepository linkRepository;

    @Autowired
    public LinkServiceImpl(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public List<Link> getLinks() {
        return linkRepository.findAll();
    }

    @Override
    public void saveLink(Link link) {
        linkRepository.save(link);
    }

    @Override
    public Optional<Link> findByUrl(String url) {
        return linkRepository.findLinkByUrl(url);
    }
}
