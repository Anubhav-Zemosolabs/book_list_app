package com.bookportal.app.controller;

import com.bookportal.app.entity.Book;
import com.bookportal.app.exceptionhandling.BookNotFoundException;
import com.bookportal.app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookRestController {

    private BookService bookService;

    @Autowired
    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    //    expose "/book" and return list of books
    @GetMapping("/")
    public List<Book> findAll(){
        return bookService.findAll();
    }

    // Get book by id
    @GetMapping("/{bookId}")
    public Book getBookById(@PathVariable Integer bookId){
        Book theBook = bookService.findById(bookId);
        if(theBook == null){
            throw new RuntimeException("Book id not found -"+bookId);
        }
        return theBook;
    }

    // Post method to add new book
    @PostMapping("/")
    public Book addBook(@RequestBody Book theBook){
        theBook.setBookId(0);
        bookService.save(theBook);
        return theBook;
    }

    // Put method to update the present book details
    @PutMapping("/")
    public Book updateTodo(@RequestBody Book theBook){
        bookService.save(theBook);
        return theBook;
    }

    // Delete mapping for deleting book
    @DeleteMapping("/{bookId}")
    public String deleteBook(@PathVariable Integer bookId){

        Book theBook=bookService.findById(bookId);

        // throw exception if null
        if(theBook==null){
            throw new BookNotFoundException("Book Id not found - " + bookId);
        }
        bookService.deleteById(bookId);
        return "Deleted Book with id :- " + bookId;
    }

}
