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
import java.util.List;
import java.util.Scanner;

public class Library {

    BookRepository bookRepository;


    StudentRepository studentRepository;


    AuthorRepository authorRepository;


    IssueRepository issueRepository;



    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    Scanner scanner = new Scanner(System.in);
    Book book1 = new Book();
    Student student1= new Student();
    Issue issue1 = new Issue();
    Author author1 = new Author();





    public Library(AuthorRepository authorRepository1, StudentRepository studentRepository1, BookRepository bookRepository1, IssueRepository issueRepository1) {

        authorRepository=authorRepository1;
        studentRepository= studentRepository1;
        bookRepository=bookRepository1;
        issueRepository=issueRepository1;
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
        System.out.println("Enter number of books: ");
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



    public void searchBookByTitle() throws IOException {

        System.out.println("Enter title: ");
        String title = input.readLine();
        if(bookRepository.findBookByTitle(title).isPresent()){
            book1 = bookRepository.findBookByTitle(title).get();
            System.out.println("Book ISBN        Book Title       Category       Number of Books");
            System.out.println(book1.getIsbn() + "     " + " " + book1.getTitle()
                    +"       " + "    " +book1.getCategory() + "          " + "    " + book1.getQuantity());
        } else System.out.println("No book with this title.");
    }

    public void searchBookByCategory() throws IOException {

        System.out.println("Enter category: ");
        String category = input.readLine();
        List<Book> bookList = bookRepository.findBookByCategory(category);
        for(int i=0; i< bookList.size();i++){
            if(bookList.get(i).getCategory().equalsIgnoreCase(category)){
                System.out.println("Book ISBN        Book Title       Category       Number of Books");
                System.out.println(bookList.get(i).getIsbn() + "     " + " " + bookList.get(i).getTitle()
                        +"       " + "    " +bookList.get(i).getCategory() + "          " + "    " + bookList.get(i).getQuantity());
            } else System.out.println("No book in this category.");
            }
        }



    public void searchBookByAuthor() throws IOException {

        System.out.println("Enter author: ");
        String authorName = input.readLine();
        if(authorRepository.findByName(authorName).isPresent()){
            author1=authorRepository.findByName(authorName).get();
        }else System.out.println("No book with this author.");
        if(bookRepository.findBookByAuthor(author1).isPresent()){
            book1 = bookRepository.findBookByAuthor(author1).get();
            System.out.println("Book ISBN        Book Title       Category       Number of Books");
            System.out.println(book1.getIsbn() + "     " + " " + book1.getTitle()
                    +"       " + "    " +book1.getCategory() + "          " + "    " + book1.getQuantity());
        }
    }

    public void listAllBooksAlongWithAuthor() {

        List<Book> bookList = bookRepository.findAll();

        for(int i =0; i < bookList.size(); i++){
            System.out.println("Book ISBN        Book Title       Category       Number of Books");
            System.out.println(bookList.get(i).getIsbn() + "     " + " " + bookList.get(i).getTitle()
                    +"       " + "    " +bookList.get(i).getCategory() + "          " + "    " + bookList.get(i).getQuantity());

        }
    }

    public void issueBookToStudent() {
    }

    public void listBooksByUsn() {
    }
}
