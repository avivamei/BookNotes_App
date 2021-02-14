package ui;

import model.Book;
import model.Bookshelf;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookshelfEditor {
    private Bookshelf bookShelf;
    private Scanner input;

    public BookshelfEditor() {
        runBookshelf();
    }

    public void runBookshelf() {
        boolean keepGoing = true;
        String command = null;

        initializeApp();

        while (keepGoing) {
            addOrRemoveBookMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("finished");
    }

    public void initializeApp() {
        bookShelf = new Bookshelf();
        input = new Scanner(System.in);
    }

    public void addOrRemoveBookMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> add a book");
        System.out.println("\tr -> remove a book");
        System.out.println("\tq -> quit");
    }

    public void processCommand(String command) {
        if (command.equals("a")) {
            addBook();
        } else if (command.equals("r")) {
            removeBook();
        } else if (command.equals("s")) {
            seeBookTitles();
        } else {
            System.out.println("Selection not valid");
        }
    }

    public void addBook() {
        bookShelf.addBook(null);
        BookEditor book = new BookEditor();
        book.createBook();
    }

    public void removeBook() {
        System.out.println("What is the title of the book you want to remove?");
        String selection = input.nextLine();
        bookShelf.removeBook(selection);
    }

    public void seeBookTitles() {
        bookShelf.getBookTitles();
    }

}
