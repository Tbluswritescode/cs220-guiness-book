package guiness;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;

public class guinessbook {
    // Record Variables
    private String recordHolder = "Barbara Cartland";
    private int recordCount = 23;
    private int recordYear = 1976;

    // Set of authors entered
    private Set<Author> authors;

    public guinessbook() {
        authors = new HashSet<Author>();

    }

    public boolean addAuthor(Author author) {
        if (author.getBestCount() > recordCount) {
            SetRecord(author);
            return true;
        }
        return false;
    }

    public void SetRecord(Author a) {
        recordCount = a.getBestCount();
        recordYear = a.getBestYear();
        recordHolder = a.getName();
    }

    public String currentRecord() {
        String rs = "Current Record:\n";
        rs += "\nRecord Author : " + recordHolder;
        rs += "\nRecord Year : " + recordYear;
        rs += "\nRecord Count : " + recordCount;
        return rs;
    }

    public Set<Author> getAuthors() {
        return authors;
    }
}
