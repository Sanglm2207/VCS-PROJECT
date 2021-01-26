package com.itsol.bankapi.converters;

import com.itsol.bankapi.dto.ProductDTO;
import com.itsol.bankapi.models.Product;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

@Component
public class ProductDTOToProduct implements Converter<ProductDTO, Product> {
    @Override
    public Product convert(ProductDTO productDTO) {
        Product product = new Product();
        if (productDTO.getId() != null  && !StringUtils.isEmpty(productDTO.getId())) {
            product.setId(new Long(productDTO.getId()));
        }
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setImageUrl(productDTO.getImageUrl());
        return product;
    }
}
