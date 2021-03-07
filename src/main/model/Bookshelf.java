package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// Represents a bookshelf with a list of books
public class Bookshelf implements Writable {
    private String name;
    private List<Book> bookList;

    //EFFECTS: constructs a bookshelf with an empty list of books
    public Bookshelf(String name) {
        this.name = name;
        bookList = new ArrayList<>();
    }

    //EFFECTS: returns the list of books in the bookshelf
    public List<Book> getBookList() {
        return bookList;
    }

    //EFFECTS: returns name of bookshelf
    public String getName() {
        return name;
    }

    //REQUIRES: book must not already be in bookshelf
    //MODIFIES: this
    //EFFECTS: adds a book to bookshelf
    public void addBook(Book book) {
        bookList.add(book);
    }

    //MODIFIES: this
    //EFFECTS: if there exists a book with the inputted title in the bookshelf,
    // return the book, otherwise return null
    public Book selectBook(String title) {
        for (Book book : bookList) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    //MODIFIES: this
    //EFFECTS: if there exists is a book with the inputted title in the bookshelf,
    // remove the book and return true, otherwise return false
    public boolean removeBook(String title) {
        return bookList.removeIf(book -> book.getTitle().equals(title));
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("bookList", categoriesToJson());
        return json;
    }

    // EFFECTS: returns books in this bookshelf as a JSON array
    private JSONArray categoriesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Book c : bookList) {
            jsonArray.put(c.toJson());
        }

        return jsonArray;
    }
}
