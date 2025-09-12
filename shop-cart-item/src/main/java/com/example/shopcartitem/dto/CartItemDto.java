package com.example.shopcartitem.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItemDto {
    @NotNull
    private Long id;

    @NotNull
    private Long cartId;

    @NotNull
    private Long productId;

    private Integer quantity;
}
