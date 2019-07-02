package com.example.girafboy.serviceimpl;

import com.example.girafboy.dao.BookDao;
import com.example.girafboy.dao.OrderDao;
import com.example.girafboy.dao.UserDao;
import com.example.girafboy.entity.*;
import com.example.girafboy.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService {
    @Autowired
    BookDao bookDao;
    @Autowired
    UserDao userDao;
    @Autowired
    OrderDao orderDao;

    private List<BookStatistic> getBookStatistics(List<Order> orders) {
        HashMap<Book, Integer> bookHashMap = new HashMap<>();
        for (Order o :
                orders) {
            for (OrderItem item :
                    o.getOrderItems()) {
                if (bookHashMap.containsKey(item.getBook()))
                    bookHashMap.put(item.getBook(), bookHashMap.get(item.getBook()) + item.getAmount());
                else
                    bookHashMap.put(item.getBook(), item.getAmount());
            }
        }

        List<BookStatistic> bookStatistics = new LinkedList<>();
        for (Book key :
                bookHashMap.keySet()) {
            bookStatistics.add(new BookStatistic(key, bookHashMap.get(key)));
        }
        return bookStatistics;
    }

    @Override
    public List<BookStatistic> getSaleOfBook(Date date1, Date date2) {
        List<Order> orders = orderDao.findByDate(date1,date2);
        return getBookStatistics(orders);
    }

    @Override
    public List<UserStatistic> getSaleOfUser(Date date1, Date date2) {
        List<UserStatistic> userStatistics = new LinkedList<>();
        List<User> users = userDao.findAllUser();
        for (User user :
                users) {
            List<Order> orders = orderDao.findByDateAndUser(date1,date2,user.getUserID());
            userStatistics.add(new UserStatistic(user,getBookStatistics(orders)));
        }
        return userStatistics;
    }

    @Override
    public List<BookStatistic> getBuyOfBook(Date date1, Date date2, String userID) {
        List<Order> orders = orderDao.findByDateAndUser(date1,date2, userID);
        return getBookStatistics(orders);
    }
}
