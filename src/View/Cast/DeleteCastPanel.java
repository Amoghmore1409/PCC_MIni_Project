package View;

import javax.swing.*;
import java.awt.*;

public class DeleteCastPanel extends JPanel {
    JTextField txt_del_Cast_idx;
    JButton deleteCastBtn;

    public DeleteCastPanel() {
        // Set layout to BoxLayout for vertical alignment
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // Set background color
        setBackground(new Color(240, 240, 240));

        txt_del_Cast_idx = createStyledTextField("Casting ID");
        deleteCastBtn = new JButton("Delete Casting");
        deleteCastBtn.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align button
        deleteCastBtn.setBackground(new Color(250, 100, 100)); // Red background
        deleteCastBtn.setForeground(Color.WHITE); // White text
        deleteCastBtn.setFont(new Font("Arial", Font.BOLD, 14)); // Set font
        deleteCastBtn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Add padding

        // Add components to the panel with vertical spacing
        add(Box.createVerticalStrut(10));
        add(txt_del_Cast_idx);
        add(Box.createVerticalStrut(20));
        add(deleteCastBtn);
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

    public JButton getDeleteCastBtn() {
        return deleteCastBtn;
    }

    public JTextField getTxt_del_Cast_idx() {
        return txt_del_Cast_idx;
    }

    public void setDeleteCastBtn(JButton deleteCastBtn) {
        this.deleteCastBtn = deleteCastBtn;
    }

    public void setTxt_del_Cast_idx(JTextField txt_del_Cast_idx) {
        this.txt_del_Cast_idx = txt_del_Cast_idx;
    }
}
