package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            bookstoreService.persistNewAuthor();
            bookstoreService.fetchAuthor();
        };
    }
}
/*
 * Quickest Mapping Of Java Enums

Description: This application uses EnumType.ORDINAL and EnumType.STRING for mapping Java enum type to database. As a rule of thumb, strive to keep the data types as small as possible (e.g., for EnumType.ORDINAL use TINYINT/SMALLINT, while for EnumType.STRING use VARCHAR(max_needed_bytes)). Relying on EnumType.ORDINAL should be more efficient but is less expressive than EnumType.STRING.

Key points:

strive for smallest data types (e.g., for EnumType.ORDINAL set @Column(columnDefinition = "TINYINT"))
 */
