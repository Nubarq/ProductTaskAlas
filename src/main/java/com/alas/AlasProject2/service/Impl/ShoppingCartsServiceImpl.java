package com.alas.AlasProject2.service.Impl;


import com.alas.AlasProject2.dto.carts.AddProductsToShoppingCartsRequestDto;
import com.alas.AlasProject2.dto.carts.ShoppingCartsRequestDto;
import com.alas.AlasProject2.dto.carts.ShoppingCartsResponseDto;
import com.alas.AlasProject2.exeption.CustomException;
import com.alas.AlasProject2.mapper.ShoppingCartsMapper;
import com.alas.AlasProject2.model.Product;
import com.alas.AlasProject2.model.ShoppingCarts;
import com.alas.AlasProject2.repository.ProductRepository;
import com.alas.AlasProject2.repository.ShoppingCartsRepository;
import com.alas.AlasProject2.service.ShoppingCartsService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Transactional
public class ShoppingCartsServiceImpl implements ShoppingCartsService {

    ProductRepository productRepository;
    ShoppingCartsRepository cartsRepository;
    ShoppingCartsMapper cartsMapper;


    @Override
    public ShoppingCarts addProduct(AddProductsToShoppingCartsRequestDto dto) {
        ShoppingCarts carts = cartsRepository.findById(dto.getCardId()).orElseThrow(() -> new CustomException("not found"));
        List<Product> products = productRepository.findAllById(dto.getProductIds());
        List<Product> cartsProducts = carts.getProducts();
        cartsProducts.addAll(products);
        return cartsRepository.save(carts);
    }

    @Override
    public ShoppingCarts createCart(ShoppingCartsRequestDto dto) {
//        ShoppingCarts shoppingCarts = cartsMapper.mapShoppingCartyRequestToEntity(cartsRequestDto);
        ShoppingCarts shoppingCarts = new ShoppingCarts();
        shoppingCarts.setName(dto.getName());

        List<Product> productList = productRepository.findAllById(dto.getProductIds());
        shoppingCarts.setProducts(productList);

        return cartsRepository.save(shoppingCarts);
    }

    @Override
    public void removeProductFromCart(Integer cartId, List<Integer> productId) {
        ShoppingCarts carts = cartsRepository.findById(cartId).orElseThrow(() -> new CustomException("not found"));
        List<Product> productsToRemove = productRepository.findAllById(productId);
        carts.getProducts().removeAll(productsToRemove);
        cartsRepository.save(carts);
    }

    @Override
    public ShoppingCartsResponseDto getShoppingCartById(Integer cartId) {
        ShoppingCarts cart = cartsRepository.findById(cartId).orElseThrow(() -> new CustomException("not found"));
        return cartsMapper.mapEntityToShoppingCartResponse(cart);
    }

}
