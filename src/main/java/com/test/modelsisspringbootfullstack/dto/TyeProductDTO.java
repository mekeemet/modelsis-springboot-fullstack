package com.test.modelsisspringbootfullstack.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.test.modelsisspringbootfullstack.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TyeProductDTO {
    private Long id;
    private String name;
    private Collection<Product> products;
}
