package ui.gui;

import model.Book;
import model.Notes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectBook extends JFrame implements ActionListener {
    private Book book;
    private BookPanel bookPanel;
    private JPanel notesPanel;

    public SelectBook(BookPanel bookPanel, Book book) {
        this.bookPanel = bookPanel;
        this.book = book;
        initializeGraphics();
    }

    // MODIFIES: this
    // EFFECTS: creates new Border Layout, adds header and content panels
    private void initializeGraphics() {
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(400, 500));

        add(header(), BorderLayout.PAGE_START);
        add(content(), BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

    // EFFECTS: creates new JScrollPane for Notes
    private JScrollPane content() {
        notesPanel = new JPanel();
        notesPanel.setLayout(new BoxLayout(notesPanel, BoxLayout.Y_AXIS));

        refreshNotes();

        return new JScrollPane(notesPanel);
    }

    // MODIFIES: this
    // EFFECTS: refreshes content panel to display changes
    public void refreshNotes() {
        notesPanel.removeAll();
        for (Notes n : book.getNotesList()) {
            NotesPanel notePanel = new NotesPanel(this, n);
            notesPanel.add(notePanel);
        }
        notesPanel.revalidate();
    }

    // EFFECTS: create panel with book title, author, genre, and add note button
    private JPanel header() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JLabel(book.getTitle()), BorderLayout.PAGE_START);
        panel.add(new JLabel("Author: " + book.getAuthor()), BorderLayout.LINE_START);
        panel.add(new JLabel("Genre: " + book.getGenre()), BorderLayout.LINE_END);

        JButton addBook = new JButton("Add Note");
        addBook.setActionCommand("addNoteButton");
        addBook.addActionListener(this);
        panel.add(addBook, BorderLayout.PAGE_END);

        return panel;
    }

    // MODIFIES: this
    // EFFECTS: creates new add notes pop up panel
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("addNoteButton")) {
            new AddNotes(this);
        }
    }

    // EFFECTS: gets book
    public Book getBook() {
        return book;
    }
}
