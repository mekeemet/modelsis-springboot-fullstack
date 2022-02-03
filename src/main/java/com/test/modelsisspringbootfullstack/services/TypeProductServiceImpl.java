package com.test.modelsisspringbootfullstack.services;

import com.test.modelsisspringbootfullstack.dao.TypeProductRepository;
import com.test.modelsisspringbootfullstack.entities.TypeProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TypeProductServiceImpl implements TypeProductService{
    @Autowired
    private TypeProductRepository typeProductRepository;
    @Override
    public TypeProduct addTypeproduit(TypeProduct typeProduct) {

        return typeProductRepository.saveAndFlush(typeProduct);
    }

    @Override
    public TypeProduct UpdateTypeProduct(TypeProduct typeProduct, Long id) {
        TypeProduct typePro =new TypeProduct();
        typePro.setName(typePro.getName());
        typePro.setId(id);
        return typeProductRepository.saveAndFlush(typePro);
    }
}
