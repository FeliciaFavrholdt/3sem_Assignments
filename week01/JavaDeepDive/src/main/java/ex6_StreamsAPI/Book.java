package ex6_StreamsAPI;

//6.1 Create a Book class with attributes like title, author, publication year, pages and rating.

public class Book {

    //attributes
    String title;
    String author;
    int publicationYear;
    int pages;
    int rating;

    //constructor
    public Book(String title, String author, int publicationYear, int pages, int rating) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.pages = pages;
        this.rating = rating;
    }

    //no-args constructor
    public Book() {

    }

    //getters and setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    //toString method

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationYear=" + publicationYear +
                ", pages=" + pages +
                ", rating=" + rating +
                '}';
    }
}
