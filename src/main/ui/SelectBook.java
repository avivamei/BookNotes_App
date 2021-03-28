package ui;

import model.Book;
import model.Notes;

import javax.swing.*;
import java.awt.*;

public class SelectBook extends JFrame {
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

        add(new JLabel(book.getTitle()), BorderLayout.PAGE_START);
        add(new JLabel(book.getTitle()), BorderLayout.PAGE_START);
        add(new JLabel(book.getTitle()), BorderLayout.PAGE_START);
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

    private void refreshNotes() {
        notesPanel.removeAll();
        for (Notes n : book.getNotesList()) {
            NotesPanel notePanel = new NotesPanel();
            notesPanel.add(notePanel);
        }
        notesPanel.revalidate();
    }

    private JPanel header() {
        JPanel panel = new JPanel();
        panel.add(new JLabel(book.getTitle()), BorderLayout.PAGE_START);
        panel.add(new JLabel("Author: " + book.getAuthor()), BorderLayout.CENTER);
        panel.add(new JLabel("Genre: " + book.getGenre()), BorderLayout.PAGE_END);
        return panel;
    }
}
