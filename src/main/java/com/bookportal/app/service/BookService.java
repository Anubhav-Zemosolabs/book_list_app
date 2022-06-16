package com.bookportal.app.service;


import com.bookportal.app.entity.Book;

import java.util.List;

public interface BookService {
    public List<Book> findAll();
    public Book findById(Long theId);
    public void save(Book theBook);
    public void deleteById(Long theId);
}
