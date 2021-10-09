public class Book {

    private String name, author, releaseDate;
    private int page;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public Book(String name, String author, String releaseDate, int page) {
        this.name = name;
        this.author = author;
        this.releaseDate = releaseDate;
        this.page = page;
    }
}
