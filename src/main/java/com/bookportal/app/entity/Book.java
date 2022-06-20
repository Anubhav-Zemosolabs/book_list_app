package com.bookportal.app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="book_id")
    private int bookId;

    @Column(name="name")
    private String name;

    @Column(name="author")
    private String author;

    @Column(name="price")
    private double price;

    @Column(name="description")
    private String description;

    @Column(name="rating")
    private double rating;

}
