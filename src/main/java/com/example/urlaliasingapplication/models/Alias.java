package com.example.urlaliasingapplication.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Random;

@Entity
public class Alias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String alias;
    private int hitCount;
    @NotNull
    private String secretCode;

    @ManyToOne
    @JoinColumn(name = "link_id")
    private Link link;


    public Alias(String alias) {
        this.alias = alias;
        this.hitCount = 0;
        this.secretCode = String.format("%04d", new Random().nextInt(9999));
    }

    public Alias() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getHitCount() {
        return hitCount;
    }

    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }

    public String getSecretCode() {
        return secretCode;
    }

    public void setSecretCode(String secretCode) {
        this.secretCode = secretCode;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }
}
