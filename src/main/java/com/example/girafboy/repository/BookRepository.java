package com.example.girafboy.repository;

import com.example.girafboy.entity.Book;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public interface BookRepository extends JpaRepository<Book, Integer> {
}
