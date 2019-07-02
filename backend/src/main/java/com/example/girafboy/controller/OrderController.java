package com.example.girafboy.controller;

import com.example.girafboy.entity.Order;
import com.example.girafboy.entity.OrderItem;
import com.example.girafboy.service.CartService;
import com.example.girafboy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    CartService cartService;

    @GetMapping("/findAllOrder/{userID}")
    public List<Order> findAllOrder( HttpSession session, @PathVariable String userID){
        System.out.println(session.getAttribute("userID"));
        return orderService.findAllOrder(userID);
    }

    @GetMapping("/findAllOrder")
    public List<Order> findAllOrder(){
        return orderService.findAllOrder();
    }

    @GetMapping("/findOrder/{id}")
    public Order findOrder(@PathVariable Integer id){
        return orderService.findOrderByID(id);
    }

    @PostMapping("/addOrder/{userID}")
    public Order addOrder(@RequestBody Order order, @PathVariable String userID){
        return orderService.addOrder(order.getOrderItems(),userID);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Integer id){
        if(orderService.deleteOrder(id))
            return "Delete Successfully!";
        else
            return "Delete Order " + id + " Failed.";
    }

    @GetMapping("test")
    @Scope("session")
    public String test(){
        return this.toString();
    }
}
