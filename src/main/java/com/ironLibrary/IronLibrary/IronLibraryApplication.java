package com.ironLibrary.IronLibrary;

import com.ironLibrary.IronLibrary.Menu.Menu;
import com.ironLibrary.IronLibrary.Models.Author;
import com.ironLibrary.IronLibrary.Models.Book;
import com.ironLibrary.IronLibrary.Models.Issue;
import com.ironLibrary.IronLibrary.Models.Student;
import com.ironLibrary.IronLibrary.Repositories.AuthorRepository;
import com.ironLibrary.IronLibrary.Repositories.BookRepository;
import com.ironLibrary.IronLibrary.Repositories.IssueRepository;
import com.ironLibrary.IronLibrary.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class IronLibraryApplication implements CommandLineRunner {

	@Autowired
	StudentRepository studentRepository;
	Student student;
	@Autowired
	BookRepository bookRepository;

	Book book1;
	Book book2;

	@Autowired
	AuthorRepository authorRepository;
	Author author1;
	Author author2;

	@Autowired
	IssueRepository issueRepository;
	Issue issue;

	public static void main(String[] args) throws IOException {
		SpringApplication.run(IronLibraryApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {


		studentRepository.saveAll(List.of(
				student = new Student("158746","Marcos Perez")
		));

		authorRepository.saveAll(List.of(
				author1 = new Author("Jack Kerouac","irob@ironlibrary.com"),
				author2 = new Author("Malcolm Lowry","irob@ironlibrary.com")

		));

		bookRepository.saveAll(List.of(
				book1 = new Book("0-7645-2641-3", "On The Road", "Novel", 12, author1),
				book2 = new Book("0-7645-2641-3", "Under the Volcano", "Novel", 12, author2)

		));

		issueRepository.saveAll(List.of(
				issue = new Issue("01/12/2022","08/12/2022", student, book1)
		));

		//Menu.menuStart(authorRepository, studentRepository, bookRepository,issueRepository);

		//habrá que añadir el resto de repsositorios

	}
}
