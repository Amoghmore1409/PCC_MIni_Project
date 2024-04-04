package View;

import javax.swing.*;

public class InitialMovieFrame extends JPanel {

    private CentrePanelMovie bp;
    private AddMoviesPanel bps;
    private EditMoviePanel emp;
    private DeleteMoviePanel dmp;

    public InitialMovieFrame() {
        super();
        bp = new CentrePanelMovie();
        add(bp);
        bps = new AddMoviesPanel();
        add(bps);
        emp = new EditMoviePanel();
        add(emp);
        dmp= new DeleteMoviePanel();
        add(dmp);

    }

    public CentrePanelMovie getBp() {
        return bp;
    }
    public AddMoviesPanel getBps() {
        return bps;
    }

    public void setBp(CentrePanelMovie cp) {
        this.bp = bp;
    }

    public void setBps(AddMoviesPanel aps) {
        this.bps = bps;
    }

    public DeleteMoviePanel getDmp() {
        return dmp;
    }

    public EditMoviePanel getEmp() {
        return emp;
    }

    public void setEmp(EditMoviePanel emp) {
        this.emp = emp;
    }

    public void setDmp(DeleteMoviePanel dmp) {
        this.dmp = dmp;
    }
}
