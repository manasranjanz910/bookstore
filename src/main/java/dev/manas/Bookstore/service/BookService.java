package dev.manas.Bookstore.service;

import dev.manas.Bookstore.dto.BookStoreRequestDto;
import dev.manas.Bookstore.dto.BookStoreResponseDto;

import java.util.List;

public interface BookService {
    BookStoreResponseDto addNewBook(BookStoreRequestDto bookDto);

    void addBook(Long id, int quantityToAdd);

    BookStoreResponseDto getBookById(Long bookId);

    List<BookStoreResponseDto> getAllBooks();

    BookStoreResponseDto updateBook(long bookId,BookStoreRequestDto bookStoreRequestDto);
}
