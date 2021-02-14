package model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

// Represents a book that contains a list of notes taken about the book
public class Book {
    private String title;
    private String author;
    private String genre;
    private List<Notes> notesList;

    //REQUIRES: bookName has a non-zero length
    //EFFECTS: constructs a book with given title, author, and genre
    public Book(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        notesList = new ArrayList<>();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public void addNotes(Notes notes) {
        this.notesList.add(notes);
    }

    public void removeNotes(Notes notes) {
        this.notesList.remove(notes);
    }

    //EFFECTS: gets the notes at position x from bookshelf
    public Notes getNotes(int i) {
        return notesList.get(i);
    }

    public Boolean containsNote(Notes notes) {
        return notesList.contains(notes);
    }

    public void updateNotes(int i, String heading, String notes) {
        Notes note = getNotes(i);
        note.setHeading(heading);
        note.setNotes(notes);
    }

    public boolean containsTitle(String title) {
        return this.title.equals(title);
    }
}
