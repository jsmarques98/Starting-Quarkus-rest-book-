package org.jsmarques.quarkus.starting;


import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

    @ConfigProperty(name = "books.genre", defaultValue = "Sci-Fi")
    String genre;

    public List<Book> getAllBooks() {
        return List.of(
                new Book(1, "Understanding Quarkus", "João", 2024, genre),
                new Book(2, "Practising Quarkus", "João", 2024, genre),
                new Book(3, "Effective Java", "Josh Bloch", 2001, genre),
                new Book(4, "Thinking in Java", "Bruce Eckel", 1998, genre)
                );
    }

    public Optional<Book> getBook( int id) {
        return getAllBooks().stream().filter(book -> book.id == id).findFirst();
    }
}
