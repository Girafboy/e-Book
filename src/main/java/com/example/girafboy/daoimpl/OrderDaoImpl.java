package com.example.girafboy.daoimpl;


import com.example.girafboy.dao.OrderDao;
import com.example.girafboy.entity.Order;
import com.example.girafboy.entity.OrderItem;
import com.example.girafboy.repository.BookRepository;
import com.example.girafboy.repository.OrderItemRepository;
import com.example.girafboy.repository.OrderRepository;
import com.example.girafboy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Convert;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public Order findByID(Integer id) {
        return orderRepository.getOne(id);
    }

    @Override
    public Order findCartByUserID(String userID) {
        List<Order> orders = userRepository.getOne(userID).getOrders();
        for (Order o:orders)
            if (o.getState().equals("cart"))
                return o;
        return addOrder(userID,new Date(),"cart");
    }

    @Override
    public List<Order> findByUserID(String id) {
        List<Order> orders = userRepository.getOne(id).getOrders();
        for (Order o:orders)
            if (o.getState().equals("cart")) {
                orders.remove(o);
                return orders;
            }
        return orders;
    }

    @Override
    public List<Order> findByDate(Date date1, Date date2) {
        return orderRepository.findOrdersByDateBetween(date1,date2);
    }

    @Override
    public Order addOrder(String userID, Date date, String state) {
        Order order = new Order();
        order.setUser(userRepository.getOne(userID));
        order.setDate(date);
        order.setState(state);
        return orderRepository.saveAndFlush(order);
    }

    @Override
    public OrderItem addOrderItem(Integer id, Integer bookID, Integer amount) {
        Order order = orderRepository.getOne(id);
        List<OrderItem> orderItems = order.getOrderItems();
        if(orderItems != null) {
            for (OrderItem item : orderItems)
                if (item.getBook().getBookID().equals(bookID)) {
                    item.setAmount(item.getAmount()+amount);
                    return orderItemRepository.saveAndFlush(item);
                }
        }
        OrderItem orderItem = new OrderItem();
        orderItem.setBook(bookRepository.getOne(bookID));
        orderItem.setOrder(order);
        orderItem.setAmount(amount);
        orderItems = new LinkedList<>();
        orderItems.add(orderItem);
        return orderItemRepository.saveAndFlush(orderItem);
    }

    @Override
    public Boolean updateOrder(Integer id, Date date, String state) {
        Order order = orderRepository.getOne(id);
        if(order == null)   return false;
        order.setDate(date);
        order.setState(state);
        orderRepository.saveAndFlush(order);
        return true;
    }

    @Override
    public Boolean deleteOrder(Integer id) {
        if(orderRepository.getOne(id) == null)
            return false;
        orderRepository.deleteById(id);
        return true;
    }

    @Override
    public Boolean deleteOrderItem(Integer id) {
        List<Order> orders = orderRepository.findOrdersByState("cart");
        for(Order order:orders) {
            List<OrderItem> orderItems = order.getOrderItems();
            for (OrderItem item : orderItems)
                if (item.getId().equals(id)) {
                    orderItemRepository.delete(item);
                    return true;
                }
        }
        return false;
    }

    @Override
    public BigDecimal getTotPrice(Integer id) {
        Order order = orderRepository.getOne(id);
        if(order == null)   return null;
        List<OrderItem> orderItems = order.getOrderItems();
        BigDecimal totPrice = new BigDecimal(0);
        for (OrderItem item:orderItems)
            totPrice = totPrice.add(item.getBook().getPrice().multiply(new BigDecimal(item.getAmount().toString())));
        return totPrice;
    }
}
