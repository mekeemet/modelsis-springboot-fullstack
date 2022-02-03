package com.test.modelsisspringbootfullstack.dto;

import com.test.modelsisspringbootfullstack.entities.TypeProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductDTO {
    private Long id;
    private String name;
    private Long typeProductid;
}
