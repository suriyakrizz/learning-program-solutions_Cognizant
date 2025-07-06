package com.example.LibraryManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/post")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping("/get")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
    @PutMapping("/update/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        return bookService.updateBook(id, updatedBook);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        return bookService.deleteBook(id);
    }


}
