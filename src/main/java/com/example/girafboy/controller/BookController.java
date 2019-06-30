package com.example.girafboy.controller;

import com.example.girafboy.entity.Book;
import com.example.girafboy.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/book")
@CrossOrigin
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/findAllBook")
    public List<Book> findAllBook(){
        return bookService.findBook();
    }

    @GetMapping("/findBookByType/{type}")
    public List<Book> findAllBook(@PathVariable String type){
        return bookService.findBook(type);
    }

    @GetMapping("/findBook/{id}")
    public Book findBook(@PathVariable Integer id){
        return bookService.findBook(id);
    }

    @PutMapping("/modifyStock/{id}/{amount}")
    public String modifyStock(@PathVariable("id")Integer id, @PathVariable("amount") Integer amount){
        if(bookService.modifyStock(id, amount))
            return "修改成功";
        else
            return "修改失败";
    }

    @PutMapping("/modify")
    public String modify(@RequestBody Book book){
        if(bookService.modify(book))
            return "修改成功";
        else
            return "修改失败";
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Integer id){
        if(bookService.deleteBook(id))
            return "删除成功";
        return "删除失败";
    }
}
