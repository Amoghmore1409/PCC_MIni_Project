package View;

import javax.swing.*;
import java.awt.*;

public class AddMoviesPanel extends JPanel {
    JTextField txt_bid;
    JTextField txt_name;
    JTextField txt_genre;
    JTextField txt_price;
    JTextField txt_language;
    JTextField txt_sales;
    JButton addMovieBtn;

    public AddMoviesPanel() {
        // Set layout to BoxLayout for vertical alignment
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // Set background color
        setBackground(new Color(240, 240, 240));

        txt_bid= createStyledTextField("ID");
        txt_name = createStyledTextField("Name");
        txt_genre = createStyledTextField("Genre");
        txt_price = createStyledTextField("Production cost");
        txt_language = createStyledTextField("Language");
        txt_sales = createStyledTextField("Tickets Sold");
        addMovieBtn = new JButton("Add Movie");
        addMovieBtn.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align button
        addMovieBtn.setBackground(new Color(50, 150, 250)); // Blue background
        addMovieBtn.setForeground(Color.WHITE); // White text
        addMovieBtn.setFont(new Font("Arial", Font.BOLD, 14)); // Set font
        addMovieBtn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Add padding

        // Add components to the panel with vertical spacing
        add(Box.createVerticalStrut(10));
        add(txt_bid);
        add(Box.createVerticalStrut(10));
        add(txt_name);
        add(Box.createVerticalStrut(10));
        add(txt_genre);
        add(Box.createVerticalStrut(10));
        add(txt_price);
        add(Box.createVerticalStrut(10));
        add(txt_language);
        add(Box.createVerticalStrut(10));
        add(txt_sales);
        add(Box.createVerticalStrut(20));
        add(addMovieBtn);
    }

    // Method to create a styled text field
    private JTextField createStyledTextField(String placeholder) {
        JTextField textField = new JTextField(20);
        textField.setMaximumSize(new Dimension(250, 30));
        textField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(150, 150, 150)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        textField.setForeground(new Color(50, 50, 50));
        textField.setText(placeholder);
        textField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textField.selectAll();
            }
        });
        return textField;
    }

    public JTextField getTxt_bid() {
        return txt_bid;
    }

    public JTextField getTxt_name() {
        return txt_name;
    }

    public JTextField getTxt_genre() {
        return txt_genre;
    }

    public JTextField getTxt_price() {
        return txt_price;
    }

    public JTextField getTxt_language() {
        return txt_language;
    }

    public JTextField getTxt_sales() {
        return txt_sales;
    }

    public JButton getAddMovieBtnBtn() {
        return addMovieBtn;
    }
}
