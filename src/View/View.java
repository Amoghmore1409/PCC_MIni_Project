
package View;

import java.awt.*;
import java.util.ArrayList;

public class View {
    FirstFrame ff;
    ManageActorFrame maf;
    ManageMovieFrame mbf;
    ManageCastFrame mpf;



    public View() {
        ff = new FirstFrame();
        maf = new ManageActorFrame();
        mbf = new ManageMovieFrame();
        mpf = new ManageCastFrame();
    }

    public void centerInitialSetupActor(int linesBeingDisplayed, int size) {
        maf.getIp().getCp().setLayout(new GridLayout(linesBeingDisplayed + 1, size));
        maf.getIp().getCp().createButtons((linesBeingDisplayed + 1) * size);
    }

    public void centerUpdateActor(ArrayList<ArrayList<String>> lines, ArrayList<String> headers) {
        for (int i = 0; i < headers.size(); i++) {
            maf.getIp().getCp().getAllButtons().get(i).setText(headers.get(i));
        }


        for (int Actor_row_no = 0; Actor_row_no < lines.size(); Actor_row_no++) {
            for (int Actor_col_no = 0; Actor_col_no < headers.size(); Actor_col_no++) {
                int button_no = Actor_row_no * headers.size() + headers.size() + Actor_col_no;
                String button_txt = lines.get(Actor_row_no).get(Actor_col_no);

                maf.getIp().getCp().getAllButtons().get(button_no).setText(button_txt);
            }
        }
    }
        public void centerInitialSetupMovie ( int linesBeingDisplayed, int size){
            mbf.getBipp().getBp().setLayout(new GridLayout(linesBeingDisplayed + 1, size));
            mbf.getBipp().getBp().createButtons((linesBeingDisplayed + 1) * size);
        }
        public void centerUpdateMovie (ArrayList < ArrayList < String >> lines, ArrayList < String > headers){
            for (int i = 0; i < headers.size(); i++) {
                mbf.getBipp().getBp().getAllButtons().get(i).setText(headers.get(i));
            }

            for (int book_row_no = 0; book_row_no < lines.size(); book_row_no++) {
                for (int book_col_no = 0; book_col_no < headers.size(); book_col_no++) {
                    int button_no = book_row_no * headers.size() + headers.size() + book_col_no;
                    String button_txt = lines.get(book_row_no).get(book_col_no);

                    mbf.getBipp().getBp().getAllButtons().get(button_no).setText(button_txt);
                }
            }
        }
    public void centerInitialSetupCast ( int linesBeingDisplayed, int size){
        mpf.getPipp().getPp().setLayout(new GridLayout(linesBeingDisplayed + 1, size));
        mpf.getPipp().getPp().createButtons((linesBeingDisplayed + 1) * size);
    }
    public void centerUpdateCast (ArrayList < ArrayList < String >> lines, ArrayList < String > headers){
        for (int i = 0; i < headers.size(); i++) {
            mpf.getPipp().getPp().getAllButtons().get(i).setText(headers.get(i));
        }

        for (int Cast_row_no = 0; Cast_row_no < lines.size(); Cast_row_no++) {
            for (int Cast_col_no = 0; Cast_col_no < headers.size(); Cast_col_no++) {
                int button_no =Cast_row_no * headers.size() + headers.size() + Cast_col_no;
                String button_txt = lines.get(Cast_row_no).get(Cast_col_no);

                mpf.getPipp().getPp().getAllButtons().get(button_no).setText(button_txt);
            }
        }
    }

    public  FirstFrame getFf() {
        return ff;
    }

    public void setFf(FirstFrame ff) {
        this.ff = ff;
    }

    public ManageActorFrame getMaf() {
        return maf;
    }

    public void setMaf(ManageActorFrame maf) {
        this.maf = maf;
    }

    public ManageMovieFrame getMbf() {
        return mbf;
    }

    public void setMbf(ManageMovieFrame mbf) {
        this.mbf = mbf;
    }

    public void setMpf(ManageCastFrame mpf) {
        this.mpf = mpf;
    }

    public ManageCastFrame getMpf() {
        return mpf;
    }
}


