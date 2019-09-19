import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {

    public static void main(String[] args) {
        Book[] books = initBooks();
        Author[] authors = initAuthors();
        assignAuthorsToBooks(authors, books);
// check if some/all book(s) have more than 200 pages;
        System.out.println("--------------------------------");
        List<String> booksWith200Pages = Arrays.stream(books)
                .peek(book -> System.out.println(book.getTitle()))
                .filter(book -> book.getNumberOfPages() > 200)
                .peek(book -> System.out.println(book.getTitle()))
                .map(Book::getTitle)
                .collect(Collectors.toList());
        System.out.println("--------------------------------");
        System.out.println(booksWith200Pages);
        System.out.println("--------------------------------");
// find the books with max and min number of pages
        Comparator<Book> bookPageComparator = (o1, o2) -> o1.getNumberOfPages() > o2.getNumberOfPages() ? 1 : -1;
        Comparator<Book> bookTitleComparator = Comparator.comparing(Book::getTitle);
// the book with max number of pages
        Arrays.stream(books)
                .max(bookPageComparator)
                .map(Book::getTitle)
                .ifPresent(System.out::println);

        System.out.println("--------------------------------");
// the book with min number of pages
        Arrays.stream(books)
                .min(bookPageComparator)
                .map(Book::getTitle)
                .ifPresent(System.out::println);

        System.out.println("--------------------------------");
// filter books with only single author
        List<String> booksWithOneAuthor = Arrays.stream(books)
                .filter(book -> book.getAuthors().size() == 1)
                .map(Book::getTitle)
                .collect(Collectors.toList());
        System.out.println(booksWithOneAuthor);

        System.out.println("--------------------------------");
// sort the books by number of pages
        Arrays.stream(books)
                .sorted(bookPageComparator)
                .map(Book::getTitle)
                .forEach(System.out::println);

        System.out.println("--------------------------------");
// sort the book by title
        Arrays.stream(books)
                .sorted(bookTitleComparator)
                .map(Book::getTitle)
                .forEach(System.out::println);

        System.out.println("--------------------------------");
// get list of all titles
        List<String> titles = Arrays.stream(books)
                .map(Book::getTitle)
                .collect(Collectors.toList());
// print them using forEach method
        titles.forEach(System.out::println);

        System.out.println("--------------------------------");
// get distinct list of all authors
        List<String> distinctAuthors = Arrays.stream(books)
                .map(Book::getAuthors)
                .flatMap(Collection::stream)
                .distinct()
                .map(Author::getName)
                .collect(Collectors.toList());

        System.out.println(distinctAuthors);

// use the Option type for determining the title of the biggest book of some author

        Arrays.stream(authors)
                .filter(author -> author.getBooks().size() > 1)
                .map(Author::getBooks)
                .flatMap(Collection::stream)
                .max(bookPageComparator)
                .map(Book::getTitle)
                .ifPresent(System.out::println);

    }

    private static void assignAuthorsToBooks(Author[] authors, Book[] books) {
        books[0].getAuthors().add(authors[0]);
        books[0].getAuthors().add(authors[2]);

        books[1].getAuthors().add(authors[2]);
        books[1].getAuthors().add(authors[3]);

        books[2].getAuthors().add(authors[1]);

        authors[0].getBooks().add(books[0]);

        authors[1].getBooks().add(books[0]);
        authors[1].getBooks().add(books[1]);

        authors[2].getBooks().add(books[3]);

        authors[3].getBooks().add(books[2]);
    }

    private static Author[] initAuthors() {
        Author a1 = new Author();
        a1.setName("Lois Lowry");
        a1.setAge((short) 35);
        Author a2 = new Author();
        a2.setName("Clive Staples Lewis");
        a2.setAge((short) 42);
        Author a3 = new Author();
        a3.setName("Katherine Paterson");
        a3.setAge((short) 38);
        Author a4 = new Author();
        a4.setName("Pamela Travers");
        a4.setAge((short) 44);

        return new Author[]{a1, a2, a3, a4};
    }

    private static Book[] initBooks() {
        Book b1 = new Book();
        b1.setTitle("Number the Stars");
        b1.setNumberOfPages(320);
        Book b2 = new Book();
        b2.setTitle("The Chronicles of Narnia");
        b2.setNumberOfPages(215);
        Book b3 = new Book();
        b3.setTitle("Bridge to Terabithia");
        b3.setNumberOfPages(160);
        Book b4 = new Book();
        b4.setTitle("Mary Poppins");
        b4.setNumberOfPages(185);

        return new Book[]{b1, b2, b3, b4};
    }
}
