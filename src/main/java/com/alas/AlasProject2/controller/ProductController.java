package com.alas.AlasProject2.controller;


import com.alas.AlasProject2.dto.Product.ProductRequsetDto;
import com.alas.AlasProject2.model.Product;
import com.alas.AlasProject2.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ProductController {
    private ProductService service;

    @PostMapping("/createProduct")
    public Product createProduct(@RequestBody ProductRequsetDto productRequsetDto) {
        return service.createProduct(productRequsetDto);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
         service.delete(id);
    }

}
