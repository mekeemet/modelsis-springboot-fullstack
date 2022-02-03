package com.test.modelsisspringbootfullstack.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SResponse {
    private Object data;
    private String description;
    private Integer statut;
}
