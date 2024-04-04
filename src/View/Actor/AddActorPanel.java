package View;

import javax.swing.*;
import java.awt.*;

// Panel for adding a new author
public class AddActorPanel extends JPanel {

    // Text fields for entering author details
    private JTextField txt_id;
    private JTextField txt_name;
    private JTextField txt_genre;
    private JTextField txt_rating;
    private JTextField txt_language;
    // Button for adding the author
    private JButton addActorBtn;

    // Constructor
    public AddActorPanel() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        setBackground(new Color(240, 240, 240));

        txt_id = createStyledTextField("ID");
        txt_name = createStyledTextField("Name");
        txt_genre = createStyledTextField("Genre");
        txt_rating = createStyledTextField("Rating");
        txt_language = createStyledTextField("Language");
        addActorBtn = new JButton("Add Actor");
        addActorBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        addActorBtn.setBackground(new Color(50, 150, 250));
        addActorBtn.setForeground(Color.WHITE);
        addActorBtn.setFont(new Font("Arial", Font.BOLD, 14));
        addActorBtn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));


        add(Box.createVerticalStrut(20));
        add(txt_id);
        add(Box.createVerticalStrut(10));
        add(txt_name);
        add(Box.createVerticalStrut(10));
        add(txt_genre);
        add(Box.createVerticalStrut(10));
        add(txt_rating);
        add(Box.createVerticalStrut(10));
        add(txt_language);
        add(Box.createVerticalStrut(20));
        add(addActorBtn);
    }


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


    public JTextField getTxt_id() {
        return txt_id;
    }

    public JTextField getTxt_name() {
        return txt_name;
    }

    public JTextField getTxt_genre() {
        return txt_genre;
    }

    public JTextField getTxt_rating() {
        return txt_rating;
    }

    public JTextField getTxt_language() {
        return txt_language;
    }

    public JButton getAddActorBtn() {
        return addActorBtn;
    }
}
