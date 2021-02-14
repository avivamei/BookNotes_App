package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class BookshelfTest {
    private Bookshelf bookshelf;

    @BeforeEach
    public void setUp() {
        bookshelf = new Bookshelf();
    }

    @Test
    public void testConstructor() {
        assertTrue(bookshelf == null);
    }

}
