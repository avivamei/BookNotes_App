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

    //EFFECTS: returns a list of notes in the book
    public List<Notes> getNotesList() {
        return notesList;
    }

    //REQUIRES: note must not already be in bookshelf
    //MODIFIES: this
    //EFFECTS: adds a note to book
    public void addNotes(Notes notes) {
        this.notesList.add(notes);
    }

    //MODIFIES: this
    //EFFECTS: if there exists is a note with the inputted heading in the book,
    // remove the note and return true, otherwise return false
    public boolean removeNotes(String heading) {
        for (Notes note : notesList) {
            if (note.getHeading().equals(heading)) {
                notesList.remove(note);
                return true;
            }
        }
        return false;
    }

    //MODIFIES: this
    //EFFECTS: if there exists a note with the inputted heading in the book,
    // return the note, otherwise return null
    public Notes selectNote(String heading) {
        for (Notes note : notesList) {
            if (note.getHeading().equals(heading)) {
                return note;
            }
        }
        return null;
    }
}
