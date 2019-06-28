package com.example.girafboy.dao;

import com.example.girafboy.entity.Book;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

public interface BookDao {
    List<Book> findAllBook();
    Book findByID(Integer id);
    Book addBook(String bookName, String author, String coverUrl,
                   String ISBN, BigDecimal price, Integer stock, String description);
    Boolean modifyBook(Integer id, String bookName, String author, String coverUrl,
                    String ISBN, BigDecimal price, Integer stock, String description);
    Boolean reduceStock(Integer id, Integer amount);
    List<Book> findByType(String bookType);
    Boolean deleteBook(Integer id);
}
