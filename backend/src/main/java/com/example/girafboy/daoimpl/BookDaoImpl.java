package com.example.girafboy.daoimpl;

import com.example.girafboy.dao.BookDao;
import com.example.girafboy.entity.Book;
import com.example.girafboy.repository.BookRepository;
import com.example.girafboy.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private BookRepository bookRepository;
    private PictureRepository pictureRepository;

    @Override
    public List<Book> findAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book findByID(Integer id) {
        return bookRepository.getOne(id);
    }

    @Override
    public Book addBook(String bookName, String author, String coverUrl, String ISBN, BigDecimal price, Integer stock, String description) {
        Book book =new Book();
        book.setBookName(bookName);
        book.setAuthor(author);
        book.setCoverUrl(coverUrl);
        book.setISBN(ISBN);
        book.setPrice(price);
        book.setStock(stock);
        book.setDescription(description);
        return bookRepository.saveAndFlush(book);
    }

    @Override
    public Boolean modifyBook(Integer id, String bookName, String author, String coverUrl, String ISBN, BigDecimal price, Integer stock, String description) {
        Book book = findByID(id);
        if(book == null)
            return false;
        if(bookName!=null)
            book.setBookName(bookName);
        if(author!=null)
            book.setAuthor(author);
        if(coverUrl!=null)
            book.setCoverUrl(coverUrl);
        if(ISBN!=null)
            book.setISBN(ISBN);
        if(price!=null)
            book.setPrice(price);
        if (stock!=null)
            book.setStock(stock);
        if(description!=null)
            book.setDescription(description);
        bookRepository.saveAndFlush(book);
        return true;
    }

    @Override
    public Boolean reduceStock(Integer id, Integer amount) {
        Book book =findByID(id);
        int stock = book.getStock();
        if(stock >= amount) {
            stock -= amount;
            book.setStock(stock);
            bookRepository.saveAndFlush(book);
            return true;
        }else
            return false;
    }

    @Override
    public List<Book> findByType(String bookType) {
        List<Book> books = bookRepository.findAll();
        Iterator<Book> bookIterator = books.iterator();
        books.removeIf(book -> {
            return !book.getBookTypes().contains(bookType);
        });
        return books;
    }

    @Override
    public Boolean deleteBook(Integer id) {
        if(bookRepository.getOne(id) == null)
            return false;
        bookRepository.deleteById(id);
        return true;
    }
}
