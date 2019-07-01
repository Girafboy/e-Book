package com.example.girafboy.dao;

import com.example.girafboy.entity.Order;
import com.example.girafboy.entity.OrderItem;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface OrderDao {
    Order findByID(Integer id);
    List<Order> findAllOrder();
    Order findCartByUserID(String userID);
    List<Order> findByUserID(String id);
    List<Order> findByDate(Date date1, Date date2);
    List<Order> findByDateAndUser(Date date1, Date date2, String userID);
    Order addOrder(String userID, Date date, String state);
    OrderItem addOrderItem(Integer id, Integer bookID, Integer amount);
    Boolean updateOrder(Integer id, Date date, String state);
    Boolean deleteOrder(Integer id);
    Boolean deleteOrderItem(Integer id);
    BigDecimal getTotPrice(Integer id);
}
