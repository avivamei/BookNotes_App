package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookshelfTest {
    private Bookshelf testBookshelf;

    public Book createBook(String title, String author, String genre) {
        return new Book(title, author, genre);
    }

    @BeforeEach
    public void setUp() {
        testBookshelf = new Bookshelf();
    }

    @Test
    public void testConstructor() {
        assertEquals(0, testBookshelf.getBookList().size());
    }

    @Test
    public void testAddBook() {
        assertTrue(testBookshelf.getBookList().isEmpty());

        testBookshelf.addBook(new Book("title 1", "author 1", "genre 1"));
        assertFalse(testBookshelf.getBookList().isEmpty());
        assertEquals(1, testBookshelf.getBookList().size());

        testBookshelf.addBook(new Book("title 2", "author 2", "genre 2"));
        assertFalse(testBookshelf.getBookList().isEmpty());
        assertEquals(2, testBookshelf.getBookList().size());
    }

    @Test
    public void testRemoveBookEmpty() {
        assertFalse(testBookshelf.removeBook("title"));
    }

    @Test
    public void testRemoveBookNotEmpty() {
        testBookshelf.addBook(new Book("title 1", "author 1", "genre 1"));
        testBookshelf.addBook(new Book("title 2", "author 2", "genre 2"));

        assertFalse(testBookshelf.removeBook("title 3"));

        assertTrue(testBookshelf.removeBook("title 1"));
        assertEquals(1, testBookshelf.getBookList().size());

        assertTrue(testBookshelf.removeBook("title 2"));
        assertTrue(testBookshelf.getBookList().isEmpty());
    }

    @Test
    public void testSelectCategoryEmpty() {
        assertNull(testBookshelf.selectBook("title"));
    }

    @Test
    public void testSelectCategoryNotEmpty() {
        Book book1 = new Book("title 1", "author 1", "genre 1");
        Book book2 = new Book("title 2", "author 2", "genre 2");
        testBookshelf.addBook(book1);
        testBookshelf.addBook(book2);

        assertEquals(book1, testBookshelf.selectBook("title 1"));
        assertEquals(book2, testBookshelf.selectBook("title 2"));
    }
}
