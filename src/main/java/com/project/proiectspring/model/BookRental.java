package com.project.proiectspring.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table
public class BookRental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Temporal(TemporalType.DATE)
    private Date rentingDate;

    @Temporal(TemporalType.DATE)
    private Date dueDate;

    public BookRental() {
    }

    public BookRental(User user, Book book, Date rentingDate, Date dueDate) {
        this.user = user;
        this.book = book;
        this.rentingDate = rentingDate;
        this.dueDate = dueDate;
    }

    public BookRental(long id, User user, Book book, Date rentingDate, Date dueDate) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.rentingDate = rentingDate;
        this.dueDate = dueDate;
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getRentingDate() {
        return rentingDate;
    }

    public void setRentingDate(Date rentingDate) {
        this.rentingDate = rentingDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
