package ui.gui;

import exceptions.StringTooShortException;
import model.Notes;

import javax.swing.*;
import java.awt.*;

public class AddNotes extends JPanel {
    private SelectBook selectedBook;
    private JTextField heading;
    private JTextField notes;
    private ImageIcon icon = createImageIcon("images/pencil.png");


    public AddNotes(SelectBook selectedBook) {
        this.selectedBook = selectedBook;
        initializeGraphics();
    }

    // MODIFIES: this
    // EFFECTS: adds note label and content panel
    private void initializeGraphics() {
        setLayout(new BorderLayout());

        add(new JLabel("New Note"), BorderLayout.PAGE_START);
        add(content(), BorderLayout.CENTER);
    }

    // EFFECTS: creates content panel with heading and note labels and text fields
    private JPanel content() {
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(2, 2));

        JLabel headingLabel = new JLabel("Heading: ");
        JLabel notesLabel = new JLabel("Note: ");

        heading = new JTextField();
        notes = new JTextField();

        contentPanel.add(headingLabel);
        contentPanel.add(heading);
        contentPanel.add(notesLabel);
        contentPanel.add(notes);

        addNote(heading, notes, contentPanel);

        return contentPanel;
    }

    // MODIFIES: this
    // EFFECTS: adds note with specified heading and notes
    private void addNote(JTextField heading, JTextField notes, JPanel contentPanel) {
        int input = JOptionPane.showOptionDialog(null, contentPanel, "New Book",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, icon, null, null);
        String newHeading = heading.getText();
        String newNotes = notes.getText();
        if (input == JOptionPane.OK_OPTION) {
            try {
                Notes note = null;
                note = new Notes(newHeading, newNotes);
                selectedBook.getBook().addNotes(note);
                selectedBook.refreshNotes();
            } catch (StringTooShortException e) {
                new AddNotes(selectedBook);
            }
        }
    }

    // EFFECTS: return ImageIcon of specified path
    private ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = AddBook.class.getResource(path);
        ImageIcon icon = new ImageIcon(imgURL);
        Image scaleImage = icon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        return new ImageIcon(scaleImage);
    }
}
