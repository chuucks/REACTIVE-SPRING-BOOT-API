package com.codesolt.springbootreactive.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Data
@Builder
@Table("books_available")
public class Book {

    @PrimaryKey
    @Column("id")
    private UUID id;

    @Column("book_code")
    private String bookCode;

    @Column("book_description")
    private String bookDescription;

    @Column("book_currency")
    private String bookCurrency;
}
