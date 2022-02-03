package com.test.modelsisspringbootfullstack.web;

import com.test.modelsisspringbootfullstack.dao.ProductRepository;
import com.test.modelsisspringbootfullstack.dao.TypeProductRepository;
import com.test.modelsisspringbootfullstack.dto.ProductDTO;
import com.test.modelsisspringbootfullstack.entities.Product;
import com.test.modelsisspringbootfullstack.entities.SResponse;
import com.test.modelsisspringbootfullstack.entities.TypeProduct;
import com.test.modelsisspringbootfullstack.services.ProductService;
import com.test.modelsisspringbootfullstack.services.TypeProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private TypeProductRepository typeProductRepository;
    @Autowired
    private ProductService productService;
    @GetMapping("/api/products")
    List<Product> allTypeProduct() {
        logger.info("inside ProductRepository.allTypeProduct() method");
        return productRepository.findAll();
    }

    @PostMapping("api/saveproduct")
    public SResponse addProduct(@RequestBody ProductDTO product){
        SResponse response=new SResponse();
        if(productRepository.findByName(product.getName())==null){
            try {
                logger.info("Adding Product " + product);
                productService.addproduit(product);
                response.setStatut(200);
                response.setDescription("Ajout réussie");
            }catch (Exception ex){
                response.setStatut(500);
                response.setDescription("Vérifier les informations saisies!");
            }
        }
        else{
            response.setStatut(500);
            response.setDescription("Le Produit existe deja");
        }
        return response;
    }


    @PutMapping(value = "api/updateproduct/{id}")
    public SResponse updateProduct(@PathVariable Long id, @RequestBody ProductDTO product){
        SResponse response =new SResponse();
        Product prod=productRepository.findByName(product.getName());
        if(prod==null || prod.getTypeProduct().getId()!= product.getTypeProductid()){
            try {
                logger.info("Updating TypeProduct " + product);
                productService.UpdateProduct(product,id);
                response.setStatut(200);
                response.setDescription("Modification reussi");

            }catch (Exception ex){
                response.setStatut(500);
                response.setDescription("Vérifier les informations saisies!");
            }
        }else {
            response.setStatut(500);
            response.setDescription("Le Produit existe deja");
        }
        return response;
    }


}
