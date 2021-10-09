import java.util.Comparator;
import java.util.TreeSet;

class Main {

    public static void main(String args[]) {
        TreeSet<Book> sortedByName = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        sortedByName.add(new Book("Kitap1", "Yazar1", "2012", 156));
        sortedByName.add(new Book("Kitap2", "Yazar2", "2011", 855));
        sortedByName.add(new Book("Kitap3", "Yazar3", "2010", 632));
        sortedByName.add(new Book("Kitap4", "Yazar4", "2009", 15));
        sortedByName.add(new Book("Kitap5", "Yazar5", "2021", 132));

        for (Book book : sortedByName) {
            System.out.print(book.getName() + ", ");
        }

        System.out.println();

        TreeSet<Book> sortedByPage = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPage() - o2.getPage();
            }
        });

        sortedByPage.addAll(sortedByName);

        for (Book book : sortedByPage) {
            System.out.print(book.getName() + ", ");
        }

    }

}
