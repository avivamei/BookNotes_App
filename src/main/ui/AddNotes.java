package ui;

import model.Notes;

import javax.swing.*;
import java.awt.*;

public class AddNotes extends JPanel {
    private BookPanel bookPanel;
    private JTextField heading;
    private JTextField notes;

    public AddNotes(BookPanel bookPanel) {
        this.bookPanel = bookPanel;
        initializeGraphics();
    }

    private void initializeGraphics() {
        setLayout(new BorderLayout());

        add(new JLabel("New Note"), BorderLayout.PAGE_START);
        add(content(), BorderLayout.CENTER);
    }

    private JPanel content() {
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(3, 2));

        JLabel headingLabel = new JLabel("Heading: ");
        JLabel notesLabel = new JLabel("Note: ");

        heading = new JTextField();
        notes = new JTextField();

        contentPanel.add(headingLabel);
        contentPanel.add(heading);
        contentPanel.add(notesLabel);
        contentPanel.add(notes);

        addBook(heading, notes, contentPanel);

        return contentPanel;
    }

    private void addBook(JTextField title, JTextField author, JPanel contentPanel) {
        int input = JOptionPane.showOptionDialog(null, contentPanel, "New Book",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        String newHeading = title.getText();
        String newNotes = author.getText();
        if (input == JOptionPane.OK_OPTION) {
            Notes note = new Notes(newHeading, newNotes);
       //     bookPanel.getNotes().addBook(note);
     //       bookPanel.refreshContent(gui.getContentPanel());
        }
    }
}
