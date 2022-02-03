package com.test.modelsisspringbootfullstack.services;

import com.test.modelsisspringbootfullstack.entities.Product;
import com.test.modelsisspringbootfullstack.entities.TypeProduct;

import java.util.List;

public interface TypeProductService {
    TypeProduct addTypeproduit(TypeProduct typeProduct);
    TypeProduct UpdateTypeProduct(TypeProduct typeProduct, Long id);
}
