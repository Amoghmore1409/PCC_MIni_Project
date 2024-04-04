package View;

import javax.swing.*;

public class ManageMovieFrame extends JFrame {
    InitialMovieFrame bip;

    public ManageMovieFrame()
    {
        super("Manage Movie DashBoard");
        bip = new InitialMovieFrame();
        add(bip);
        pack();
        setSize(500, 600);
    }

    public void setBip(InitialMovieFrame bip) {
        this.bip = bip;
    }

    public InitialMovieFrame getBipp() {
        return bip;
    }
}