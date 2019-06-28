package com.example.girafboy.controller;

import com.example.girafboy.entity.Book;
import com.example.girafboy.service.BookService;
import com.example.girafboy.service.PictrueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/book")
@CrossOrigin
public class BookController {
    @Autowired
    BookService bookService;
    PictrueService pictrueService;

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

    @GetMapping(value = "/picture/{name}",produces = {MediaType.IMAGE_JPEG_VALUE,MediaType.IMAGE_PNG_VALUE})
    public byte[] getPictrue(@PathVariable String name){
        return pictrueService.getPictureBlob(name);
    }

}
