package com.ironLibrary.IronLibrary.Repositories;
import com.ironLibrary.IronLibrary.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
}