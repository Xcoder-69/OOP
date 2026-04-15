class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}

class Library {
    private int availableBooks;

    public Library(int availableBooks) {
        this.availableBooks = availableBooks;
    }

    public void issueBook(int count) throws BookNotAvailableException {
        if (count <= 0) {
            throw new IllegalArgumentException("Number of books to issue must be positive.");
        }
        if (count <= availableBooks) {
            availableBooks -= count;
            System.out.println("Book issued successfully. Books remaining: " + availableBooks);
        } else {
            throw new BookNotAvailableException("Requested books not available. Available: " + availableBooks + ", Requested: " + count);
        }
    }
}

public class Q22 {
    public static void main(String[] args) {
        Library library = new Library(3); // Initialize library with 3 available books

        System.out.println("Initial available books: 3");

        // Try issuing 2 books (valid)
        try {
            System.out.println("\nAttempting to issue 2 books...");
            library.issueBook(2);
        } catch (BookNotAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Try issuing 2 more books (should throw the custom exception)
        try {
            System.out.println("\nAttempting to issue 2 more books...");
            library.issueBook(2);
        } catch (BookNotAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Try issuing a negative number of books (should throw IllegalArgumentException)
        try {
            System.out.println("\nAttempting to issue -1 books...");
            library.issueBook(-1);
        } catch (BookNotAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}