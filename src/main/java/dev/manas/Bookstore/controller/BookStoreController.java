package dev.manas.Bookstore.controller;

import dev.manas.Bookstore.dto.BookStoreRequestDto;
import dev.manas.Bookstore.dto.BookStoreResponseDto;
import dev.manas.Bookstore.service.BookService;
import dev.manas.Bookstore.service.BookServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookStoreController {
    private BookService bookStoreService;
    public BookStoreController(BookService bookStoreService)
    {
        this.bookStoreService = bookStoreService;
    }

    @PostMapping
    public ResponseEntity<BookStoreResponseDto>addANewBook(@RequestBody BookStoreRequestDto bookStoreRequestDto)
    {
        return ResponseEntity.ok(bookStoreService.addNewBook(bookStoreRequestDto));
    }
    @GetMapping("/{bookId}")
    public ResponseEntity<BookStoreResponseDto> getBookById(@PathVariable long bookId)
    {
        return ResponseEntity.ok(bookStoreService.getBookById(bookId));
    }

    @GetMapping
    public ResponseEntity<List<BookStoreResponseDto>> getAllBooks()
    {
        return ResponseEntity.ok(bookStoreService.getAllBooks());
    }
}
