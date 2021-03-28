package ui;

import model.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBook extends JPanel {
    private GUI gui;
    private JTextField title;
    private JTextField author;
    private JTextField genre;

    public AddBook(GUI gui) {
        this.gui = gui;
        initializeGraphics();
    }

    private void initializeGraphics() {
        setLayout(new BorderLayout());

        add(new JLabel("New Book"), BorderLayout.PAGE_START);
        add(content(), BorderLayout.CENTER);
    }

    private JPanel content() {
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(3, 2));

        JLabel titleLabel = new JLabel("Title: ");
        JLabel authorLabel = new JLabel("Author: ");
        JLabel genreLabel = new JLabel("Genre: ");

        title = new JTextField();
        author = new JTextField();
        genre = new JTextField();

        contentPanel.add(titleLabel);
        contentPanel.add(title);
        contentPanel.add(authorLabel);
        contentPanel.add(author);
        contentPanel.add(genreLabel);
        contentPanel.add(genre);

        addBook(title, author, genre, contentPanel);

        return contentPanel;
    }

    private void addBook(JTextField title, JTextField author, JTextField genre, JPanel contentPanel) {
        int input = JOptionPane.showOptionDialog(null, contentPanel, "New Book",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        String newTitle = title.getText();
        String newAuthor = author.getText();
        String newGenre = genre.getText();
        if (input == JOptionPane.OK_OPTION) {
            Book b = new Book(newTitle, newAuthor, newGenre);
            gui.getBookshelf().addBook(b);
            gui.refreshContent();
        }
    }
}
