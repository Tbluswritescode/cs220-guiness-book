package guiness;

public class Test {

    public static void main(String[] args) {
        // Instantiate the guinessbook
        guinessbook book = new guinessbook();

        // Make some authors
        Author a = new Author("Natasha Romanov");
        Author b = new Author("Jean-Luc Picard");
        Author c = new Author("Edgar Allen Poe");
        Author d = new Author("Laurel Lance");

        // Add some random books for each author
        add_random_books_test(21, 2010, a);
        add_random_books_test(15, 2030, b);
        add_random_books_test(6, 2000, c);
        add_random_books_test(24, 1995, d);

        // add the authors to the book if they break the record
        // Some output to show the results of the records checkelse {
        if (book.addAuthor(a) || book.addAuthor(b) || book.addAuthor(c) || book.addAuthor(d)) {
            System.out.println("A new record was set! \n" + book.currentRecord());
        } else {
            System.out.println("Record holder remains \n " + book.currentRecord());
        }

        // OUTDATED CODE USED FOR AUTHOR TESTING
        // for (Author z : book.getAuthors()) {
        // System.out.println(z.toStringSummary());
        // }

        return;
    }

    public static void add_random_books_test(int count, int year, Author a) {

        // This function is designed to add a bunch of randomly named books for a given
        // author in a given year
        // exclusively for testing purposes, not part of the actual work of the code

        for (int i = 0; i < count; i++) {
            a.addBook(a.getName() + String.valueOf(i), year);
        }
    }

}
