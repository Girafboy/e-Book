package com.example.girafboy.controller;

import com.example.girafboy.entity.Order;
import com.example.girafboy.entity.OrderItem;
import com.example.girafboy.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@CrossOrigin
public class CartController {
    @Autowired
    CartService cartService;

    @GetMapping("/findCart/{userID}")
    public List<OrderItem> findOrderByUser(@PathVariable String userID){
        return cartService.findCartByUser(userID);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCartItem(@PathVariable Integer id){
        if(cartService.deleteCartItem(id))
            return "Delete Successfully!";
        else
            return "Delete CartItem " + id + " Failed.";
    }

    @PostMapping("/addCartItem/{bookID}/{amount}/{userID}")
    public OrderItem addCartItem(@PathVariable("bookID") Integer bookID,
                                 @PathVariable("amount") Integer amount,
                                 @PathVariable("userID") String userID){
        return cartService.addBookToCart(bookID,userID,amount);
    }
}
