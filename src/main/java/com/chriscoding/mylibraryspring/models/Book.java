package com.chriscoding.mylibraryspring.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name= "book")
public class Book extends AbstractEntity{

    private String title;
    private String description;
    private String author;
    private String isbn;
    private int pubdate;
    private Librarian librarian;

    //private int bookid;
    private List<Book> books;

    public Book() {
    }

    public Book(String title, String description, String author, String isbn, int pubdate, Librarian librarian) {
        super();
        this.title = title;
        this.description = description;
        this.author = author;
        this.isbn = isbn;
        this.pubdate = pubdate;
        this.librarian = librarian;
        librarian.addBook(this);
    }

    @NotNull
    @Column(name="title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NotNull
    @Column(name= "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotNull
    @Column(name="author")
    public String getAuthor() {
        return author;
    }


    public void setAuthor(String author) {
        this.author = author;
    }

    @NotNull
    @Column(name= "isbn")
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @NotNull
    @Column(name="pubdate")
    public int getPubdate() {
        return pubdate;
    }

    public void setPubdate(int pubdate) {
        this.pubdate = pubdate;
    }


    /*@OneToMany
    @JoinColumn(name = "author_uid")
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

*/
}
