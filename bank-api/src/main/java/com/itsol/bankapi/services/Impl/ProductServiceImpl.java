package com.itsol.bankapi.services.Impl;

import com.itsol.bankapi.converters.ProductDTOToProduct;
import com.itsol.bankapi.dto.ProductDTO;
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
    private ProductDTOToProduct productDTOToProduct;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductDTOToProduct productDTOToProduct) {
        this.productRepository = productRepository;
        this.productDTOToProduct = productDTOToProduct;
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

    @Override
    public Product saveOrUpdateProductDTO(ProductDTO productDTO,UserDetailsImpl currentUser) {
        Product savedProduct = saveOrUpdate(productDTOToProduct.convert(productDTO), currentUser);

        System.out.println("Saved Product Id: " + savedProduct.getId());
        return savedProduct;
    }
}
