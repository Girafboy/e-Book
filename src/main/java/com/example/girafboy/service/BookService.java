package com.example.girafboy.service;

import com.example.girafboy.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {
    Book findBook(Integer id);
    List<Book> findBook();
    List<Book> findBook(String type);
}
