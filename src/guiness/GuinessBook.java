package guiness;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;

public class guinessbook {
    // Record Variables
    private String recordHolder = "Barbara Cartland";
    private int recordCount = 23;
    private int recordYear = 1976;

    public guinessbook() {
    }

    public boolean addAuthor(Author author) {
        // Author is checked against the record, if they break it the new record is set,
        // if not the author is effectively ignored.
        if (author.getBestCount() > recordCount) {
            SetRecord(author);
            return true;
        }
        return false;
    }

    public void SetRecord(Author a) {
        // Sets all of the record details if an update is needed

        recordCount = a.getBestCount();
        recordYear = a.getBestYear();
        recordHolder = a.getName();
    }

    public String currentRecord() {
        // Returns a string format of the current record holder data

        String rs = "Current Record:\n";
        rs += "\nRecord Author : " + recordHolder;
        rs += "\nRecord Year : " + recordYear;
        rs += "\nRecord Count : " + recordCount;
        return rs;
    }

    // OUTDATED CODE FROM WHEN ALL AUTHORS STORED
    // public Set<Author> getAuthors() {
    // return authors;
    // }
}
