package ui;

import model.Book;
import model.Notes;

import java.util.Scanner;

public class BookEditor {
    private Book book;
    private Scanner input;

    public BookEditor() {
        book = new Book("", "", "");
        input = new Scanner(System.in);
    }

    public void createBook() {

        System.out.println("Enter the book title");
        String title = input.next();
        title = title + input.nextLine();
        book.setTitle(title);

        System.out.println("Enter the book author");
        String author = input.next();
        author = author + input.nextLine();
        book.setAuthor(author);

        System.out.println("Enter the book genre");
        String genre = input.next();
        genre = genre + input.nextLine();
        book.setGenre(genre);

        notesMenu();
    }

    public void notesMenu() {
        System.out.println("\nAdd notes?");
        System.out.println("\tfalse <- no");
        System.out.println("\ttrue <- yes");
        if (input.nextBoolean()) {
            addNotes();
        }
    }

    public void addNotes() {
        book.addNotes(null);
        NotesEditor notes = new NotesEditor();
        notes.createNote();
    }
}
