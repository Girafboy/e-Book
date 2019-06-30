package com.example.girafboy.serviceimpl;

import com.example.girafboy.dao.BookDao;
import com.example.girafboy.entity.Book;
import com.example.girafboy.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookDao bookDao;

    @Override
    public Book findBook(Integer id) {
        return bookDao.findByID(id);
    }

    @Override
    public List<Book> findBook() {
        return bookDao.findAllBook();
    }

    @Override
    public List<Book> findBook(String type) {
        return bookDao.findByType(type);
    }

    @Override
    public Boolean modifyStock(Integer id, Integer amount) {
        if(bookDao.findByID(id) == null)
            return false;
        bookDao.modifyBook(id,null,null,null,null,null, amount,null);
        return true;
    }

    @Override
    public Boolean modify(Book book) {
        return bookDao.modifyBook(book.getBookID(),
                book.getBookName(),
                book.getAuthor(),
                book.getCoverUrl(),
                book.getISBN(),
                book.getPrice(),
                book.getStock(),
                book.getDescription());
    }

    @Override
    public Boolean deleteBook(Integer id) {
        return bookDao.deleteBook(id);
    }
}
