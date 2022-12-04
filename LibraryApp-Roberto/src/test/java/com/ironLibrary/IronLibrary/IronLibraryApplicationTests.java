package com.ironLibrary.IronLibrary;

import com.ironLibrary.IronLibrary.Models.Author;
import com.ironLibrary.IronLibrary.Models.Book;
import com.ironLibrary.IronLibrary.Models.Issue;
import com.ironLibrary.IronLibrary.Models.Student;
import com.ironLibrary.IronLibrary.Repositories.AuthorRepository;
import com.ironLibrary.IronLibrary.Repositories.BookRepository;
import com.ironLibrary.IronLibrary.Repositories.IssueRepository;
import com.ironLibrary.IronLibrary.Repositories.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class IronLibraryApplicationTests {


    @Autowired
	AuthorRepository authorRepository;
	@Autowired
	BookRepository bookRepository;
	@Autowired
	IssueRepository issueRepository;
	@Autowired
	StudentRepository studentRepository;

	Author author;

	@BeforeEach
	void setUp(){

		Author author = new Author("Cervantes","cervantes@cervantes");
		Book book = new Book("3456-78-908", "Don Quijote", "Novela", 34,author);
		Student student = new Student("2345", "Alberto");
		Issue issue = new Issue("09/11/2022", "16/11/2022",student,book);

		authorRepository.save(author);
		bookRepository.save(book);
		studentRepository.save(student);
		issueRepository.save(issue);

	}


	@Test
	void shouldFindIssueByStudent_ok(){

		Student student1 = new Student("345", "Thomas");

		studentRepository.save(student1);

		Book book1 = new Book("234","Before","Poesía",34,author);

		bookRepository.save(book1);

		Issue issue1 = new Issue("09/02/2022", "16/02/2022", student1,book1);

		issueRepository.save(issue1);

		Issue issue2 = issueRepository.findByIssueStudent(student1).get();


		assertEquals("345",issue2.getIssueStudent().getUsn());
	}

	@Test
	void shouldFindAuthorByName_ok(){

		Author author2 = authorRepository.findByName("Cervantes").get();

		assertEquals("Cervantes",author2.getName());
	}

	@Test
	void shouldFindBookByTitle_ok(){

		Book book2 = bookRepository.findBookByTitle("Don Quijote").get();

		assertEquals("Don Quijote",book2.getTitle());
	}
	@Test
	void shouldFindBookByCategory_ok(){

		List<Book> bookList = (List<Book>) bookRepository.findBookByCategory("Novela");

		assertEquals("Novela",bookList.get(0).getCategory());
	}

	@Test
	void shouldFindBookByAuthor_ok(){

		Book book1 = new Book("234","Before","Poesía",34,author);

		bookRepository.save(book1);

		assertEquals(book1,bookRepository.findBookByAuthor(author).get());
	}







}
