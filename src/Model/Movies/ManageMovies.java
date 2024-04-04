package Model.Movies;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import Model.Utils.Displayable;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
public class ManageMovies extends FileHandlingMovies implements Displayable { // Corrected class name

    ArrayList<Movies> movieList = new ArrayList<Movies>();

    ObjectMapper objectMapper = new ObjectMapper();

    private int linesBeingDisplayed;
    private int firstLineIndex;
    private int lastLineIndex;
    private int highlightedLine;

    public ManageMovies() {
        readMoviesJsonFile("src/Model/Movies/MOCK_DATA (4).json");
    }


    public ArrayList<Movies> readMoviesJsonFile(String file_path) {
        try {
            movieList.removeAll(movieList);
            JsonNode rootNode = objectMapper.readTree(new File(file_path));

            // Iterate through JSON array
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    int movie_id = node.get("movieID").asInt();
                    String name = node.get("movieName").asText();
                    String genre = node.get("genre").asText();
                    String language = node.get("language").asText();
                    int cost = node.get("price").asInt();
                    int tickets_sold = node.get("copiesSold").asInt();

                    // Populate other attributes as needed
                    Movies movie = new Movies(movie_id, name, genre, language, cost, tickets_sold);
                    movieList.add(movie);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return movieList;
    }

    public void writeMoviesJsonFile(String file_path, ArrayList<Movies> movies) throws IOException {
        objectMapper.writeValue(Paths.get(file_path).toFile(), movies);
    }

    public void setMoviesTable(ArrayList<Movies> movieList) {
        this.movieList = movieList;
    }

    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Movie ID");
        headers.add("Name");
        headers.add("Genre");
        headers.add("Language");
        headers.add("Production cost");
        headers.add("Tickets sold");

        // Add headers for other attributes as needed
        return headers;
    }

    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> MovieDetails = new ArrayList<String>();

        MovieDetails.add(String.valueOf(movieList.get(line).getMovieID()));
        MovieDetails.add(movieList.get(line).getMovieName());
        MovieDetails.add(movieList.get(line).getGenre());
        MovieDetails.add(movieList.get(line).getLanguage());
        MovieDetails.add(String.valueOf(movieList.get(line).getPrice()));
        MovieDetails.add(String.valueOf(movieList.get(line).getCopiesSold()));
        // Add other attributes as needed
        return MovieDetails;
    }

    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> moviesSubset = new ArrayList<ArrayList<String>>();
        for (int i = firstLine; i <= lastLine; i++) {
            moviesSubset.add(getLine(i));
        }
        return moviesSubset;
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

    public ArrayList<Movies> getTable() {
        readMoviesJsonFile("src/Model/Movies/MOCK_DATA (4).json");
        return movieList;
    }

    public void addNewMovie(int movieID, String movieName, String genre, String language, int cost, int ticketssold) throws IOException {
        readMoviesJsonFile("src/Model/Movies/MOCK_DATA (4).json");
        Movies temp_movie = new Movies(movieID, movieName, genre, language, cost, ticketssold);
        movieList.add(temp_movie);
        writeMoviesJsonFile("src/Model/Movies/MOCK_DATA (4).json", movieList);

    }

    public void editMovie(int edit_movie_idx, int movie_id, String movie_name, String movie_genre, String movie_language, int cost, int ticketssold) throws IOException {
        readMoviesJsonFile("src/Model/Movies/MOCK_DATA (4).json");
        movieList.get(edit_movie_idx).setMovieID(movie_id);
        movieList.get(edit_movie_idx).setMovieName(movie_name);
        movieList.get(edit_movie_idx).setGenre(movie_genre);
        movieList.get(edit_movie_idx).setLanguage(movie_language);
        movieList.get(edit_movie_idx).setPrice(cost);
        movieList.get(edit_movie_idx).setCopiesSold(ticketssold);
        writeMoviesJsonFile("src/Model/Movies/MOCK_DATA (4).json", movieList);
    }

    public int deleteMovie(int delete_movie_idx) throws IOException {
        readMoviesJsonFile("src/Model/Movies/MOCK_DATA (4).json");
        movieList.remove(delete_movie_idx);
        int b_id = movieList.get(delete_movie_idx).getMovieID();
        writeMoviesJsonFile("src/Model/Movies/MOCK_DATA (4).json", movieList);
        return b_id;
    }


}

