package Model.Casting;

import java.io.IOException;
import java.util.ArrayList;

public abstract  class FileHandlingCast {

        protected abstract ArrayList<Casting> readCastingJsonFile(String file_path);
        protected abstract void writeCastingJsonFile(String file_path, ArrayList<Casting> publications) throws IOException;
    }

