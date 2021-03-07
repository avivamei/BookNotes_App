package persistence;

import model.Bookshelf;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest{

    @Test
    public void testWriterInvalidFile() {
        try {
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriteEmptyBookshelf() {
        try{
            Bookshelf emptyBookshelf = new Bookshelf("Empty");
            JsonWriter writer = new JsonWriter("./data/testWriteEmptyBookshelf.json");
            writer.open();
            writer.write(emptyBookshelf);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriteEmptyBookshelf.json");
            emptyBookshelf = reader.read();
            assertEquals("Empty", emptyBookshelf.getName());
            assertEquals(0, emptyBookshelf.getBookList().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralBookshelf() {
        try {
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralBookshelf.json");
            writer.open();
            writer.write(bookshelf);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralBookshelf.json");
            Bookshelf actualBookshelf = reader.read();
            assertEquals(bookshelf.getName(), bookshelf.getName());
            checkBooks(bookshelf.getBookList(), actualBookshelf.getBookList());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
