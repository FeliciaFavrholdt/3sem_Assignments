package ex6_StreamsAPI;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Examples {

    public static void main(String[] args) {

        //6.2 Create a collection of Book objects to work with. You can either create a sample dataset or read data from a file or database.
        Collection<Book> bookCollection = createBook();

        System.out.println("\nAll books in collection:");
        bookCollection.forEach(System.out::println);
        System.out.println("-------------------");

        //6.3 Stream Processing - Use the Stream API to perform the following operations on the collection of books:

        //Find the average rating of all books.
        System.out.println("\nAverage rating of all books:");
        bookCollection.stream()
                .mapToInt(Book::getRating)
                .average()
                .ifPresent(System.out::println);

        //Filter and display books published after a specific year.
        System.out.println("\nBooks published after 1999:");
        bookCollection.stream()
                .filter(book -> book.getPublicationYear() > 1999)
                .forEach(book -> System.out.println(book.getTitle() + " " + book.getPublicationYear()));
        System.out.println("-------------------");

        //Sort books by rating in descending order.
        System.out.println("\nBooks sorted by rating in descending order:");
        bookCollection.stream()
                .sorted((book1, book2) -> book2.getRating() - book1.getRating())
                .forEach(book -> System.out.println(book.getTitle() + " " + book.getRating()));
        System.out.println("-------------------");

        //imperative approach - as an example
        /*
        System.out.println("\nBooks sorted by rating in descending order:");
        List<Book> toSort = new ArrayList<>();
        for (Book book : books) {
            toSort.add(book);
        }
        toSort.sort((book1, book2) -> book2.getRating() - book1.getRating());
        for (Book book : toSort) {
            System.out.println(book.getTitle() + " " + book.getRating());
        }
        System.out.println("-------------------");*/

        //Find and display the title of the book with the highest rating.
        System.out.println("\nBook with the highest rating:");
        highestRating(bookCollection, 1);

        //Group books by author and calculate the average rating for each author's books.
        System.out.println("\nAverage rating for each author's books:");
        bookCollection.stream()
                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.averagingInt(Book::getRating)))
                .forEach((author, averageRating) -> System.out.println(author + ": " + "\n" + "Average Rating: " + averageRating + "\n"));
        System.out.println("-------------------");


        //Calculate the total number of pages for all books (assuming each book has a fixed number of pages).
        System.out.println("\nTotal number of pages for all books:");
        int totalPages = bookCollection.stream()
                .mapToInt(Book::getPages)
                .sum();
        System.out.println(totalPages);
        System.out.println("-------------------");


        //6.4 Chaining and Composition - Chain multiple Stream operations together to perform complex tasks, such as filtering and sorting.
        //6.5 Collecting Results - Use terminal operations like collect, forEach, or reduce to collect and display the results of your Stream operations.

        //Find and display the title of the book with the highest rating, published after 1999
        highestRatedBookBySpecificPublishingYear(bookCollection, 1999, 1);

        //Stream operations - reduce() - Combine the elements of a stream into a single result
        booksByRating(bookCollection, 1799);

        //Stream operations - anyMatch() - Check if any element of a stream matches a condition
        System.out.println(isBookRatedValue(bookCollection, 10));
    }

    //Method to find and display the title of the book with the lowest rating, published after a specific year
    private static void booksByRating(Collection<Book> bookCollection, int i) {
        System.out.println("\nBook with the lowest rating, published after " + i + ":");
        bookCollection.stream()
                .filter(book -> book.getPublicationYear() > i)
                .reduce((book1, book2) -> book1.getRating() < book2.getRating() ? book1 : book2)
                .ifPresent(book -> System.out.println("Title - " + book.getTitle() + "\nPublished -  " + book.getPublicationYear() + "\nRating - " + book.getRating()));
        System.out.println("-------------------");
    }

    //Method to find and display the title of the book with the highest rating, published before a specific year
    private static void highestRatedBookBySpecificPublishingYear(Collection<Book> books, int publishYear, int limitValue) {
        System.out.println("\nBook with the highest rating, published before " + publishYear + ":");
        books.stream()
                .filter(book -> book.getPublicationYear() < publishYear)
                .sorted((book1, book2) -> book2.getRating() - book1.getRating())
                .limit(limitValue)
                .forEach(System.out::println);
        System.out.println("-------------------");
    }

    //Method to check if any element of a stream matches a condition
    private static boolean isBookRatedValue(Collection<Book> books, int ratingValue) {
        System.out.println("\nIs there a book with rating " + ratingValue + "?");
        boolean anyBookWithRating = books.stream()
                .anyMatch(book -> book.getRating() == ratingValue);
        return anyBookWithRating;
    }

    //Method to find and display the title of the book with the highest rating
    private static void highestRating(Collection<Book> books, int limitValue) {
        books.stream()
                .sorted((book1, book2) -> book2.getRating() - book1.getRating())
                .limit(limitValue)
                .forEach(System.out::println);
        System.out.println("-------------------");
    }

    //Method to create a collection of Book objects
    private static Collection<Book> createBook() {
        Collection<Book> books = List.of(
                new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954, 1000, 3),
                new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997, 223, 2),
                new Book("The Little Prince", "Antoine de Saint-Exupéry", 1943, 96, 1),
                new Book("A Game of Thrones", "George R.R. Martin", 1996, 694, 7),
                new Book("The Hobbit", "J.R.R. Tolkien", 1937, 310, 2),
                new Book("And Then There Were None", "Agatha Christie", 1939, 272, 8),
                new Book("Dream of the Red Chamber", "Cao Xueqin", 1791, 2500, 3),
                new Book("The Lion, the Witch and the Wardrobe", "C.S. Lewis", 1950, 206, 9),
                new Book("She: A History of Adventure", "H. Rider Haggard", 1887, 320, 5),
                new Book("The Da Vinci Code", "Dan Brown", 2003, 454, 1),
                new Book("The Catcher in the Rye", "J.D. Salinger", 1951, 234, 1),
                new Book("The Hobbit", "J.R.R. Tolkien", 1937, 310, 2)
        );
        return books;
    }
}