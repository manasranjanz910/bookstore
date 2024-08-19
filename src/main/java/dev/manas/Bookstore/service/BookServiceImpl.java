package dev.manas.Bookstore.service;


import dev.manas.Bookstore.constant.Category;
import dev.manas.Bookstore.dto.BookStoreRequestDto;
import dev.manas.Bookstore.dto.BookStoreResponseDto;
import dev.manas.Bookstore.entity.Book;
import dev.manas.Bookstore.exception.BookNotFoundException;
import dev.manas.Bookstore.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    private BookRepository bookRepository;
    public BookServiceImpl(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookStoreResponseDto addNewBook(BookStoreRequestDto bookDto) {
        Book b = convertBookStoreRequestDtoToBook(bookDto);
        Book savedBook = bookRepository.save(b);
        return convertBookToBookStoreResponseDto(savedBook);
    }

    @Override
    public void addBook(Long id, int quantityToAdd) {

    }

    @Override
    public BookStoreResponseDto getBookById(Long bookId) {
        Book savedBook = bookRepository.findById(bookId).orElseThrow(()->
                new BookNotFoundException("Book Not Found For Id"+bookId));
        return convertBookToBookStoreResponseDto(savedBook);


    }
    @Override
    public List<BookStoreResponseDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookStoreResponseDto> bookResponseDto = new ArrayList<>();
        for (Book b : books)
        {
            bookResponseDto.add(convertBookToBookStoreResponseDto(b));
        }
        return bookResponseDto;
    }

    @Override
    public BookStoreResponseDto updateBook(long bookId, BookStoreRequestDto bookStoreRequestDto) {
        return null;
    }

    BookStoreResponseDto convertBookToBookStoreResponseDto(Book book )
    {
        BookStoreResponseDto bookStoreResponseDto = new BookStoreResponseDto();
        bookStoreResponseDto.setId(book.getId());
        bookStoreResponseDto.setTitle(book.getTitle());
        bookStoreResponseDto.setAuthor(book.getAuthor());
        bookStoreResponseDto.setPrice(book.getPrice());
        bookStoreResponseDto.setTotalCount(book.getTotalCount());
        bookStoreResponseDto.setCategory(book.getCategory());
        return bookStoreResponseDto;


    }
    Book convertBookStoreRequestDtoToBook(BookStoreRequestDto bookStoreRequestDto)
    {
        Book book = new Book();
        book.setCategory(bookStoreRequestDto.getCategory());
        book.setTitle(bookStoreRequestDto.getTitle());
        book.setAuthor(bookStoreRequestDto.getAuthor());
        book.setPrice(bookStoreRequestDto.getPrice());
        book.setTotalCount(bookStoreRequestDto.getTotalCount());
        return book;
    }

}
