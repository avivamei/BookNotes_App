package ui.gui;

import model.Book;
import model.Bookshelf;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

// Represents the Bookshelf panel
public class GUI extends JFrame implements ActionListener {
    private Bookshelf bookshelf;
    private JPanel contentPanel;

    // EFFECTS: creates a JFrame called "Bookshelf"
    public GUI() {
        super("Bookshelf");
        initializeGraphics();
    }

    public static void main(String[] args) {
        new GUI();
    }

    // MODIFIES: this
    // EFFECTS: initializes JFrame, adds header, content, and footer panels
    private void initializeGraphics() {
        bookshelf = new Bookshelf("Bookshelf");

        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(500, 600));

        add(bookshelfHeaderPanel(), BorderLayout.PAGE_START);
        add(bookshelfContentPanel(), BorderLayout.CENTER);
        add(bookshelfFooterPanel(), BorderLayout.PAGE_END);

        pack();
        setVisible(true);
    }

    // EFFECTS: creates header panel with Add Book button
    private JPanel bookshelfHeaderPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel name = new JLabel();
        name.setText(bookshelf.getName());
        panel.add(name, BorderLayout.PAGE_START);

        JButton addBook = new JButton("Add Book");
        addBook.setActionCommand("addBookButton");
        addBook.addActionListener(this);
        panel.add(addBook, BorderLayout.CENTER);

        return panel;
    }

    // EFFECTS: creates content panel with Books
    private JPanel bookshelfContentPanel() {
        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        refreshContent();

        return contentPanel;
    }

    // MODIFIES: this
    // EFFECTS: refreshes content panel to display changes
    public void refreshContent() {
        contentPanel.removeAll();
        for (Book b : bookshelf.getBookList()) {
            BookPanel bookPanel = new BookPanel(b, this);
            contentPanel.add(bookPanel);
        }
        contentPanel.revalidate();
    }

    // EFFECTS: creates footer panel with load and save buttons
    private JPanel bookshelfFooterPanel() {
        JPanel panel = new JPanel();

        JButton load = new JButton("Load");
        load.setActionCommand("loadButton");
        load.addActionListener(this);

        JButton save = new JButton("Save");
        save.setActionCommand("saveButton");
        save.addActionListener(this);

        panel.add(load);
        panel.add(save);

        return panel;
    }

    @Override
    // MODIFIES: this
    // EFFECTS: if loadButton is pressed, load previous bookshelf; if saveButton is pressed, save current bookshelf;
    // if addBookButton is pressed, create new add book panel
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("loadButton")) {
            JsonReader reader = new JsonReader("./data/bookshelf.json");
            try {
                beep();
                bookshelf = reader.read();
                refreshContent();
            } catch (Exception exception) {
                System.out.println("Unable to read file");
            }
        } else if (e.getActionCommand().equals("saveButton")) {
            JsonWriter writer = new JsonWriter("./data/bookshelf.json");
            try {
                beep();
                writer.open();
            } catch (FileNotFoundException exception) {
                exception.printStackTrace();
            }
            writer.write(bookshelf);
            writer.close();
        } else if (e.getActionCommand().equals("addBookButton")) {
            new AddBook(this);
        }
    }

    // EFFECTS: returns bookshelf
    public Bookshelf getBookshelf() {
        return bookshelf;
    }

    // EFFECTS: plays beep sound
    private void beep() {
        Toolkit.getDefaultToolkit().beep();
    }

}
