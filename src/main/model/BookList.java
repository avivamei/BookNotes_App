package model;

import java.util.ArrayList;
import java.util.List;

// Represents a bookshelf with a list of books
public class BookList {
    private List<Book> bookList;

    //EFFECTS: creates an empty list of books
    public BookList() {
        bookList = new ArrayList<>();
    }

    public List<Book> getBookList() {
        return bookList;
    }

    //EFFECTS: adds a book to bookshelf
    public void addBook(Book book) {
        bookList.add(book);
    }

    public void removeBook(Book book) {
        bookList.remove(book);
    }

    //EFFECTS: gets book at position x from bookshelf
    public Book getBook(int x) {
        return bookList.get(x);
    }

    //REQUIRES:
    //MODIFIES:
    //EFFECTS:
    public void updateBook(int x, String name, String author, String genre) {
        Book book = getBook(x);
        book.setName(name);
        book.setAuthor(author);
        book.setGenre(genre);
    }

}
