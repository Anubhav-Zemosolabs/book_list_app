package com.bookportal.app.controller;

import com.bookportal.app.entity.Book;
import com.bookportal.app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookRestController {
    @Autowired
    private BookService bookService;


//    public BookRestController(BookService bookService) {
//        this.bookService = bookService;
//    }

    //    expose "/book" and return list of books
    @GetMapping("/list")
    public List<Book> findAll(){
        return bookService.findAll();
    }

//    add mapping for get /list/{bookid}
    @GetMapping("/list/{bookId}")
    public Book getBook(@PathVariable Long bookId){
        Book theBook=bookService.findById(bookId);
        if(theBook==null){
            throw new RuntimeException("Book id not found -"+bookId);
        }
        return theBook;
    }

//    add mapping for POST /list - add new bookItem
    @PostMapping("/list")
    public Book addBook(@RequestBody Book theBook){
        theBook.setSlNo(0L);
        bookService.save(theBook);
        return theBook;
    }

//    add mapping for PUT/list - update an existing Book
    @PutMapping("/list")
    public Book updateTodo(@RequestBody Book theBook){
        bookService.save(theBook);
        return theBook;
    }

//    add mapping for DELETE /list/{bookId} -delete bookItem
    @DeleteMapping("/list/{bookId}")
    public String deleteBook(@PathVariable Long bookId){
        Book thebook=bookService.findById(bookId);
//        throw exception if null
        if(thebook==null){
            throw new RuntimeException("Book Id not found - "+bookId);
        }
        bookService.deleteById(bookId);
        return "Deleted Book with id :- "+bookId;
    }

}
