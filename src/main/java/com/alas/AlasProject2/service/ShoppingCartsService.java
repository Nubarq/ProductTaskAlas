package com.alas.AlasProject2.service;


import com.alas.AlasProject2.dto.carts.AddProductsToShoppingCartsRequestDto;
import com.alas.AlasProject2.dto.carts.ShoppingCartsRequestDto;
import com.alas.AlasProject2.dto.carts.ShoppingCartsResponseDto;
import com.alas.AlasProject2.model.ShoppingCarts;

import java.util.List;

public interface ShoppingCartsService {
    ShoppingCarts addProduct(AddProductsToShoppingCartsRequestDto dto);

    ShoppingCarts createCart(ShoppingCartsRequestDto cartsRequestDto);

    void removeProductFromCart(Integer cartId, List<Integer> productId);
    ShoppingCartsResponseDto getShoppingCartById(Integer cartId);
}
