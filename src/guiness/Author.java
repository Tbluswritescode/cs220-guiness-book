package guiness;

import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Author {

    private String Name = "";
    private Map<Integer, Set<String>> booksByYear;
    private Map.Entry<Integer, Set<String>> bestYear;

    public Author(String name) {
        booksByYear = new HashMap<Integer, Set<String>>();
        bestYear = null;
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void addBook(String title, int year) {
        if (!booksByYear.containsKey(year)) {
            Set<String> s = new HashSet<String>();
            s.add(title);
            booksByYear.put(year, s);
        } else {
            booksByYear.get(year).add(title);
        }
    }

    public Map<Integer, Integer> getBooksByYear() {
        return booksByYear;
    }

    public int getBestYear() {
        updateHighestCount();
        return bestYear.getKey();
    }

    public int getBestCount() {
        updateHighestCount();
        return bestYear.getValue().size();
    }

    private void updateHighestCount() {
        Map.Entry<Integer, Set<String>> maxEntry = null;
        for (Map.Entry<Integer, Set<String>> entry : booksByYear.entrySet()) {
            if (maxEntry == null || entry.getValue().size() > maxEntry.getValue().size()) {
                maxEntry = entry;
            }
        }
        bestYear = maxEntry;
    }

    public String toStringAll() {
        String rs = Name;
        for (Map.Entry<String, Integer> a : books.entrySet()) {
            rs += "\n" + a.getKey() + " -- " + a.getValue();
        }
        rs += booksByYear;
        return rs;
    }

    public String toStringSummary() {
        updateHighestCount();
        String rs = Name;
        rs += ":     " + bestYear.getKey() + " -- " + bestYear.getValue().size();
        return rs;
    }
}
