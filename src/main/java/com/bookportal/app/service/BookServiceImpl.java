package com.bookportal.app.service;

import com.bookportal.app.repository.BookRepository;
import com.bookportal.app.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookServiceImpl implements BookService{

    private BookRepository bookRepository;
    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Integer theId) {
        Optional<Book> result= bookRepository.findById(theId);
        Book book = null;
        if(result.isPresent()) book = result.get();
        else {
            // when we didn't find the employee
            throw new RuntimeException("Did not found book id : " + theId);
        }
        return book;
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteById(Integer theId) {
        bookRepository.deleteById(theId);
    }
}
