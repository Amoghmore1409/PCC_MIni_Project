package View;

import javax.swing.*;

public class ManageCastFrame extends JFrame {
    InitialCastFrame pip;

    public ManageCastFrame()
    {
        super("Manage Casting DashBoard");
        pip = new InitialCastFrame();
        add(pip);
        pack();
        setSize(500, 600);
    }

    public void setPipp(InitialCastFrame pip) {
        this.pip = pip;
    }

    public InitialCastFrame getPipp() {
        return pip;
    }
}