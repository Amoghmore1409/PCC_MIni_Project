package Model.Actors;


import java.io.IOException;
import java.util.ArrayList;

public abstract class FileHandlingActors {
    protected abstract ArrayList<Actors> readActorJsonFile(String file_path);
    protected abstract void writeActorJsonFile(String file_path, ArrayList<Actors> students) throws IOException;
}