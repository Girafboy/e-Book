package com.example.girafboy.repository;

import com.example.girafboy.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

}
