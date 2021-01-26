package com.itsol.bankapi.services;


import com.itsol.bankapi.dto.ProductDTO;
import com.itsol.bankapi.models.Product;
import com.itsol.bankapi.security.services.UserDetailsImpl;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProduct(Long id);

    Product saveOrUpdate(Product product, UserDetailsImpl currentUser);

    void delete(long id);

    Product saveOrUpdateProductDTO(ProductDTO productDTO,UserDetailsImpl currentUser);
}
