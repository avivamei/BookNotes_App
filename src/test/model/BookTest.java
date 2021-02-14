package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private Book testBook;
    private Notes note;

    @BeforeEach
    public void setUp() {
        testBook = new Book("title","author","genre");
    }

    @Test
    public void testSetTitle() {
        testBook.setTitle("new title");
        assertEquals("new title", testBook.getTitle());
    }

    @Test
    public void testSetAuthor() {
        testBook.setAuthor("new author");
        assertEquals("new author", testBook.getAuthor());
    }

    @Test
    public void testSetGenre() {
        testBook.setGenre("new genre");
        assertEquals("new genre", testBook.getGenre());
    }

    @Test
    public void testAddNotes() {
        note = new Notes("heading1", "notes1");
        testBook.addNotes(note);
        assertTrue(testBook.containsNote(note));
    }
}