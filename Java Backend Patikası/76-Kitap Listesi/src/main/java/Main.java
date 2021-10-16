import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class Main {

    static List<Book> books = new ArrayList<>();

    public static void main(String args[]) {
        books.add(new Book("Test1", "Author1", 200));
        books.add(new Book("Test2", "Author2", 50));
        books.add(new Book("Test3", "Author3", 500));
        books.add(new Book("Test4", "Author4", 425));
        books.add(new Book("Test5", "Author5", 99));
        books.add(new Book("Test6", "Author6", 68));
        books.add(new Book("Test7", "Author7", 328));
        books.add(new Book("Test8", "Author8", 199));
        books.add(new Book("Test9", "Author9", 36));
        books.add(new Book("Test10", "Author10", 399));

        HashMap<String, String> bookAndAuthors = new HashMap<>();
        books.stream().forEach(book -> {
            bookAndAuthors.put(book.getName(), book.getAuthor());
        });

        for (String key : bookAndAuthors.keySet())
            System.out.println("Key: " + key + " Value:" + bookAndAuthors.get(key));

        List<Book> biggerHundered = books
                .stream()
                .filter(book -> (book.getPage() > 100))
                .collect(Collectors.toList());
    }

}
