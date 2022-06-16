package com.bookportal.app.entity;

import javax.persistence.*;

@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sl_no")
    private Long slNo;

    @Column(name="name")
    private String name;

    @Column(name="author")
    private String author;

    public Book() {
    }

    public Book(Long slNo, String name, String author) {
        this.slNo = slNo;
        this.name = name;
        this.author = author;
    }

    public Long getSlNo() {
        return slNo;
    }

    public void setSlNo(Long slNo) {
        this.slNo = slNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
