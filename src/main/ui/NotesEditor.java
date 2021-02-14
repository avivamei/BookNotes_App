package ui;

import model.Notes;

import java.util.Scanner;

public class NotesEditor {
    private Notes notes;
    private Scanner input;

    public NotesEditor() {
        notes = null;
        input = new Scanner(System.in);
    }

    public void createNote() {
        System.out.println("Enter the heading?");
        String heading = input.next();
        heading += input.nextLine();
        System.out.println("Enter the notes");
        String notes = input.next();
        notes += input.nextLine();

        this.notes = new Notes(heading, notes);
    }
}
