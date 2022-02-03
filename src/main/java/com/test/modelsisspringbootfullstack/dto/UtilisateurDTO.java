package com.test.modelsisspringbootfullstack.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class UtilisateurDTO {
    private Long id;
    private String username;
    private String password;
    private String confirmPassword;
    private boolean actived;
}
