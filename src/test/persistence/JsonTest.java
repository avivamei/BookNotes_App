package persistence;

import model.Book;
import model.Bookshelf;
import model.Notes;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected Bookshelf bookshelf;

    protected Book book1;
    protected Notes summary;
    protected Notes quotes;

    protected Book book2;
    protected Notes characters;

    @BeforeEach
    public void setUp() {
        bookshelf = new Bookshelf("my bookshelf");

        book1 = new Book("book1", "author1", "genre1");
        summary = new Notes("summary", "notes1");
        quotes = new Notes("quotes", "notes2");
        book1.addNotes(summary);
        book1.addNotes(quotes);

        book2 = new Book("book2", "author2", "genre2");
        characters = new Notes("characters", "notes3");
        book2.addNotes(characters);

        bookshelf.addBook(book1);
        bookshelf.addBook(book2);
    }

    protected void checkBooks(List<Book> books, List<Book> actualBooks) {
        assertEquals(books.size(), actualBooks.size());
        for (Book book : books) {
            for (Book actualBook : actualBooks) {
                checkBook(book, actualBook);
            }
        }
    }

    protected void checkBook(Book book, Book actualBook) {
        assertEquals(book.getAuthor(), actualBook.getAuthor());
        assertEquals(book.getGenre(), actualBook.getGenre());
        checkNotes(book.getNotesList(), actualBook.getNotesList());
    }

    protected void checkNotes(List<Notes> notes, List<Notes> actualNotes) {
        assertEquals(notes.size(), actualNotes.size());
        for (Notes note : notes) {
            for (Notes actualNote : actualNotes) {
                checkNote(note, actualNote);
            }
        }
    }

    protected void checkNote(Notes note, Notes actualNote) {
        assertEquals(note.getHeading(), actualNote.getHeading());
        assertEquals(note.getNotes(), actualNote.getNotes());
    }
}
