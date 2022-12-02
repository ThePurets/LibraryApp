package com.ironLibrary.IronLibrary.Repositories;
import com.ironLibrary.IronLibrary.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

    @Query(value = "SELECT student.name, issue.return_date, book.title FROM student INNER JOIN issue ON issue.issue_student_usn = student.usn INNER JOIN book ON issue.issue_book_isbn = book.isbn WHERE student.usn = :usn", nativeQuery = true)
    List<String> funcionJoin(String usn);
}