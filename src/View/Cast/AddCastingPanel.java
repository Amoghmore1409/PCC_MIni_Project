package View;

import javax.swing.*;
import java.awt.*;

public class AddCastingPanel extends JPanel {
    JTextField txt_B;
    JTextField txt_A;
    JTextField txt_castingDate;
    JTextField txt_director;
    JButton addDirectorBtn;

    public AddCastingPanel() {
        // Set layout to BoxLayout for vertical alignment
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // Set background color
        setBackground(new Color(240, 240, 240));

        txt_B = createStyledTextField("Movie ID");
        txt_A = createStyledTextField("Actor ID");
        txt_castingDate = createStyledTextField("Casting Date");
        txt_director = createStyledTextField("Director");
        addDirectorBtn = new JButton("Add Casting");
        addDirectorBtn.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align button
        addDirectorBtn.setBackground(new Color(50, 150, 250)); // Blue background
        addDirectorBtn.setForeground(Color.WHITE); // White text
        addDirectorBtn.setFont(new Font("Arial", Font.BOLD, 14)); // Set font
        addDirectorBtn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Add padding

        // Add components to the panel with vertical spacing
        add(Box.createVerticalStrut(10));
        add(txt_B);
        add(Box.createVerticalStrut(10));
        add(txt_A);
        add(Box.createVerticalStrut(10));
        add(txt_castingDate);
        add(Box.createVerticalStrut(10));
        add(txt_director);
        add(Box.createVerticalStrut(20));
        add(addDirectorBtn);
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

    public JButton getAddDirectorBtn() {
        return addDirectorBtn;
    }

    public JTextField getTxt_A() {
        return txt_A;
    }

    public JTextField getTxt_B() {
        return txt_B;
    }

    public JTextField getTxt_castingDate() {
        return txt_castingDate;
    }

    public JTextField getTxt_director() {
        return txt_director;
    }

    public void setAddDirectorBtn(JButton addDirectorBtn) {
        this.addDirectorBtn = addDirectorBtn;
    }

    public void setTxt_A(JTextField txt_A) {
        this.txt_A = txt_A;
    }

    public void setTxt_B(JTextField txt_B) {
        this.txt_B = txt_B;
    }

    public void setTxt_castingDate(JTextField txt_castingDate) {
        this.txt_castingDate = txt_castingDate;
    }

    public void setTxt_director(JTextField txt_director) {
        this.txt_director = txt_director;
    }
}
