package ui;

import model.Book;
import model.Bookshelf;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GUI extends JFrame implements ActionListener {
    private Bookshelf bookshelf;
    private JPanel contentPanel;

    public GUI() {
        super("Bookshelf");
        initializeGraphics();
    }

    public static void main(String[] args) {
        new GUI();
    }

    private void initializeGraphics() {
        bookshelf = new Bookshelf("Bookshelf");

        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(bookshelfHeaderPanel(), BorderLayout.PAGE_START);
        add(bookshelfContentPanel(), BorderLayout.CENTER);
        add(bookshelfFooterPanel(), BorderLayout.PAGE_END);

        pack();
        setVisible(true);
    }

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

    private JPanel bookshelfContentPanel() {
        contentPanel = new JPanel();

        refreshContent(contentPanel);

        return contentPanel;
    }

    public void refreshContent(JPanel contentPanel) {
        contentPanel.setLayout(new GridLayout(
                bookshelf.getBookList().size(), 1, 0, 30));
        for (Book b : bookshelf.getBookList()) {
            BookPanel bookPanel = new BookPanel(b, this);
            contentPanel.add(bookPanel);
        }
        contentPanel.setVisible(true);
    }

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
    //This is the method that is called when the the JButton btn is clicked
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("loadButton")) {
            JsonReader reader = new JsonReader("./data/bookshelf.json");
            try {
                bookshelf = reader.read();
                refreshContent(contentPanel);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        } else if (e.getActionCommand().equals("saveButton")) {
            JsonWriter writer = new JsonWriter("./data/bookshelf.json");
            try {
                writer.open();
            } catch (FileNotFoundException exception) {
                exception.printStackTrace();
            }
            writer.write(bookshelf);
            writer.close();
        } else if (e.getActionCommand().equals("addBookButton")) {
            new AddBookPopUp(this);
        }
    }

    public Bookshelf getBookshelf() {
        return bookshelf;
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }

}
