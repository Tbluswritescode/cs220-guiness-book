package guinessbook;

import java.util.Map;
import java.util.HashMap;

public class Author {

    private String Name = "";
    private Map<Integer, Integer> booksByYear;
    private Map<String, Integer> books;

    public Author(String name) {
        booksByYear = new HashMap<Integer, Integer>();
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void addBook(String title, int year) {
        if (!books.containsKey(title)) {
            books.put(title, year);
        }
    }

    public void updateCount() {
        for (int year : books.values()) {
            if (!booksByYear.containsKey(year)) {
                booksByYear.put(year, 1);
            } else {
                booksByYear.replace(year, booksByYear.get(year) + 1);
            }
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
        return maxEntry;
    }
}
