package com.test.modelsisspringbootfullstack.dao;

import com.test.modelsisspringbootfullstack.entities.Product;
import com.test.modelsisspringbootfullstack.entities.TypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

public interface ProductRepository extends JpaRepository<Product,Long> {
    public Product findByName(String nameproduct);
    public TypeProduct findByTypeProduct(Long id);

}
