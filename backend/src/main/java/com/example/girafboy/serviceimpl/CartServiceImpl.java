package com.example.girafboy.serviceimpl;

import com.example.girafboy.dao.BookDao;
import com.example.girafboy.dao.OrderDao;
import com.example.girafboy.dao.UserDao;
import com.example.girafboy.entity.Order;
import com.example.girafboy.entity.OrderItem;
import com.example.girafboy.entity.User;
import com.example.girafboy.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    UserDao userDao;
    @Autowired
    BookDao bookDao;
    @Autowired
    OrderDao orderDao;

    @Override
    public OrderItem addBookToCart(Integer bookID, String userID, Integer amount) {
        Order order = orderDao.findCartByUserID(userID);
        return orderDao.addOrderItem(order.getOrderID(),bookID,amount);
    }

    @Override
    public List<OrderItem> findCartByUser(String userID) {
        return orderDao.findCartByUserID(userID).getOrderItems();
    }

    @Override
    public Boolean deleteCartItem(Integer id) {
        return orderDao.deleteOrderItem(id);
    }
}
