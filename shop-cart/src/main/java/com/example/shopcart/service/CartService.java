package com.example.shopcart.service;

import com.example.shopcart.dto.CartDto;
import com.example.shopcart.dto.CreateCartRequest;
import com.example.shopcart.entity.Cart;
import com.example.shopcart.repository.CartRepository;
import com.example.shopcore.dto.ApiResponse;
import com.example.shopcore.exception.BusinessException;
import com.example.shopuser.entity.User;

import com.example.shopuser.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;


        public ApiResponse<CartDto> createCart(CreateCartRequest req) {
            Long userId = req.getUserId();
            // 1) User phải tồn tại
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new BusinessException("User not found"));

            // 2) Idempotent: nếu user đã có cart -> trả luôn cart cũ
            Cart cart = cartRepository.findByUserId(userId)
                    .orElseGet(() -> cartRepository.save(
                            Cart.builder().user(user).build()
                    ));

            // 3) Build DTO trực tiếp (không mapper)
            CartDto dto = CartDto.builder()
                    .id(cart.getId())
                    .userId(cart.getUser().getId())
                    .build();

            return ApiResponse.ok(dto);
        }
}
