package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CentrePanelMovie extends JPanel {

    ArrayList<JButton> buttons = new ArrayList<>();

    public CentrePanelMovie()
    {
        super();
    }

    public void createButtons(int count)
    {
        for (int i = 1; i <= count; i++)
        {
            JButton b = new JButton();
            b.setBackground(Color.orange);
            b.setForeground(Color.black); // Set text color
            b.setFont(new Font("Arial", Font.BOLD, 8)); // Set font

            buttons.add(b);
            this.add(b);
            validate();
            repaint();
        }

    }

    public void setButtonText(int button_no, String button_text) {
        buttons.get(button_no).setText(button_text);
    }

    public ArrayList<JButton> getAllButtons()
    {
        return buttons;
    }

}
