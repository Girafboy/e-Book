package com.example.girafboy.service;

import com.example.girafboy.entity.Order;
import com.example.girafboy.entity.OrderItem;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderService {
    Order findOrderByID(Integer id);
    List<Order> findAllOrder(String userID);
    Order addOrder(List<OrderItem> orderItems, String userID);
    Boolean deleteOrder(Integer id);
}
