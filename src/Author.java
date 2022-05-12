public class Author {

    private String Name = "";
    private Map<Integer, Integer> booksByYear;
    private Map<String, Int> books;

    public Author(String name) {
        booksByYear = new HashMap<Integer, Integer>();
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void addBook(String title, int year) {
        if (!books.containsKey(title)) {
            books.add(title, year);
        }
    }

    public void updateCount() {
        for (int year : books.values()) {
            if (!booksByYear.containsKey(year)) {
                booksByYear.add(year, 1);
            } else {
                booksByYear.replace(year, booksByYear.get(year) + 1);
            }
        }
    }

    public Map<Integer, Integer> getBooksByYear() {
        return booksByYear;
    }

    public Map<Integer, Integer> getHighestCount() {
        Map.Entry<Integer, Integer> maxEntry = null;
        for (Map.Entry<Integer, Integer> entry : booksByYear.entryset()) {
            if (maxEntry = null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        return maxEntry;
    }
}
