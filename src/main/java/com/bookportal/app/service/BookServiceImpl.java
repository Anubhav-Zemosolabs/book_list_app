package com.bookportal.app.service;

import com.bookportal.app.repository.BookRepository;
import com.bookportal.app.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
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
        Book theBook=null;
        if(result.isPresent()) theBook=result.get();
        else {
//            we didn't find the employee
            throw new RuntimeException("Did not found book id : "+theId);
        }
        return theBook;
    }

    @Override
    public void save(Book theBook) {
        bookRepository.save(theBook);
    }

    @Override
    public void deleteById(Integer theId) {
        bookRepository.deleteById(theId);
    }
}
