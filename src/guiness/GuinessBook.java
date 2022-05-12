package guiness;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;

public class guinessbook {
    private String recordHolder = "Barbara Cartland";
    private int recordCount = 23;
    private int recordYear = 1976;

    private Set<Author> authors;

    public guinessbook() {
        authors = new HashSet<Author>();

    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public boolean isNewRecord() {
        for (Author a : authors) {
            if (a.getBestCount() > recordCount) {
                recordCount = a.getBestCount();
                recordYear = a.getBestYear();
                recordHolder = a.getName();
                return true;
            } else {
                authors.remove(a);
            }
        }
        return false;
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
