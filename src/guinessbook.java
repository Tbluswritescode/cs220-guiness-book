public class guinessbook {
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

    public boolean updateRecord() {
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
