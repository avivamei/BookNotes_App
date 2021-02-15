package ui;

import model.Book;
import model.Bookshelf;
import model.Notes;

import java.util.Scanner;

// Represents a bookshelf application
// Parts of code from TellerApp was used
public class BookshelfEditor {
    private Bookshelf bookShelf;
    private Scanner input;

    //EFFECTS: runs the bookshelf app
    public BookshelfEditor() {
        runBookshelf();
    }

    //MODIFIES: this
    //EFFECTS: processes user input
    public void runBookshelf() {
        boolean keepGoing = true;
        String command = null;

        bookShelf = new Bookshelf();
        input = new Scanner(System.in);

        while (keepGoing) {
            bookshelfMenu();
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

    //EFFECTS: displays options to users
    public void bookshelfMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta = add a book");
        System.out.println("\tr = remove a book");
        System.out.println("\ts = select a book");
        System.out.println("\tq = quit");
    }

    //MODIFIES: this
    //EFFECTS: processes user command
    public void processCommand(String command) {
        switch (command) {
            case "a":
                addBook();
                break;
            case "r":
                removeBook();
                break;
            case "s":
                selectBook();
                break;
            default:
                System.out.println("Selection not valid");
                break;
        }
    }

    //REQUIRES: book must not already exist in bookshelf
    //MODIFIES: this
    //EFFECTS: adds a book to bookshelf
    public void addBook() {
        input = new Scanner(System.in);

        System.out.println("Enter the book title");
        String title = input.next();
        title = title + input.nextLine();

        System.out.println("Enter the book author");
        String author = input.next();
        author = author + input.nextLine();

        System.out.println("Enter the book genre");
        String genre = input.next();
        genre = genre + input.nextLine();

        Book b = new Book(title, author, genre);

        bookShelf.addBook(b);
    }

    //MODIFIES: this
    //EFFECTS: removes a book from list of books
    private void removeBook() {
        input = new Scanner(System.in);

        System.out.println("Enter the book title");
        String title = input.nextLine();

        bookShelf.removeBook(title);
    }

    //REQUIRES: book must already exist in bookshelf
    //MODIFIES: this
    //EFFECTS: selects a book to add notes to or remove notes from
    private void selectBook() {
        input = new Scanner(System.in);

        System.out.println("Enter the book title");
        String title = input.next();
        title = title + input.nextLine();

        Book selectedBook = bookShelf.selectBook(title);

        notesMenu(selectedBook);

    }

    //MODIFIES: this
    //EFFECTS: processes whether or not the user wants to add or remove notes from selected book
    public void notesMenu(Book selectedBook) {
        input = new Scanner(System.in);

        System.out.println("\nSelect from:");
        System.out.println("\ta = add notes");
        System.out.println("\tr = remove notes");
        System.out.println("\tb = go back");

        if (input.next().equals("a")) {
            addNotes(selectedBook);
        } else if (input.next().equals("r")) {
            removeNotes(selectedBook);
        }
    }

    //MODIFIES: this
    //EFFECTS: removes note from selected book
    private void removeNotes(Book selectedBook) {
        input = new Scanner(System.in);

        System.out.println("Enter notes heading");
        String heading = input.nextLine();

        selectedBook.removeNotes(heading);
    }

    //MODIFIES: this
    //EFFECTS: adds note to selected book
    public void addNotes(Book selectedBook) {
        input = new Scanner(System.in);

        System.out.println("Enter the heading");
        String heading = input.nextLine();
        System.out.println("Enter the notes");
        String notes = input.nextLine();

        Notes n = new Notes(heading, notes);
        selectedBook.addNotes(n);
    }

}
