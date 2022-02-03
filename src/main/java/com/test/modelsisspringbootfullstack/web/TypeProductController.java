package com.test.modelsisspringbootfullstack.web;

import com.test.modelsisspringbootfullstack.dao.TypeProductRepository;
import com.test.modelsisspringbootfullstack.entities.Product;
import com.test.modelsisspringbootfullstack.entities.SResponse;
import com.test.modelsisspringbootfullstack.entities.TypeProduct;
import com.test.modelsisspringbootfullstack.services.TypeProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class TypeProductController {
    private static final Logger logger = LoggerFactory.getLogger(TypeProductController.class);

    @Autowired
    private TypeProductRepository typeProductRepository;
    @Autowired
    private TypeProductService typeProductService;

    @GetMapping("api/productTypes")
    List<TypeProduct> allTypeProduct() {
        logger.info("inside TypeProductController.allTypeProduct() method");
        return typeProductRepository.findAll();
    }

    @PostMapping("api/saveproductType")
    public SResponse newTypeProduct(@RequestBody TypeProduct typeProduct){
        SResponse response=new SResponse();
        if(typeProductRepository.findByName(typeProduct.getName())==null){
            try {
                logger.info("Adding TypeProduct " + typeProduct);
                typeProductService.addTypeproduit(typeProduct);
                response.setStatut(200);
                response.setDescription("Ajout réussie");
            }catch (Exception ex){
                response.setStatut(500);
                response.setDescription("Vérifier les informations saisies!");
            }
        }
        else{
            response.setStatut(500);
            response.setDescription("Le Type Produit existe deja");
        }
        return response;
    }

}
