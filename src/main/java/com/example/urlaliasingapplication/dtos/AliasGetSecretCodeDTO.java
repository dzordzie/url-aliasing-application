package com.example.urlaliasingapplication.dtos;

public class AliasGetSecretCodeDTO {
    private String secretCode;

    public AliasGetSecretCodeDTO() {
    }

    public AliasGetSecretCodeDTO(String secretCode) {
        this.secretCode = secretCode;
    }

    public String getSecretCode() {
        return secretCode;
    }

    public void setSecretCode(String secretCode) {
        this.secretCode = secretCode;
    }
}
