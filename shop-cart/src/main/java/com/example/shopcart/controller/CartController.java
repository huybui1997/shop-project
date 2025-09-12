package com.example.shopcart.controller;

import com.example.shopcart.dto.CartDto;
import com.example.shopcart.dto.CreateCartRequest;
import com.example.shopcart.service.CartService;
import com.example.shopcore.dto.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/carts")
@RequiredArgsConstructor
public class CartController {

    public final CartService cartService;

    @PostMapping
    public ApiResponse<CartDto> createCart(@Valid @RequestBody CreateCartRequest dto) {
        return cartService.createCart(dto);
    }
}
