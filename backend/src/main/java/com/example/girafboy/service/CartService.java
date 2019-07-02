package com.example.girafboy.service;

import com.example.girafboy.entity.OrderItem;

import java.util.List;

public interface CartService {
    OrderItem addBookToCart(Integer bookID, String userID, Integer amount);
    List<OrderItem> findCartByUser(String userID);
    Boolean deleteCartItem(Integer id);
}
