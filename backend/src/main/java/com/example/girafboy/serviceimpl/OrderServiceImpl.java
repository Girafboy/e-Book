package com.example.girafboy.serviceimpl;

import com.example.girafboy.dao.BookDao;
import com.example.girafboy.dao.OrderDao;
import com.example.girafboy.dao.UserDao;
import com.example.girafboy.entity.Order;
import com.example.girafboy.entity.OrderItem;
import com.example.girafboy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private BookDao bookDao;

    @Override
    public Order findOrderByID(Integer id) {
        return orderDao.findByID(id);
    }

    @Override
    public List<Order> findAllOrder(String userID) {
        return orderDao.findByUserID(userID);
    }

    @Override
    public List<Order> findAllOrder() {
        return orderDao.findAllOrder();
    }

    @Override
    public Order addOrder(List<OrderItem> orderItems, String userID) {
        for (OrderItem item:orderItems)
            orderDao.deleteOrderItem(item.getId());
        Order order = orderDao.addOrder(userID,new Date(),"paid");
        for (OrderItem item:orderItems) {
            orderDao.addOrderItem(order.getOrderID(), item.getBook().getBookID(), item.getAmount());
            bookDao.reduceStock(item.getBook().getBookID(),item.getAmount());
        }
        return orderDao.findByID(order.getOrderID());
    }

    @Override
    public Boolean deleteOrder(Integer id) {
        return orderDao.deleteOrder(id);
    }

}
