package com.sampaio.bookstore.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "Campo Nao pode ser nulo")
    @Column(length = 100, unique = true)
    private String name;
   
    @NotNull(message = "Campo Nao pode ser nulo")
    private Integer pages;
   
    @NotNull(message = "Campo Nao pode ser nulo")
    private Integer chapters;
    
    @NotNull(message = "Campo Nao pode ser nulo")
    @Column(length = 20 )
    private String isbn;
    
    @NotNull(message = "Campo Nao pode ser nulo")
    @Column(length = 100, unique = true, name = "publisher_name")
    private String publishName;

    @ManyToOne( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST , CascadeType.MERGE, CascadeType.REMOVE })
    @JoinColumn(name="author_id")
    private Author author;




}
