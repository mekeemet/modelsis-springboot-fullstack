package com.test.modelsisspringbootfullstack;

import com.test.modelsisspringbootfullstack.dao.ProductRepository;
import com.test.modelsisspringbootfullstack.dao.TypeProductRepository;
import com.test.modelsisspringbootfullstack.entities.Product;
import com.test.modelsisspringbootfullstack.entities.TypeProduct;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Date;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TypeProductTest {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    TypeProductRepository typeProductRepository;

    @Test
    void addTypeProduit() {
        ArrayList<Product> listProduct=new ArrayList<Product>();
        TypeProduct tProduct=new TypeProduct(1L,"type 1",listProduct);
        typeProductRepository.save(tProduct);
        Assertions.assertThat(tProduct.getId()).isGreaterThan(0);

    }
}
