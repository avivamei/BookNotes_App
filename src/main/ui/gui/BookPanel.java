package ui.gui;

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

    // MODIFIES: this
    // EFFECTS: creates book title label, book content panel, book options panel
    private void initializeGraphics() {
        JLabel bookTitle = new JLabel(book.getTitle());
        add(bookTitle, BorderLayout.LINE_START);

        add(setUpContent(), BorderLayout.CENTER);

        add(setUpOptions(), BorderLayout.LINE_END);

    }

    // EFFECTS: sets up remove and select buttons
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

    // EFFECTS: sets up author and genre labels
    private JPanel setUpContent() {
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(2, 1));
        JLabel author = new JLabel("Author: " + book.getAuthor());
        JLabel genre = new JLabel("Genre: " + book.getGenre());
        contentPanel.add(author);
        contentPanel.add(genre);
        return contentPanel;
    }

    // MODIFIES: this
    // EFFECTS: if selectBookButton is pressed, creates new SelectBook;
    // if removeBookButton is pressed, delete book from bookshelf
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("selectBookButton")) {
            new SelectBook(this, this.book);
        } else if (e.getActionCommand().equals("removeBookButton")) {
            gui.getBookshelf().removeBook(book.getTitle());
            gui.refreshContent();
        }
    }
}
