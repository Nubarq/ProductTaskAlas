package com.alas.AlasProject2.dto.Product;

import lombok.Data;

@Data
public class ProductRequsetDto {
    private String name;
    private Integer categoryId;
    private Integer productDetailsId;
}
