package View;

import javax.swing.*;
import java.awt.*;

public class DeleteMoviePanel extends JPanel {
    JTextField txt_del_movie_id;
    JButton deleteMovieBtn;

    public DeleteMoviePanel() {
        // Set layout to BoxLayout for vertical alignment
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // Set background color
        setBackground(new Color(240, 240, 240));

        txt_del_movie_id = createStyledTextField("Movie ID");
        deleteMovieBtn = new JButton("Delete Movie");
        deleteMovieBtn.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align button
        deleteMovieBtn.setBackground(new Color(250, 100, 100)); // Red background
        deleteMovieBtn.setForeground(Color.WHITE); // White text
        deleteMovieBtn.setFont(new Font("Arial", Font.BOLD, 14)); // Set font
        deleteMovieBtn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Add padding

        // Add components to the panel with vertical spacing
        add(Box.createVerticalStrut(10));
        add(txt_del_movie_id);
        add(Box.createVerticalStrut(20));
        add(deleteMovieBtn);
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

    public void setDeleteMovieBtn(JButton deleteMovieBtn) {
        this.deleteMovieBtn = deleteMovieBtn;
    }

    public void setTxt_del_movie_id(JTextField txt_del_movie_id) {
        this.txt_del_movie_id = txt_del_movie_id;
    }

    public JButton getDeleteMovieBtn() {
        return deleteMovieBtn;
    }

    public JTextField getTxt_del_movie_id() {
        return txt_del_movie_id;
    }
}
