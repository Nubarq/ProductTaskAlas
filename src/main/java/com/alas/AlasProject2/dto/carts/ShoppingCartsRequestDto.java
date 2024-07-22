package com.alas.AlasProject2.dto.carts;


import lombok.Data;

import java.util.List;
@Data
public class ShoppingCartsRequestDto {
    //private List<Product> products;
    private String name;
    private List<Integer> productIds;


}
