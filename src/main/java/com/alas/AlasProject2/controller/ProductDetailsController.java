package com.alas.AlasProject2.controller;


import com.alas.AlasProject2.dto.ProductDetails.ProductDetailsRequestDto;
import com.alas.AlasProject2.dto.ProductDetails.ProductDetailsResponseDto;
import com.alas.AlasProject2.service.DetailsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ProductDetailsController {
    private DetailsService service;

    @PostMapping("/createProductDetails")
    public ProductDetailsResponseDto createProductDetails(@RequestBody ProductDetailsRequestDto detailsRequestDto
            , @RequestParam Integer productId) {
        return service.createProductDetails(detailsRequestDto,productId);
    }
    }
