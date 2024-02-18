package com.example.urlaliasingapplication.dtos;

public class AliasWithoutSecretCodeDTO {
    private Long id;
    private String url;
    private String alias;
    private int hitCount;


    public AliasWithoutSecretCodeDTO() {
    }

    public AliasWithoutSecretCodeDTO(Long id, String url, String alias, int hitCount) {
        this.id = id;
        this.url = url;
        this.alias = alias;
        this.hitCount = hitCount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
}
