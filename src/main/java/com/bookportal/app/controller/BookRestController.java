package com.bookportal.app.controller;

import com.bookportal.app.entity.Book;
import com.bookportal.app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.lang.Integer;

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

//    add mapping for get /book/{bookid}
    @GetMapping("/{bookId}")
    public Book getBookById(@PathVariable Integer bookId){
        Book theBook = bookService.findById(bookId);
        if(theBook == null){
            throw new RuntimeException("Book id not found -"+bookId);
        }
        return theBook;
    }

//    add mapping for POST /list - add new bookItem
    @PostMapping("/")
    public Book addBook(@RequestBody Book theBook){
        theBook.setBookId(0);
        bookService.save(theBook);
        return theBook;
    }

//    add mapping for PUT/list - update an existing Book
    @PutMapping("/")
    public Book updateTodo(@RequestBody Book theBook){
        bookService.save(theBook);
        return theBook;
    }

//    add mapping for DELETE /list/{bookId} -delete bookItem
    @DeleteMapping("/{bookId}")
    public String deleteBook(@PathVariable Integer bookId){
        Book theBook=bookService.findById(bookId);
//        throw exception if null
        if(theBook==null){
            throw new RuntimeException("Book Id not found - "+bookId);
        }
        bookService.deleteById(bookId);
        return "Deleted Book with id :- "+bookId;
    }

}
