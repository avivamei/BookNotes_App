package ui.gui;

import model.Notes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotesPanel extends JPanel {
    private Notes notes;
    private SelectBook selectedBook;

    public NotesPanel(SelectBook selectedBook, Notes notes) {
        this.selectedBook = selectedBook;
        this.notes = notes;
        initializeGraphics();
    }

    private void initializeGraphics() {
        JLabel heading = new JLabel(notes.getHeading());
        JLabel note = new JLabel(notes.getNotes());
        add(heading, BorderLayout.PAGE_START);
        add(note, BorderLayout.PAGE_END);

    }
}
