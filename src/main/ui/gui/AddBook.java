package ui.gui;

import model.Book;

import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;

public class AddBook extends JPanel {
    private GUI gui;
    private JTextField title;
    private JTextField author;
    private JTextField genre;
    private ImageIcon icon = createImageIcon("images/book.png");

    public AddBook(GUI gui) {
        this.gui = gui;
        initializeGraphics();
    }

    // MODIFIES: this
    // EFFECTS: creates new Border Layout, adds label and content panel
    private void initializeGraphics() {
        setLayout(new BorderLayout());

        add(new JLabel("New Book"), BorderLayout.PAGE_START);
        add(content(), BorderLayout.CENTER);
    }

    // EFFECTS: creates panel with 3 labels and their corresponding text fields
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

    // MODIFIES: this
    // EFFECTS: adds book with specified title, author, genre
    private void addBook(JTextField title, JTextField author, JTextField genre, JPanel contentPanel) {
        int input = JOptionPane.showOptionDialog(null, contentPanel, "New Book",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, icon, null, null);
        String newTitle = title.getText();
        String newAuthor = author.getText();
        String newGenre = genre.getText();
        if (input == JOptionPane.OK_OPTION) {
            Book b = new Book(newTitle, newAuthor, newGenre);
            gui.getBookshelf().addBook(b);
            gui.refreshContent();
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
