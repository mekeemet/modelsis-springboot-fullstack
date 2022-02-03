package com.test.modelsisspringbootfullstack.services;

import com.test.modelsisspringbootfullstack.dto.ProductDTO;
import com.test.modelsisspringbootfullstack.entities.Product;

public interface ProductService {
    Product addproduit(ProductDTO product);
    Product UpdateProduct(ProductDTO product, Long id);
}
