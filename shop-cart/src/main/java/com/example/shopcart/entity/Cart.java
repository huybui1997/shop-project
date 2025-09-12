package com.example.shopcart.entity;

//import com.example.shopcartitem.entity.CartItem;
import com.example.shopcore.entity.BaseEntity;
import com.example.shopuser.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Cart extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id", unique = true, nullable = false)
    private User user;


//     Sau này có CartItem:
//     @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
//     private List<CartItem> items = new ArrayList<>();

}
