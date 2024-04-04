package View;

import javax.swing.*;

public class InitialCastFrame extends JPanel {

    private CentrePanelCast pp;
    private AddCastingPanel pps;
    private EditCastPanel ecp;
    private DeleteCastPanel dcp;

    public InitialCastFrame() {
        super();
        pp = new CentrePanelCast();
        add(pp);
        pps = new AddCastingPanel();
        add(pps);
        ecp=new EditCastPanel();
        add(ecp);
        dcp=new DeleteCastPanel();
        add(dcp);
    }

    public CentrePanelCast getPp() {
        return pp;
    }
    public AddCastingPanel getPps() {
        return pps;
    }

    public void setPp(CentrePanelCast pp) {
        this.pp = pp;
    }

    public void setPps(AddCastingPanel pps) {
        this.pps = pps;
    }

    public void setDcp(DeleteCastPanel dcp) {
    }

    public void setEcp(EditCastPanel ecp) {
        this.ecp = ecp;
    }

    public DeleteCastPanel getDcp() {
        return dcp;
    }

    public EditCastPanel getEcp() {
        return ecp;
    }
}

