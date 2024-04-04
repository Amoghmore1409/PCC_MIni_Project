package Model.Movies;


import java.io.IOException;
import java.util.ArrayList;

public abstract class FileHandlingMovies{
    protected abstract ArrayList<Movies> readMoviesJsonFile(String file_path);
    protected abstract void writeMoviesJsonFile(String file_path, ArrayList<Movies> booklist) throws IOException;
}