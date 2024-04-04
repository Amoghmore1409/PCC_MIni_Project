package View;

import javax.swing.*;
import java.awt.*;


public class EditActorPanel extends JPanel {


    private JTextField txt_get_Actor_idx;
    private JTextField txt_actor_id;
    private JTextField txt_actor_name;
    private JTextField txt_actor_genre;
    private JTextField txt_actor_rating;
    private JTextField txt_actor_language;

    private JButton getActorBtn;
    private JButton editActorBtn;


    public EditActorPanel() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        setBackground(new Color(240, 240, 240));


        txt_get_Actor_idx = createStyledTextField("Enter Actor ID");
        txt_actor_id = createStyledTextField("Actor ID");
        txt_actor_name = createStyledTextField("Actor Name");
        txt_actor_genre = createStyledTextField("Actor Genre");
        txt_actor_rating = createStyledTextField("Actor Rating");
        txt_actor_language = createStyledTextField("Actor Language");
        getActorBtn = new JButton("Get Actor to Edit");
        editActorBtn = new JButton("Edit Actor");
        editActorBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        editActorBtn.setBackground(new Color(50, 150, 250));
        editActorBtn.setForeground(Color.WHITE);
        editActorBtn.setFont(new Font("Arial", Font.BOLD, 14));
        editActorBtn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));


        add(Box.createVerticalStrut(10));
        add(txt_get_Actor_idx);
        add(Box.createVerticalStrut(10));
        add(getActorBtn);
        add(Box.createVerticalStrut(20));
        add(txt_actor_id);
        add(Box.createVerticalStrut(10));
        add(txt_actor_name);
        add(Box.createVerticalStrut(10));
        add(txt_actor_genre);
        add(Box.createVerticalStrut(10));
        add(txt_actor_rating);
        add(Box.createVerticalStrut(10));
        add(txt_actor_language);
        add(Box.createVerticalStrut(20));
        add(editActorBtn);
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

    public JTextField getTxt_get_Actor_idx() {
        return txt_get_Actor_idx;
    }

    public JTextField getTxt_actor_id() {
        return txt_actor_id;
    }

    public JTextField getTxt_actor_name() {
        return txt_actor_name;
    }

    public JTextField getTxt_actor_genre() {
        return txt_actor_genre;
    }

    public JTextField getTxt_actor_rating() {
        return txt_actor_rating;
    }

    public JTextField getTxt_actor_language() {
        return txt_actor_language;
    }

    public JButton getGetActorBtn() {
        return getActorBtn;
    }

    public JButton getEditActorBtn() {
        return editActorBtn;
    }
}
