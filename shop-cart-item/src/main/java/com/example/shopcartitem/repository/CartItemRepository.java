package com.example.shopcartitem.repository;

import com.example.shopcartitem.entity.CartItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    // Lấy 1 item theo cartId + productId (unique)

    Optional<CartItem> findByCartIdAndProductId(Long cartId, Long productId);

    // Kiểm tra đã có item này trong giỏ chưa

    boolean existsByCartIdAndProductId(Long cartId, Long productId);

    // Danh sách item trong một giỏ (không phân trang)
    List<CartItem> findAllByCartId(Long cartId);

    // Danh sách item trong một giỏ (có phân trang)
    Page<CartItem> findAllByCartId(Long cartId, Pageable pageable);

    // Xoá 1 item theo cartId + productId (trả về số bản ghi xoá)
    long deleteByCartIdAndProductId(Long cartId, Long productId);

    // Xoá toàn bộ item của một giỏ (khi clear cart/checkout)
    long deleteByCartId(Long cartId);
}
