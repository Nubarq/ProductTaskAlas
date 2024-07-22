package com.alas.AlasProject2.service;


import com.alas.AlasProject2.dto.Product.ProductRequsetDto;
import com.alas.AlasProject2.model.Product;

public interface ProductService {
    Product createProduct(ProductRequsetDto productRequsetDto);
    void delete(Integer id);
}
