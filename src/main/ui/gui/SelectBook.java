package ui.gui;

import model.Book;
import model.Notes;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class SelectBook extends JFrame implements ActionListener {
    private Book book;
    private BookPanel bookPanel;
    private JPanel notesPanel;

    public SelectBook(BookPanel bookPanel, Book book) {
        this.bookPanel = bookPanel;
        this.book = book;
        initializeGraphics();
    }

    private void initializeGraphics() {
        setLayout(new BorderLayout());

        add(header(), BorderLayout.PAGE_START);
        add(content(), BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

    private JScrollPane content() {
        notesPanel = new JPanel();

        refreshNotes();

        return new JScrollPane(notesPanel);
    }

    public void refreshNotes() {
        notesPanel.removeAll();
        for (Notes n : book.getNotesList()) {
            NotesPanel notePanel = new NotesPanel(this, n);
            notesPanel.add(notePanel);
        }
        notesPanel.revalidate();
    }

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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("addNoteButton")) {
            new AddNotes(this);
        }
    }

    public Book getBook() {
        return book;
    }
}
