package View;

import javax.swing.*;

public class ManageActorFrame extends JFrame {
    InitialActorFrame ip;

    public ManageActorFrame()
    {
        super("Manage Actor DashBoard");
        ip = new InitialActorFrame();
        add(ip);
        pack();
        setSize(500, 600);
    }

    public void setIp(InitialActorFrame ip) {
        this.ip = ip;
    }

    public InitialActorFrame getIp() {
        return ip;
    }
}