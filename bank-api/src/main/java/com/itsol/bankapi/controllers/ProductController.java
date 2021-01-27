package com.itsol.bankapi.controllers;



import com.itsol.bankapi.models.Product;
import com.itsol.bankapi.security.CurrentUser;
import com.itsol.bankapi.security.services.UserDetailsImpl;
import com.itsol.bankapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/getAllProducts")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @ResponseBody
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping("/createProduct")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public Product createProduct(@Valid @RequestBody Product product, @CurrentUser UserDetailsImpl currentUser) {
        return productService.saveOrUpdate(product, currentUser);
    }
}
