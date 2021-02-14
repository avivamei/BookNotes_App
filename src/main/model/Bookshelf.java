package model;

import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.objects.Global.print;

// Represents a bookshelf with a list of books
public class Bookshelf {
    private List<Book> bookList;

    //EFFECTS: constructs a bookshelf with an empty list of books
    public Bookshelf() {
        bookList = new ArrayList<>();
    }

    //EFFECTS: returns the list of books in the bookshelf
    public List<Book> getBookList() {
        return bookList;
    }

    //REQUIRES: book must not already be in bookshelf
    //MODIFIES: this
    //EFFECTS: adds a book to bookshelf
    public void addBook(Book book) {
        bookList.add(book);
    }

    //MODIFIES: this
    //EFFECTS: if there exists is a book with the inputted title in the bookshelf,
    // remove the book and return true, otherwise return false
    public boolean removeBook(String title) {
        for (Book book : bookList) {
            if (book.getTitle().equals(title)) {
                bookList.remove(book);
                return true;
            }
        }
        return false;
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
}
