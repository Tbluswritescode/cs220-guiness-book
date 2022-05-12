package guinessbook;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;

public class GuinessBook {
    private String recordHolder = "Barbara Cartland";
    private int recordCount = 23;
    private int recordYear = 1976;

    private Set<Author> authors;

    public guinessbook(String filename) {
        authors = new HashSet<Author>();

    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public boolean isNewRecord() {
        for (Author a : authors) {
            Map.Entry<Integer, Integer> m = a.getHighestCount();
            if (m.getValue() > recordCount) {
                recordCount = m.getValue();
                recordYear = m.getKey();
                recordHolder = a.getName();
                return true;
            }
        }
        return false;
    }
}
