package Model.Utils;

import Model.Casting.ManageCasting;
import Model.Actors.ManageActors;
import Model.Movies.ManageMovies;

public class Model {
    ManageActors ms1;
    ManageCasting ms3;
    ManageMovies ms2;

    public Model() {
        ms1 = new ManageActors();
        ms2 = new ManageMovies();
        ms3 = new ManageCasting();
    }

    public ManageCasting getMs3() {
        return ms3;
    }

    public ManageActors getMs1() {
        return ms1;
    }

    public ManageMovies getMs2() {
        return ms2;
    }

    public void setMs3(ManageCasting ms) {
        this.ms3= ms3;
    }

    public void setMs1(ManageActors ms1) {
        this.ms1 = ms1;
    }

    public void setMs2(ManageMovies ms2) {
        this.ms2 = ms2;
    }
}
