package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private Book testBook;

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
        assertTrue(testBook.getNotesList().isEmpty());

        Notes note = new Notes("heading", "notes");
        testBook.addNotes(note);

        assertFalse(testBook.getNotesList().isEmpty());
        assertEquals("heading", note.getHeading());
        assertEquals("notes", note.getNotes());
    }

    @Test
    public void testRemoveNotesEmpty() {
        assertFalse(testBook.removeNotes("heading"));
    }

    @Test
    public void testRemoveBookNotEmpty() {
        testBook.addNotes(new Notes("heading 1", "notes 1"));
        testBook.addNotes(new Notes("heading 2", "notes 2"));

        assertFalse(testBook.removeNotes("heading 3"));

        assertTrue(testBook.removeNotes("heading 1"));
        assertEquals(1, testBook.getNotesList().size());

        assertTrue(testBook.removeNotes("heading 2"));
        assertTrue(testBook.getNotesList().isEmpty());
    }

    @Test
    public void testSelectCategoryEmpty() {
        assertNull(testBook.selectNote("heading"));
    }

    @Test
    public void testSelectCategoryNotEmpty() {
        Notes note1 = new Notes("heading 1", "notes 1");
        Notes note2 = new Notes("heading 2", "notes 2");
        testBook.addNotes(note1);
        testBook.addNotes(note2);

        assertEquals(note1, testBook.selectNote("heading 1"));
        assertEquals(note2, testBook.selectNote("heading 2"));
    }
}