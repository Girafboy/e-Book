package com.example.girafboy.controller;

import com.example.girafboy.entity.Book;
import com.example.girafboy.entity.BookStatistic;
import com.example.girafboy.entity.UserStatistic;
import com.example.girafboy.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/statistic")
@CrossOrigin
public class StatisticController {
    @Autowired
    StatisticService statisticService;

    @GetMapping("/saleOfBook/{date1}/{date2}")
    List<BookStatistic> saleOfBook(@PathVariable("date1") Long date1,
                                   @PathVariable("date2") Long date2){
        return statisticService.getSaleOfBook(new Date(date1),new Date(date2));
    }

    @GetMapping("/saleOfUser/{date1}/{date2}")
    List<UserStatistic> saleOfUser(@PathVariable("date1") Long date1,
                                   @PathVariable("date2") Long date2){
        return statisticService.getSaleOfUser(new Date(date1),new Date(date2));
    }

    @GetMapping("/buyOfBook/{date1}/{date2}/{userID}")
    List<BookStatistic> saleOfBook(@PathVariable("date1") Long date1,
                                   @PathVariable("date2") Long date2,
                                   @PathVariable("userID") String userID){
        return statisticService.getBuyOfBook(new Date(date1),new Date(date2), userID);
    }

}
