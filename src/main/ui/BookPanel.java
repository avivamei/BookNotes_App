package ui;

import model.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BookPanel extends JPanel implements ActionListener {
    private Book book;
    private GUI gui;

    public BookPanel(Book book, GUI gui) {
        this.book = book;
        this.gui = gui;
        initializeGraphics();
    }

    private void initializeGraphics() {
        JLabel bookTitle = new JLabel(book.getTitle());
        add(bookTitle, BorderLayout.LINE_START);

        JPanel bookContent = setUpContent();
        add(bookContent, BorderLayout.CENTER);

        JPanel bookOptions = setUpOptions();
        add(bookOptions, BorderLayout.LINE_END);

    }

    private JPanel setUpOptions() {
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(2, 1));

        JButton selectBook = new JButton("Select");
        selectBook.setActionCommand("selectBookButton");
        selectBook.addActionListener(this);

        JButton removeBook = new JButton("Remove");
        removeBook.setActionCommand("removeBookButton");
        removeBook.addActionListener(this);

        optionsPanel.add(selectBook);
        optionsPanel.add(removeBook);
        return optionsPanel;
    }

    private JPanel setUpContent() {
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(2, 1));
        JLabel author = new JLabel("Author: " + book.getAuthor());
        JLabel genre = new JLabel("Genre: " + book.getGenre());
        contentPanel.add(author);
        contentPanel.add(genre);
        return contentPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
