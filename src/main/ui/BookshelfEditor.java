package ui;

import exceptions.StringTooShortException;
import model.Book;
import model.Bookshelf;
import model.Notes;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// Represents a bookshelf application
// Modelled parts of code from TellerApp in sample application
public class BookshelfEditor {
    private static final String JSON_STORE = "./data/bookshelf.json";
    private Bookshelf bookShelf;
    private Scanner input;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    //EFFECTS: runs the bookshelf app
    public BookshelfEditor() throws FileNotFoundException {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runBookshelf();
    }

    //MODIFIES: this
    //EFFECTS: processes user input
    public void runBookshelf() {
        boolean keepGoing = true;
        String command = null;

        System.out.print("Bookshelf Name: ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        bookShelf = new Bookshelf(name);

        input = new Scanner(System.in);

        while (keepGoing) {
            bookshelfMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processBookshelfCommand(command);
            }
        }

        System.out.println("finished");
    }

    //EFFECTS: displays options to perform on bookshelf to users
    public void bookshelfMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta = add a book");
        System.out.println("\tr = remove a book");
        System.out.println("\tc = choose a book");
        System.out.println("\tv = view all books");
        System.out.println("\ts = save to file");
        System.out.println("\tl = load from file");
        System.out.println("\tq = quit");
    }

    //MODIFIES: this
    //EFFECTS: processes user command to do with editing bookshelf
    public void processBookshelfCommand(String command) {
        switch (command) {
            case "a":
                addBook();
                break;
            case "r":
                removeBook();
                break;
            case "c":
                selectBook();
                break;
            case "v" :
                viewBooks();
                break;
            case "s" :
                saveBookshelf();
                break;
            case "l" :
                loadBookshelf();
                break;
            default:
                System.out.println("Selection not valid");
                break;
        }
    }

    //MODIFIES: this
    //EFFECTS: loads bookshelf from file
    private void loadBookshelf() {
        try {
            bookShelf = jsonReader.read();
            System.out.println("Loaded " + bookShelf.getName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    //EFFECTS: saves bookshelf to file
    private void saveBookshelf() {
        try {
            jsonWriter.open();
            jsonWriter.write(bookShelf);
            jsonWriter.close();
            System.out.println("Saved " + bookShelf.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    //MODIFIES: this
    //EFFECTS: shows user the book titles of the books in the bookshelf
    private void viewBooks() {
        for (Book book : bookShelf.getBookList()) {
            System.out.println(book.getTitle());
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
    //EFFECTS: displays options to perform on a book to users
    public void notesMenu(Book selectedBook) {
        input = new Scanner(System.in);

        System.out.println("\nSelect from:");
        System.out.println("\tv = view book details");
        System.out.println("\ta = add notes");
        System.out.println("\tr = remove notes");
        System.out.println("\tb = go back");

        String command = input.nextLine();

        processBookCommands(command, selectedBook);
    }

    //MODIFIES: this
    //EFFECTS: processes commands to do with books
    private void processBookCommands(String command, Book selectedBook) {
        switch (command) {
            case "v":
                viewBook(selectedBook);
                break;
            case "r":
                removeNotes(selectedBook);
                break;
            case "a":
                addNotes(selectedBook);
                break;
        }
    }

    //MODIFIES: this
    //EFFECTS: shows the user who is the author, what is the genre of the selected book,
    // and the heading of notes and notes content
    private void viewBook(Book selectedBook) {
        String title = selectedBook.getTitle();
        String genre = selectedBook.getGenre();
        System.out.println("The author is: " + title);
        System.out.println("The genre is: " + genre);
        for (Notes note : selectedBook.getNotesList()) {
            System.out.println(note.getHeading());
            System.out.println(note.getNotes());
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

        Notes n = null;
        try {
            n = new Notes(heading, notes);
        } catch (StringTooShortException e) {
            System.out.println("Heading and Notes must be non-zero in length");
        }
        selectedBook.addNotes(n);
    }

}
