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
    public void testSetHeading() {
        try {
            testNotes.setHeading("new heading");
        } catch (StringTooShortException e) {
            fail();
        }
        assertEquals("new heading", testNotes.getHeading());
    }

    @Test
    public void testSetNotes() {
        try {
            testNotes.setNotes("new notes");
        } catch (StringTooShortException e) {
            fail();
        }
        assertEquals("new notes", testNotes.getNotes());
    }

    @Test
    public void testSetHeadingStringLengthIsZero() {
        try {
            testNotes.setHeading("");
            fail();
        } catch (StringTooShortException e) {
        }
        assertEquals("heading", testNotes.getHeading());
    }

    @Test
    public void testSetNotesStringLengthIsZero() {
        try {
            testNotes.setNotes("");
            fail();
        } catch (StringTooShortException e) {
        }
        assertEquals("notes", testNotes.getNotes());
    }
}
