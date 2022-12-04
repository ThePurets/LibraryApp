package com.ironLibrary.IronLibrary.Repositories;
import com.ironLibrary.IronLibrary.Models.Author;
import com.ironLibrary.IronLibrary.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    List<Book> findByAuthor(Author author);
    Optional<Book> findBookByTitle(String title);

    List<Book> findBookByCategory(String category);

    Optional<Book> findBookByAuthor(Author author);


}
