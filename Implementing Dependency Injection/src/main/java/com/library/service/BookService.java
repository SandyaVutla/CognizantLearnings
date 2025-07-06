package com.library.service;
import com.library.repository.BookRepository;
public class BookService {
    private BookRepository bookRepository;
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public void listBooks() {
        System.out.println("BookService: Calling repository to display books...");
        bookRepository.displayBooks();
    }
}
