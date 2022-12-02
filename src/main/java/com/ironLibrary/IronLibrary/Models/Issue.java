package com.ironLibrary.IronLibrary.Models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer issueId;

    private String issueDate;

    private String returnDate;

    @OneToOne
    @JoinColumn(name = "issue_student_usn")
    private Student issueStudent;

    @OneToOne
    @JoinColumn(name = "issue_book_isbn")
    private Book issueBook;

    public Issue() {
    }

    public Issue(String issueDate, String returnDate, Student issueStudent, Book issueBook) {
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.issueStudent = issueStudent;
        this.issueBook = issueBook;
    }

    public Integer getIssueId() {
        return issueId;
    }

    public void setIssueId(Integer issueId) {
        this.issueId = issueId;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Student getIssueStudent() {
        return issueStudent;
    }

    public void setIssueStudent(Student issueStudent) {
        this.issueStudent = issueStudent;
    }

    public Book getIssueBook() {
        return issueBook;
    }

    public void setIssueBook(Book issueBook) {
        this.issueBook = issueBook;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Issue issue = (Issue) o;
        return Objects.equals(issueId, issue.issueId) && Objects.equals(issueDate, issue.issueDate) && Objects.equals(returnDate, issue.returnDate) && Objects.equals(issueStudent, issue.issueStudent) && Objects.equals(issueBook, issue.issueBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(issueId, issueDate, returnDate, issueStudent, issueBook);
    }

    @Override
    public String toString() {
        return "Issue{" +
                "issueId=" + issueId +
                ", issueDate='" + issueDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", issueStudent=" + issueStudent +
                ", issueBook=" + issueBook +
                '}';
    }
}
