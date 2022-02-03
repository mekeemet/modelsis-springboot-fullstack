package com.test.modelsisspringbootfullstack.dao;

import com.test.modelsisspringbootfullstack.entities.TypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TypeProductRepository extends JpaRepository<TypeProduct,Long> {
    public TypeProduct findByName(String typename);

}
