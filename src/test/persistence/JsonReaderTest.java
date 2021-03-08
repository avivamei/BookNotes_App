package persistence;

import model.Book;
import model.Bookshelf;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest extends JsonTest{

    @Test
    public void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Bookshelf bookshelf = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    public void testReaderEmptyBookshelf() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyBookshelf.json");
        try {
            Bookshelf emptyBookshelf = reader.read();
            assertEquals("", emptyBookshelf.getName());
            assertEquals(0, emptyBookshelf.getBookList().size());
        } catch (IOException exception) {
            fail("Couldn't read from file");
        }

    }

    @Test
    public void testReaderGeneralBookshelf() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralBookshelf.json");
        try {
            Bookshelf actualBookshelf = reader.read();
            assertEquals(bookshelf.getName(), actualBookshelf.getName());
            checkBooks(bookshelf.getBookList(), actualBookshelf.getBookList());
        } catch (IOException exception) {
            fail("Couldn't read from file");
        }
    }
}
