package com.ironLibrary.IronLibrary.Models;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorId;

    private String name;

    private String email;

    @OneToMany(mappedBy = "author")
    private List<Book> authorBook;

    public Author() {
    }

    public Author(String name, String email, List<Book> authorBook) {
        this.name = name;
        this.email = email;
        this.authorBook = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(authorId, author.authorId) && Objects.equals(name, author.name) && Objects.equals(email, author.email) && Objects.equals(authorBook, author.authorBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, name, email, authorBook);
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", authorBook=" + authorBook +
                '}';
    }
}
