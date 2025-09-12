package com.example.shopcartitem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.example.shopcart",
        "com.example.shopcartitem",
        "com.example.shopproduct"


}
)
public class ShopCartItemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopCartItemApplication.class, args);
    }

}
