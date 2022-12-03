package com.ironLibrary.IronLibrary.Library;

import com.ironLibrary.IronLibrary.Models.Author;
import com.ironLibrary.IronLibrary.Models.Book;
import com.ironLibrary.IronLibrary.Repositories.AuthorRepository;
import com.ironLibrary.IronLibrary.Repositories.BookRepository;
import com.ironLibrary.IronLibrary.Repositories.IssueRepository;
import com.ironLibrary.IronLibrary.Repositories.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class LibraryTest {

   @Autowired
    AuthorRepository authorRepository;
   @Autowired
    BookRepository bookRepository;
   @Autowired
    IssueRepository issueRepository;
   @Autowired
    StudentRepository studentRepository;

   @BeforeEach
   void setUp(){

      List<Book> booksList = bookRepository.saveAll(
               List.of(
                       new Book("18362946", "100 años de soledad", "romance", 5, authorRepository.findById(1).get()),
                       new Book("38165492", "La soledad", "erotico", 9, authorRepository.findById(2).get()),
                       new Book("38163847", "Recetas de cocina", "cocina", 1, authorRepository.findById(1).get())
               )
      );

   }
@Test
   public void addBook_OK(){
       Assertions.assertEquals(4, bookRepository.findAll().size());
   }
}