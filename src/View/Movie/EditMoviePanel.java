package View;

import javax.swing.*;
import java.awt.*;

public class EditMoviePanel extends JPanel {
    JTextField txt_get_Movie_idx;
    JButton getMovieBtn;
    JTextField txt_Movie_id;
    JTextField txt_Movie_name;
    JTextField txt_Movie_genre;
    JTextField txt_Movie_copiesSold;
    JTextField txt_Movie_language;
    JTextField txt_Movie_price;
    JButton editMovieBtn;

    public EditMoviePanel() {
        // Set layout to BoxLayout for vertical alignment
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // Set background color
        setBackground(new Color(240, 240, 240));

        txt_Movie_id = createStyledTextField("Movie ID");
        txt_Movie_name = createStyledTextField("Movie Name");
        txt_Movie_genre = createStyledTextField("Movie Genre");
        txt_Movie_copiesSold = createStyledTextField("Copies Sold");
        txt_Movie_language = createStyledTextField("Language");
        txt_Movie_price = createStyledTextField("Price");
        editMovieBtn = new JButton("Edit Movie");
        txt_get_Movie_idx = createStyledTextField("Enter Movie ID");
        getMovieBtn = new JButton("Get Movie to Edit");

        // Add components to the panel with vertical spacing
        add(Box.createVerticalStrut(10));
        add(txt_get_Movie_idx);
        add(Box.createVerticalStrut(10));
        add(getMovieBtn);
        add(Box.createVerticalStrut(10));
        add(txt_Movie_id);
        add(Box.createVerticalStrut(10));
        add(txt_Movie_name);
        add(Box.createVerticalStrut(10));
        add(txt_Movie_genre);
        add(Box.createVerticalStrut(10));
        add(txt_Movie_copiesSold);
        add(Box.createVerticalStrut(10));
        add(txt_Movie_language);
        add(Box.createVerticalStrut(10));
        add(txt_Movie_price);
        add(Box.createVerticalStrut(20));
        add(editMovieBtn);
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

    public JButton getEditMovieBtn() {
        return editMovieBtn;
    }

    public JButton getGetMovieBtn() {
        return getMovieBtn;
    }

    public JTextField getTxt_Movie_copiesSold() {
        return txt_Movie_copiesSold;
    }

    public JTextField getTxt_Movie_genre() {
        return txt_Movie_genre;
    }

    public JTextField getTxt_Movie_id() {
        return txt_Movie_id;
    }

    public JTextField getTxt_Movie_language() {
        return txt_Movie_language;
    }

    public JTextField getTxt_Movie_name() {
        return txt_Movie_name;
    }

    public JTextField getTxt_Movie_price() {
        return txt_Movie_price;
    }

    public JTextField getTxt_get_Movie_idx() {
        return txt_get_Movie_idx;
    }

    public void setEditMovieBtn(JButton editMovieBtn) {
        this.editMovieBtn = editMovieBtn;
    }

    public void setGetMovieBtn(JButton getMovieBtn) {
        this.getMovieBtn = getMovieBtn;
    }

    public void setTxt_Movie_copiesSold(JTextField txt_Movie_copiesSold) {
        this.txt_Movie_copiesSold = txt_Movie_copiesSold;
    }

    public void setTxt_Movie_genre(JTextField txt_Movie_genre) {
        this.txt_Movie_genre = txt_Movie_genre;

    }
}