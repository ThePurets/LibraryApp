package com.ironLibrary.IronLibrary.Repositories;
import com.ironLibrary.IronLibrary.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    Optional<Author> findByName(String name);
}
