package com.alas.AlasProject2.service;


import com.alas.AlasProject2.dto.ProductDetails.ProductDetailsRequestDto;
import com.alas.AlasProject2.dto.ProductDetails.ProductDetailsResponseDto;

public interface DetailsService {
    ProductDetailsResponseDto createProductDetails(ProductDetailsRequestDto detailsRequestDto, Integer productId);
    void delete(Integer id);
}
