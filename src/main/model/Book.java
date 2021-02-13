package model;

import java.util.List;

// Represents a book that contains a list of notes taken about the book
public class Book {
    private String name;
    private String author;
    private String genre;
    private Boolean isFiction;
    private List<NotesList> notes;

    //REQUIRES: bookName has a non-zero length
    //EFFECTS: constructs a book with given name, author, and genre
    public Book(String name, String author, String genre) {
        this.name = name;
        this.author = author;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
