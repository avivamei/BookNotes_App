package persistence;


import exceptions.StringTooShortException;
import model.Book;
import model.Bookshelf;
import model.Notes;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// modelled after JsonReader class in JsonSerializationDemo

// Represents a reader that reads bookshelf from JSON data stored in file
public class JsonReader {
    private String source;

    //EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    //EFFECTS: reads bookshelf from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Bookshelf read() throws IOException, StringTooShortException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseBookshelf(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses bookshelf from JSON object and returns it
    private Bookshelf parseBookshelf(JSONObject jsonObject) throws StringTooShortException {
        String name = jsonObject.getString("name");
        Bookshelf bookshelf = new Bookshelf(name);
        addBooks(bookshelf, jsonObject);
        return bookshelf;
    }

    // MODIFIES: bookshelf
    // EFFECTS: parses books from JSON object and adds them to bookshelf
    private void addBooks(Bookshelf bookshelf, JSONObject jsonObject) throws StringTooShortException {
        JSONArray jsonArray = jsonObject.getJSONArray("bookList");
        for (Object json : jsonArray) {
            JSONObject nextBook = (JSONObject) json;
            addBook(bookshelf, nextBook);
        }
    }

    // MODIFIES: bookshelf
    // EFFECTS: parses book from JSON object and adds it to bookshelf
    private void addBook(Bookshelf bookshelf, JSONObject jsonObject) throws StringTooShortException {
        String title = jsonObject.getString("title");
        String author = jsonObject.getString("author");
        String genre = jsonObject.getString("genre");
        Book book = new Book(title, author, genre);
        bookshelf.addBook(book);
        addNotes(book, jsonObject);
    }

    // MODIFIES: nextBook
    // EFFECTS: parses notes from JSON object and adds them to book
    private void addNotes(Book nextBook, JSONObject jsonObject) throws StringTooShortException {
        JSONArray jsonArray = jsonObject.getJSONArray("notes");
        for (Object json : jsonArray) {
            JSONObject nextNote = (JSONObject) json;
            addNote(nextBook, nextNote);
        }
    }

    // MODIFIES: nextBook
    // EFFECTS: parses note from JSON object and adds it to bookshelf
    private void addNote(Book nextBook, JSONObject jsonObject) throws StringTooShortException {
        String heading = jsonObject.getString("heading");
        String notes = jsonObject.getString("notes");
        Notes note = new Notes(heading, notes);
        nextBook.addNotes(note);
    }
}
