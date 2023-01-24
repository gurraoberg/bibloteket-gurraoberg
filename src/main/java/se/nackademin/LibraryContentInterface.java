package se.nackademin;

import java.io.IOException;
import java.util.List;

public interface LibraryContentInterface {

    public void readFromCSV(String fileName, List<String> bookList) throws IOException;

    public void writeToCSV(String fileName, String toAdd) throws IOException;

    public void getLibraryContent(List<String> bookList, List<String> cdList, List<String> movieList);

    
}
