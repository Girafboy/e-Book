package com.example.girafboy.service;

import com.example.girafboy.entity.Book;
import com.example.girafboy.entity.BookStatistic;
import com.example.girafboy.entity.User;
import com.example.girafboy.entity.UserStatistic;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface StatisticService {
    List<BookStatistic> getSaleOfBook(Date date1, Date date2);
    List<UserStatistic> getSaleOfUser(Date date1, Date date2);
    List<BookStatistic> getBuyOfBook(Date date1, Date date2, String userID);
}
