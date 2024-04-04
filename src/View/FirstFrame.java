package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FirstFrame extends JFrame {
    String bg1="src/View/bg2.jpeg";
    String bg2="src/View/bg_1.jpg";
    JButton manageActorBtn;
    JButton manageMoviesBtn;
    JButton manageCastingBtn;
    JPanel firstPanel;
    JPanel secondPanel;
    JLabel head;

    FirstFrame() {
        super("Main DashBoard");
        manageActorBtn = new JButton("Manage Actors");
        manageMoviesBtn = new JButton("Manage Movies");
        manageCastingBtn = new JButton("Manage Casting");
        head = new JLabel("Welcome To Movie Casting System",JLabel.CENTER);
        head.setForeground(Color.black);
        head.setFont(new Font("algerian", Font.BOLD, 30));
        head.setBackground(Color.BLUE);
        try {
            Image backgroundImage = ImageIO.read(new File(bg1));
            firstPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            };
        } catch (IOException e) {
            e.printStackTrace();
        }
        firstPanel.setLayout(new BorderLayout());
        firstPanel.add(head,BorderLayout.NORTH);


        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        manageActorBtn.setFont(buttonFont);
        manageMoviesBtn.setFont(buttonFont);
        manageCastingBtn.setFont(buttonFont);
        manageActorBtn.setFont(new Font("Arial", Font.BOLD, 16));
        manageActorBtn.setForeground(Color.WHITE);
        manageActorBtn.setBackground(new Color(255, 165, 0));
        manageActorBtn.setFocusPainted(false);
        manageActorBtn.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 2), BorderFactory.createEmptyBorder(10, 20, 10, 20)));
        manageActorBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        manageActorBtn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                manageActorBtn.setBackground(Color.BLUE);
            }

            public void mouseExited(MouseEvent e) {
                manageActorBtn.setBackground(new Color(255, 165, 0));
            }
        });
        manageMoviesBtn.setFont(new Font("Arial", Font.BOLD, 16));
        manageMoviesBtn.setForeground(Color.WHITE);
        manageMoviesBtn.setBackground(new Color(255, 165, 0));
        manageMoviesBtn.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 2), BorderFactory.createEmptyBorder(10, 20, 10, 20)));
        manageMoviesBtn.setFocusPainted(false);
        manageMoviesBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        manageMoviesBtn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                manageMoviesBtn.setBackground(Color.BLUE);
            }

            public void mouseExited(MouseEvent e) {
                manageMoviesBtn.setBackground(new Color(255, 165, 0));
            }
        });
        manageCastingBtn.setFont(new Font("Arial", Font.BOLD, 16));
        manageCastingBtn.setForeground(Color.WHITE);
        manageCastingBtn.setBackground(new Color(255, 165, 0));
        manageCastingBtn.setFocusPainted(false);
        manageCastingBtn.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 2), BorderFactory.createEmptyBorder(10, 20, 10, 20)));
        manageCastingBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        manageCastingBtn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                manageCastingBtn.setBackground(Color.BLUE);
            }

            public void mouseExited(MouseEvent e) {
                manageCastingBtn.setBackground(new Color(255, 165, 0));
            }
        });
        try {
            Image backgroundImage = ImageIO.read(new File(bg2));
            secondPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            };
        } catch (IOException e) {
            e.printStackTrace();
        }
        secondPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        secondPanel.add(manageActorBtn);
        secondPanel.add(manageMoviesBtn);
        secondPanel.add(manageCastingBtn);
        firstPanel.add(secondPanel);

        add(firstPanel);

        pack();
        setSize(600, 300);
        setVisible(true);

    }
    public JButton getManageActorBtn() {
        return manageActorBtn;
    }
    public JButton getManageMoviesBtn() {
        return manageMoviesBtn;
    }
    public JButton getManageCastingBtn() {
        return manageCastingBtn;
    }


}

