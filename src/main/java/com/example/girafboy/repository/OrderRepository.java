package com.example.girafboy.repository;

import com.example.girafboy.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findOrdersByDateBetween(Date date1, Date date2);
    List<Order> findOrdersByState(String state);
}
