package com.itsol.bankapi.services.Impl;


import com.itsol.bankapi.models.Product;
import com.itsol.bankapi.repository.ProductRepository;
import com.itsol.bankapi.security.services.UserDetailsImpl;
import com.itsol.bankapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;


    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return null;
    }

//    @Override
//    public Product getProduct(Long id) {
//        return productRepository.findOne(id);
//    }

    @Override
    public Product saveOrUpdate(Product product, UserDetailsImpl currentUser) {
        productRepository.save(product);
        return product;
    }

    @Override
    public void delete(long id) {

    }

//    @Override
//    public void delete(long id) {
//        productRepository.delete(id);
//    }


}
