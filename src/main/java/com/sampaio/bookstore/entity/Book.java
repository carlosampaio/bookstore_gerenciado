package com.sampaio.bookstore.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false, unique = true)
    private String name;
    @Column(nullable=false)
    private Integer pages;
    @Column(nullable=false)
    private Integer chapters;
    @Column(nullable=false)
    private String isbn;
    @Column(nullable=false, unique = true, name = "publisher_name")
    private String publishName;

    @ManyToOne( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST , CascadeType.MERGE, CascadeType.REMOVE })
    @JoinColumn(name="author_id")
    private Author author;




}
