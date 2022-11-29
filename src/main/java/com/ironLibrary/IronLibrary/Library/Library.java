package com.ironLibrary.IronLibrary.Library;

import com.ironLibrary.IronLibrary.Models.Author;
import com.ironLibrary.IronLibrary.Models.Book;
import com.ironLibrary.IronLibrary.Models.Issue;
import com.ironLibrary.IronLibrary.Models.Student;
import com.ironLibrary.IronLibrary.Repositories.AuthorRepository;
import com.ironLibrary.IronLibrary.Repositories.BookRepository;
import com.ironLibrary.IronLibrary.Repositories.IssueRepository;
import com.ironLibrary.IronLibrary.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    IssueRepository issueRepository;

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    Scanner scanner = new Scanner(System.in);
    Book book1;
    Student student1;
    Issue issue1;
    Author author1;
    public Library() {
    }

    public void addBookData() throws IOException {

        System.out.println("Enter isbn: ");
        String isbn = scanner.nextLine();
        book1.setIsbn(isbn);
        System.out.println("Enter title: ");
        String title = input.readLine();
        book1.setTitle(title);
        System.out.println("Enter category: ");
        String category = input.readLine();
        book1.setCategory(category);
        createAuthor();
        System.out.println("Enter number of book ");
        Integer numberOfBook = scanner.nextInt();
        book1.setQuantity(numberOfBook);
        addABook(book1);
/*
        Enter category : Romance
        Enter Author name : Nicholas Sparks
        Enter Author mail : nicholassparks@gmail.com
        Enter number of books : 4
 */
    }
    public void createAuthor() throws IOException {
        System.out.println("Enter author name: ");
        String authorName = input.readLine();
        if (authorRepository.findByName(authorName).isPresent()){
            author1 = authorRepository.findByName(authorName).get();
            book1.setAuthor(author1);
            // añadir el libro a la lista del autor
        }else{
            //en caso de no encontrar el Author en la base de datos, creamos uno nuevo
            System.out.println("Enter author email: ");
            String authorEmail = input.readLine();
            Author newAuthor = new Author(authorName, authorEmail,new ArrayList<>());
            authorRepository.save(newAuthor);
            book1.setAuthor(newAuthor);
            // añadir el libro a la lista del autor
        }
    }

    public void addABook(Book book) {
        bookRepository.save(book);
    }

    public void searchBookByTitle() {
    }

    public void searchBookByCategory() {
    }

    public void seacrhBookByAuthor() {
    }

    public void listAllbooksAlongWithAutor() {
    }

    public void issueBookToStudent() {
    }

    public void listBooksByUsn() {
    }
}
