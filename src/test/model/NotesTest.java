package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class NotesTest {
    private Notes testNotes;

    @BeforeEach
    public void setUp() {
        testNotes = new Notes("heading", "notes");
    }

    @Test
    public void testConstructor() {
        assertEquals("heading", testNotes.getHeading());
        assertEquals("notes", testNotes.getNotes());
    }

    @Test
    public void testSetHeading() {
        testNotes.setHeading("new heading");
        assertEquals("new heading", testNotes.getHeading());
    }

    @Test
    public void testSetNotes() {
        testNotes.setNotes("new notes");
        assertEquals("new notes", testNotes.getNotes());
    }
}
