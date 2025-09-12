package com.example.shopcartitem.controller;

import com.example.shopcartitem.dto.CartItemDto;
import com.example.shopcartitem.dto.CreateCartItemRequest;
import com.example.shopcartitem.service.CartItemService;
import com.example.shopcore.dto.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/CartItems")
@RequiredArgsConstructor
public class CartItemController {

    public final CartItemService cartItemService;

    @PostMapping
    public ApiResponse<CartItemDto> create(@PathVariable Long cartId,
                                           @RequestBody @Valid CreateCartItemRequest req) {
        return cartItemService.createCartItem(cartId, req);
    }
}
