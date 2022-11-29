package com.ironLibrary.IronLibrary;

import com.ironLibrary.IronLibrary.Models.Book;
import com.ironLibrary.IronLibrary.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthorTests {
    Book book;
    @Autowired
    BookRepository bookRepository;


}
