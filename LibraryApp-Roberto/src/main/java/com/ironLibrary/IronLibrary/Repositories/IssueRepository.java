package com.ironLibrary.IronLibrary.Repositories;
import com.ironLibrary.IronLibrary.Models.Issue;
import com.ironLibrary.IronLibrary.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Integer> {

    Optional<Issue> findByIssueStudent(Student student);


}
