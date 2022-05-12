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
        // Initialize all values, setting the name
        booksByYear = new HashMap<Integer, Set<String>>();
        bestYear = null;
        Name = name;
    }

    public String getName() {
        // returns the author name
        return Name;
    }

    public void addBook(String title, int year) {
        // adds a book to the set to which is belongs based on the year
        // or adds a new set entry if the year doesnt exist yet.
        if (!booksByYear.containsKey(year)) {
            Set<String> s = new HashSet<String>();
            s.add(title);
            booksByYear.put(year, s);
        } else {
            booksByYear.get(year).add(title);
        }
    }

    public Map<Integer, Set<String>> getBooksByYear() {
        // returns entire booksByYear map
        return booksByYear;
    }

    public int getBestYear() {
        // Updates the higest count and returns the year of the highest count for the
        // author
        updateHighestCount();
        return bestYear.getKey();
    }

    public int getBestCount() {
        // Updates the higest count and returns the count of books in the highest count
        // year for the author
        updateHighestCount();
        return bestYear.getValue().size();
    }

    private void updateHighestCount() {
        // Updates the bestYear entry to contain the higest count year from the books by
        // year map
        Map.Entry<Integer, Set<String>> maxEntry = null;
        for (Map.Entry<Integer, Set<String>> entry : booksByYear.entrySet()) {
            if (maxEntry == null || entry.getValue().size() > maxEntry.getValue().size()) {
                maxEntry = entry;
            }
        }
        bestYear = maxEntry;
    }

    public String toStringAll() {
        // To string conversion for every book in the author's map
        String rs = Name;
        for (Map.Entry<Integer, Set<String>> a : booksByYear.entrySet()) {
            for (String s : a.getValue()) {
                rs += "\n" + a.getKey() + " -- " + s;
            }
        }
        return rs;
    }

    public String toStringSummary() {
        updateHighestCount();
        String rs = Name;
        rs += ":     " + bestYear.getKey() + " -- " + bestYear.getValue().size();
        return rs;
    }
}
