package ui;

import model.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookPopUp extends JPanel implements ActionListener {
    private GUI gui;
    private JTextField title;
    private JTextField author;
    private JTextField genre;

    public AddBookPopUp(GUI gui) {
        this.gui = gui;
        initializeGraphics();
    }

    private void initializeGraphics() {
        setLayout(new BorderLayout());

        add(new JLabel("New Book"), BorderLayout.PAGE_START);
        add(content(), BorderLayout.CENTER);
        add(options(), BorderLayout.PAGE_END);
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

    private JPanel options() {
        JPanel optionsPanel = new JPanel();

        JButton addBook = new JButton("Add Book");
        addBook.setActionCommand("addBookButton");
        addBook.addActionListener(this);

        JButton cancel = new JButton("Cancel");
        cancel.setActionCommand("cancelButton");
        cancel.addActionListener(this);

        optionsPanel.add(addBook);
        optionsPanel.add(cancel);

        return optionsPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("addBookButton")) {
            addBook();
        } else if (e.getActionCommand().equals("cancelButton")) {
            cancel();
        }
    }

    private void cancel() {

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
        }
    }
}
