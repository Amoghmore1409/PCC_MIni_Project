package Model.Actors;

import Model.Utils.Displayable;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ManageActors extends FileHandlingActors implements Displayable {

    ArrayList<Actors> actorlist = new ArrayList<Actors>();

    ObjectMapper objectMapper = new ObjectMapper();

    private int linesBeingDisplayed;
    private int firstLineIndex;
    private int lastLineIndex;
    private int highlightedLine;
    public ManageActors(){
        readActorJsonFile("src/Model/Actors/MOCK_DATA (5).json");
    }



    public ArrayList<Actors> readActorJsonFile(String file_path)
    {
        try {
            actorlist.removeAll(actorlist);
            JsonNode rootNode = objectMapper.readTree(new File(file_path));

            // Iterate through JSON array
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    int actor_id = node.get("actorID").asInt();
                    String name = node.get("actorName").asText();
                    String genre = node.get("actorGenre").asText();
                    int rating = node.get("actorRating").asInt();
                    String language = node.get("actorLanguage").asText();
                    // Populate other attributes as needed
                    Actors actor = new Actors(actor_id, name, genre,  language,rating);
                    actorlist.add(actor);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return actorlist;
    }

    public void writeActorJsonFile(String file_path, ArrayList<Actors> actorlist) throws IOException {
        objectMapper.writeValue(Paths.get(file_path).toFile(), actorlist);
    }

    public void setActorsTable(ArrayList<Actors> actorlist) {
        this.actorlist = actorlist;
    }

    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Actor ID");
        headers.add("Name");
        headers.add("Genre");
        headers.add("Rating");
        headers.add("Language");
        // Add headers for other attributes as needed
        return headers;
    }

    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> actorDetails = new ArrayList<String>();

         actorDetails.add(String.valueOf(actorlist.get(line).getActorID()));
        actorDetails.add(actorlist.get(line).getActorName());
        actorDetails.add(actorlist.get(line).getActorGenre());
        actorDetails.add(String.valueOf(actorlist.get(line).getActorRating()));
        actorDetails.add(actorlist.get(line).getActorLanguage());
        // Add other attributes as needed
        return actorDetails;
    }

    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> actorsSubset = new ArrayList<ArrayList<String>>();
        for (int i = firstLine; i <= lastLine; i++) {
            actorsSubset.add(getLine(i));
        }
        return actorsSubset;
    }

    @Override
    public int getFirstLineToDisplay() {
        return firstLineIndex;
    }

    @Override
    public int getLineToHighlight() {
        return highlightedLine;
    }

    @Override
    public int getLastLineToDisplay() {
        setLastLineToDisplay(getFirstLineToDisplay() + getLinesBeingDisplayed() - 1);
        return lastLineIndex;
    }

    @Override
    public int getLinesBeingDisplayed() {
        return linesBeingDisplayed;
    }

    @Override
    public void setFirstLineToDisplay(int firstLine) {
        this.firstLineIndex = firstLine;
    }

    @Override
    public void setLineToHighlight(int highlightedLine) {
        this.highlightedLine = highlightedLine;
    }

    @Override
    public void setLastLineToDisplay(int lastLine) {
        this.lastLineIndex = lastLine;
    }

    @Override
    public void setLinesBeingDisplayed(int numberOfLines) {
        this.linesBeingDisplayed = numberOfLines;
    }

    public ArrayList<Actors> getTable() {
        readActorJsonFile("src/Model/Actors/MOCK_DATA (5).json");
        return actorlist;
    }
    public void addNewActor(int actorID ,String actorName, String actorGenre,  String actorLanguage,int actorRating) throws IOException {
        readActorJsonFile("src/Model/Actors/MOCK_DATA (5).json");
        Actors temp_Aut = new Actors( actorID, actorName, actorGenre,   actorLanguage,actorRating);
        actorlist.add(temp_Aut);
        writeActorJsonFile("src/Model/Actors/MOCK_DATA (5).json",actorlist);

    }
    public void editActor(int edit_actor_idx, int actor_id, String actor_name,  String actor_genre, int  actor_rating,String actor_language ) throws IOException {
        readActorJsonFile("src/Model/Actors/MOCK_DATA (5).json");
        actorlist.get(edit_actor_idx).setActorID(actor_id);
        actorlist.get(edit_actor_idx).setActorName(actor_name);
        actorlist.get(edit_actor_idx).setActorGenre(actor_genre);
        actorlist.get(edit_actor_idx).setActorRating(actor_rating);
        actorlist.get(edit_actor_idx).setActorLanguage(actor_language);
        writeActorJsonFile("src/Model/Actors/MOCK_DATA (5).json",actorlist);
    }
    public int deleteActor(int delete_actor_idx) throws IOException {
        readActorJsonFile("src/Model/Actors/MOCK_DATA (5).json");
        actorlist.remove(delete_actor_idx);
        int a_id = actorlist.get(delete_actor_idx).getActorID();
        writeActorJsonFile("src/Model/Actors/MOCK_DATA (5).json",actorlist);
        return a_id;
    }

}

