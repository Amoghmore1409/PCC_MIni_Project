package View;

import javax.swing.*;
import java.awt.*;

public class EditCastPanel extends JPanel {
    JTextField txt_get_Cast_idx;
    JButton getCastBtn;
    JTextField txt_actor_id;
    JTextField txt_movie_id;
    JTextField txt_casting_date;
    JTextField txt_director;
    JButton editCastBtn;

    public EditCastPanel() {
        // Set layout to BoxLayout for vertical alignment
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // Set background color
        setBackground(new Color(240, 240, 240));

        txt_actor_id = createStyledTextField("Actor ID");
        txt_movie_id = createStyledTextField("Movie ID");
        txt_casting_date = createStyledTextField("Casting Date");
        txt_director = createStyledTextField("Director");
        editCastBtn = new JButton("Edit Casting");
        txt_get_Cast_idx = createStyledTextField("Enter Casting ID");
        getCastBtn = new JButton("Get Cast to Edit");

        // Disable editing for actor ID and movie ID text fields
        txt_actor_id.setEditable(false);
        txt_movie_id.setEditable(false);

        // Add components to the panel with vertical spacing
        add(Box.createVerticalStrut(10));
        add(txt_get_Cast_idx);
        add(Box.createVerticalStrut(10));
        add(getCastBtn);
        add(Box.createVerticalStrut(10));
        add(txt_actor_id);
        add(Box.createVerticalStrut(10));
        add(txt_casting_date);
        add(Box.createVerticalStrut(10));
        add(txt_movie_id);
        add(Box.createVerticalStrut(10));
        add(txt_director);
        add(Box.createVerticalStrut(20));
        add(editCastBtn);
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

    public JTextField getTxt_get_Cast_idx() {
        return txt_get_Cast_idx;
    }

    public JTextField getTxt_actor_id() {
        return txt_actor_id;
    }

    public JTextField getTxt_director() {
        return txt_director;
    }

    public JButton getEditCastBtn() {
        return editCastBtn;
    }

    public JButton getGetCastBtn() {
        return getCastBtn;
    }

    public JTextField getTxt_movie_id() {
        return txt_movie_id;
    }

    public JTextField getTxt_casting_date() {
        return txt_casting_date;
    }

    public void setTxt_actor_id(JTextField txt_actor_id) {
        this.txt_actor_id = txt_actor_id;
    }

    public void setGetCastBtn(JButton getCastBtn) {
        this.getCastBtn = getCastBtn;
    }

    public void setTxt_director(JTextField txt_director) {
        this.txt_director = txt_director;
    }

    public void setTxt_get_Cast_idx(JTextField txt_get_Cast_idx) {
        this.txt_get_Cast_idx = txt_get_Cast_idx;
    }

    public void setEditCastBtn(JButton editCastBtn) {
        this.editCastBtn = editCastBtn;
    }

    public void setTxt_movie_id(JTextField txt_movie_id) {
        this.txt_movie_id = txt_movie_id;
    }

    public void setTxt_casting_date(JTextField txt_casting_date) {
        this.txt_casting_date = txt_casting_date;
    }
}
