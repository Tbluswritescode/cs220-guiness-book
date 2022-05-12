package guiness;

import java.util.Map;
import java.util.HashMap;

public class Author {

    private String Name = "";
    private Map<Integer, Integer> booksByYear;
    private Map<String, Integer> books;
    private Map.Entry<Integer, Integer> bestYear;

    public Author(String name) {
        booksByYear = new HashMap<Integer, Integer>();
        books = new HashMap<String, Integer>();
        bestYear = null;
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void addBook(String title, int year) {
        if (!books.containsKey(title)) {
            books.put(title, year);
        }
        updateCount(year);
    }

    public void updateCount(int year) {
        if (!booksByYear.containsKey(year)) {
            booksByYear.put(year, 1);
        } else {
            booksByYear.replace(year, booksByYear.get(year) + 1);
            System.out.println(booksByYear.get(year));
        }
    }

    public Map<Integer, Integer> getBooksByYear() {
        return booksByYear;
    }

    public Map.Entry<Integer, Integer> getHighestCount() {
        Map.Entry<Integer, Integer> maxEntry = null;
        for (Map.Entry<Integer, Integer> entry : booksByYear.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        bestYear = maxEntry;
        return maxEntry;
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
        getHighestCount();
        String rs = Name;
        rs += ":     " + bestYear.getKey() + " -- " + bestYear.getValue();
        return rs;
    }
}
