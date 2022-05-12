package guiness;

public class Test {

    public static void main(String[] args) {
        guinessbook book = new guinessbook();
        Author a = new Author("Natasha Romanov");
        Author b = new Author("Jean-Luc Picard");
        Author c = new Author("Edgar Allen Poe");
        Author d = new Author("Laurel Lance");
        add_random_books_test(21, 2010, a);
        add_random_books_test(15, 2030, b);
        add_random_books_test(6, 2000, c);
        add_random_books_test(24, 1995, d);

        book.addAuthor(a);
        book.addAuthor(b);
        book.addAuthor(c);
        book.addAuthor(d);

        boolean newRecord = book.isNewRecord();

        if (newRecord) {
            System.out.println("A new record was set! \n" + book.currentRecord());
        } else {
            System.out.println("Record holder remains \n " + book.currentRecord());
        }

        System.out.println(a.toStringAll());
        // System.out.println(a.toStringSummary());

        return;
    }

    public static void add_random_books_test(int count, int year, Author a) {
        for (int i = 0; i < count; i++) {
            a.addBook(a.getName() + String.valueOf(i), year);
        }
    }

}
