package ui.gui;

import model.Notes;

import javax.swing.*;
import java.awt.*;

public class NotesPanel extends JPanel {
    private Notes notes;
    private SelectBook selectedBook;

    public NotesPanel(SelectBook selectedBook, Notes notes) {
        this.selectedBook = selectedBook;
        this.notes = notes;
        initializeGraphics();
    }

    // MODIFIES: this
    // EFFECTS: adds heading and notes labels to panel
    private void initializeGraphics() {
        setLayout(new GridLayout(2, 1));
        JLabel heading = new JLabel(notes.getHeading());
        JLabel note = new JLabel(notes.getNotes());
        add(heading, BorderLayout.PAGE_START);
        add(note, BorderLayout.PAGE_END);
    }
}
