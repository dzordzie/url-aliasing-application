package com.example.urlaliasingapplication.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;

    @OneToMany(mappedBy = "link", cascade = CascadeType.ALL)
    private List<Alias> aliases;

    public Link(String url) {
        this.url = url;
    }

    public Link() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Alias> getAliases() {
        return aliases;
    }

    public void setAliases(List<Alias> aliases) {
        this.aliases = aliases;
    }
}
