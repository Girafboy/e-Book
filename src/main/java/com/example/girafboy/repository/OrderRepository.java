package com.example.girafboy.repository;

import com.example.girafboy.entity.Order;
import com.example.girafboy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findOrdersByDateBetweenAndState(Date date1, Date date2, String state);
    List<Order> findOrdersByDateBetweenAndUserAndState(Date date1, Date date2, User user, String state);
    List<Order> findOrdersByState(String state);
}
