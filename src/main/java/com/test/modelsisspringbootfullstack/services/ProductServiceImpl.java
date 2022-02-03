package com.test.modelsisspringbootfullstack.services;

import com.test.modelsisspringbootfullstack.dao.ProductRepository;
import com.test.modelsisspringbootfullstack.dao.TypeProductRepository;
import com.test.modelsisspringbootfullstack.dto.ProductDTO;
import com.test.modelsisspringbootfullstack.entities.Product;
import com.test.modelsisspringbootfullstack.entities.TypeProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
@Service
@Transactional
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private TypeProductRepository typeProductRepository;
    @Override
    public Product addproduit(ProductDTO product) {
        TypeProduct typeProduct=typeProductRepository.findById(product.getTypeProductid()).get();
        Product pro=new Product();
        pro.setName(product.getName());
        pro.setCreatedDate(new Date());
        pro.setTypeProduct(typeProduct);
        return productRepository.saveAndFlush(pro);
    }

    @Override
    public Product UpdateProduct(ProductDTO product, Long id) {
        TypeProduct typeProduct=typeProductRepository.findById(product.getTypeProductid()).get();
        Product prod=productRepository.findById(id).get();
        prod.setName(product.getName());
        prod.setCreatedDate(new Date());
        prod.setTypeProduct(typeProduct);
        return productRepository.saveAndFlush(prod);
    }
}
