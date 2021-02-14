package model;

import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.objects.Global.print;

// Represents a bookshelf with a list of books
public class Bookshelf {
    private List<Book> bookList;

    //EFFECTS: creates an empty list of books
    public Bookshelf() {
        bookList = new ArrayList<>();
    }

    public List<Book> getBookList() {
        return bookList;
    }

    //EFFECTS: adds a book to bookshelf
    public void addBook(Book book) {
        if (!containsBook(book)) {
            bookList.add(book);
        }
    }

    //EFFECTS: removes a book from bookshelf
    public void removeBook(String title) {
        bookList.removeIf(book -> book.containsTitle(title));
    }

    public void removeBook(int i) {
        bookList.remove(i);
    }

    //EFFECTS: gets book at position x from bookshelf
    public Book getBook(int x) {
        return bookList.get(x);
    }

    public Boolean containsBook(Book book) {
        return bookList.contains(book);
    }

    public void getBookTitles() {
        for (Book book : bookList) {
            String title = book.getTitle();
            print(title);
        }
    }

    //REQUIRES:
    //MODIFIES:
    //EFFECTS:
    public void updateBook(int x, String name, String author, String genre) {
        Book book = getBook(x);
        book.setTitle(name);
        book.setAuthor(author);
        book.setGenre(genre);
    }

}
