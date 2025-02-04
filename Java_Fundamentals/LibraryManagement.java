import java.util.*;

class Library {
    ArrayList<Book> books;

    Library() 
    {
        books = new ArrayList<Book>();
    }

    void printBooks()
    {
        for(Book b : books)
        {
            b.printDetails();
        }
    }


    void addBook(Book b)
    {
        books.add(b);
    }
}

public class LibraryManagement
{
    public static void main(String[] args)
    {
        Book b1 = new Book("title1", "author1", 2022, 1);
        Book b2 = new Book("title2", "author2", 2023, 2);
        Book b3 = new Book("title3", "author3", 2024, 3);
        Book b4 = new Book("title4", "author4", 2021, 4);

        Library lib = new Library();
        
        lib.addBook(b1);
        lib.addBook(b2);
        lib.addBook(b3);
        lib.addBook(b4);

        lib.printBooks();
    }
}

class Book {
    String title;
    String author;
    int publicationYear;
    int isbn;

    Book(String title, String author, int publicationYear, int isbn) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
    }

    // method to print the details of the book.
    void printDetails()
    {
        System.out.println("Title of book is : "+ this.title);
        System.out.println("Author of book is : "+ this.author);
        System.out.println("Publication year of book is : "+ this.publicationYear);
        System.out.println("ISBN number of book is : "+ this.isbn);
    }

}
