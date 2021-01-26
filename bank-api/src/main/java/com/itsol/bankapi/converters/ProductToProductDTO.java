package com.itsol.bankapi.converters;

import com.itsol.bankapi.dto.ProductDTO;
import com.itsol.bankapi.models.Product;
import org.springframework.core.convert.converter.Converter;

public class ProductToProductDTO implements Converter<Product, ProductDTO> {
    @Override
    public ProductDTO convert(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setImageUrl(product.getImageUrl());
        return productDTO;
    }
}
