
package View;

import javax.swing.*;

public class InitialActorFrame extends JPanel {

    private CentrePanelActor cp;
    private AddActorPanel aps;
    private EditActorPanel eps;
    private DeleteActorPanel dps;

    public InitialActorFrame() {
        super();
        cp = new CentrePanelActor();
        add(cp);
        aps = new AddActorPanel();
        add(aps);
        eps = new EditActorPanel();
        add(eps);
        dps = new DeleteActorPanel();
        add(dps);
    }

    public CentrePanelActor getCp() {
        return cp;
    }
    public AddActorPanel getAps() {
        return aps;
    }

    public DeleteActorPanel getDps() {
        return dps;
    }

    public EditActorPanel getEps() {
        return eps;
    }

    public void setDps(DeleteActorPanel dps) {
        this.dps = dps;
    }

    public void setEps(EditActorPanel eps) {
        this.eps = eps;
    }

    public void setCp(CentrePanelActor cp) {
        this.cp = cp;
    }

    public void setAps(AddActorPanel aps) {
        this.aps = aps;
    }

}
