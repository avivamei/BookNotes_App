package model;

import exceptions.StringTooShortException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class NotesTest {
    private Notes testNotes;

    @BeforeEach
    public void setUp() throws StringTooShortException {
        testNotes = new Notes("heading", "notes");
    }

    @Test
    public void testConstructor() {
        assertEquals("heading", testNotes.getHeading());
        assertEquals("notes", testNotes.getNotes());
    }

    @Test
    public void testSetHeading() throws StringTooShortException {
        testNotes.setHeading("new heading");
        assertEquals("new heading", testNotes.getHeading());
    }

    @Test
    public void testSetNotes() throws StringTooShortException {
        testNotes.setNotes("new notes");
        assertEquals("new notes", testNotes.getNotes());
    }
}
