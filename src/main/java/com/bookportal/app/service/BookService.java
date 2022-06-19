package com.bookportal.app.service;


import com.bookportal.app.entity.Book;
import java.util.List;

public interface BookService {
    List<Book> findAll();
    Book findById(Integer theId);
    void save(Book theBook);
    void deleteById(Integer theId);
}
