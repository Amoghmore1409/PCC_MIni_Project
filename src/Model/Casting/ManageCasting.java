package Model.Casting;

import Model.Actors.Actors;
import Model.Actors.ManageActors;
import Model.Movies.Movies;
import Model.Movies.ManageMovies;
import Model.Utils.Displayable;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ManageCasting extends FileHandlingCast implements Displayable {
    ArrayList<Actors> actorList  = new ArrayList<Actors>();
    ArrayList<Movies> movieList = new ArrayList<Movies>();
    ArrayList<Casting> castingData = new ArrayList<>();

    ObjectMapper objectMapper = new ObjectMapper();

    ArrayList<Map<String, Object>> handle_Cast = new ArrayList<>();




    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;
    String path="src/Model/Casting/MOCK_DATA (3).json";

    public ManageCasting() {
        ManageActors ms1 = new ManageActors();
        actorList= ms1.getTable();
        ManageMovies ms2= new ManageMovies();
        movieList = ms2.getTable();
        readCastingJsonFile(path);
    }

    public ArrayList<Casting> readCastingJsonFile(String file_path) {
        castingData.removeAll(castingData);
        try {

            JsonNode rootNode = objectMapper.readTree(new File(file_path));

            // Iterate through JSON array
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    int a_temp = node.get("actorID").asInt();
                    Actors a_temp_obj = new Actors();
                    for(Actors actor:  actorList){
                        if(a_temp==actor.getActorID()){
                            a_temp_obj=actor;
                        }
                    }
                    int b_temp = node.get("movieID").asInt();
                    Movies b_temp_obj = new Movies();
                    for(Movies movie:movieList){
                        if(b_temp==movie.getMovieID()){
                            b_temp_obj=movie;
                        }
                    }
                    String castingDate = node.get("castingDate").asText();
                    String director = node.get("director").asText();
                    castingData.add(new Casting(a_temp_obj,b_temp_obj,castingDate,director));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return castingData;
    }



    public void writeCastingJsonFile(String file_path, ArrayList<Casting> castingData) throws IOException {

        ArrayList<Map<String, Object>> casting_to_be_written = new ArrayList<>();

        for(int i = 0; i < castingData.size(); i++)
        {    HashMap<String, Object> data = new HashMap<>();
            data.put("actorID",castingData.get(i).getA_temp().getActorID());
            data.put("movieID",castingData.get(i).getB_temp().getMovieID());
            data.put("castingDate",castingData.get(i).getCastingDate());
            data.put("director",castingData.get(i).getDirector());


            casting_to_be_written.add(data);
        }

        objectMapper.writeValue(Paths.get(file_path).toFile(), casting_to_be_written);
    }

    // Implement other methods as needed for managing castings, similar to ManageEnrolls class

    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Actor ID");
        headers.add("Movie ID");
        headers.add("Casting Date");
        headers.add("Director");

        return headers;
    }


    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> Cast_details = new ArrayList<String>();

        Cast_details.add(String.valueOf(castingData.get(line).getA_temp().getActorID()));
        Cast_details.add(String.valueOf(castingData.get(line).getB_temp().getMovieID()));
        Cast_details.add(castingData.get(line).getCastingDate());
        Cast_details.add(castingData.get(line).getDirector());

        return Cast_details;
    }

    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> pubs_subset = new ArrayList<ArrayList<String>>();

        for (int i = firstLine; i <= lastLine; i++) {
            pubs_subset.add(this.getLine(i));
        }
        return pubs_subset;
    }

    @Override
    public int getFirstLineToDisplay() {
        return this.firstLineIndex;
    }

    @Override
    public int getLineToHighlight() {
        return this.highlightedLine;
    }

    @Override
    public int getLastLineToDisplay() {
        setLastLineToDisplay(this.firstLineIndex + this.linesBeingDisplayed - 1);
        return this.lastLineIndex;
    }

    @Override
    public int getLinesBeingDisplayed() {
        return this.linesBeingDisplayed;
    }

    @Override
    public void setFirstLineToDisplay(int firstLine) {
        this.firstLineIndex = firstLine;
    }

    @Override
    public void setLineToHighlight(int highlightedLine) {

    }

    @Override
    public void setLastLineToDisplay(int lastLine) {
        this.lastLineIndex = lastLine;

    }

    @Override
    public void setLinesBeingDisplayed(int numberOfLines) {
        this.linesBeingDisplayed = numberOfLines;

    }

    // Implement other Displayable interface methods

    public ArrayList<Casting> getTable() {
        return this.castingData;
    }
    public void addNewCast( int actorID,int movieID,String castingDate, String director) throws IOException {
        readCastingJsonFile("src/Model/Casting/MOCK_DATA (3).json");
        Casting temp_Cast = new Casting(actorList.get(actorID),movieList.get(movieID), castingDate,  director);
        castingData.add(temp_Cast);
        writeCastingJsonFile("src/Model/Casting/MOCK_DATA (3).json",castingData);

    }
    public void editCast(int edit_pubs_idx, int actorID, int movieID, String castingDate,String director) throws IOException {
        readCastingJsonFile("src/Model/Casting/MOCK_DATA (3).json");
        castingData.get(edit_pubs_idx).setCastingDate(castingDate);
        castingData.get(edit_pubs_idx).setDirector(director);
        castingData.get(edit_pubs_idx).setA_temp(actorList.get(actorID));
        castingData.get(edit_pubs_idx).setB_temp(movieList.get(movieID));
        writeCastingJsonFile("src/Model/Casting/MOCK_DATA (3).json",castingData);
    }

    public void deleteCast(int delete_pubs_idx) throws IOException {
        readCastingJsonFile("src/Model/Casting/MOCK_DATA (3).json");
        castingData.remove(delete_pubs_idx);
        writeCastingJsonFile("src/Model/Casting/MOCK_DATA (3).json",castingData);
    }

}
