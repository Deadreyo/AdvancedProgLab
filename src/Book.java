import java.time.LocalDate;
import java.util.Scanner;

abstract public class Book {
    
    public static void main(String[] args) {
        int inputCount = 0;
        System.out.println("Enter number of books: ");
        Scanner scanner = new Scanner(System.in);
        inputCount = scanner.nextInt();
        Book[] books = new Book[inputCount];

        for (int i = 0; i < inputCount; i++) {
            System.out.println("Enter book type (1 - TextBook, 2 - AudioBook): ");
            int bookType = scanner.nextInt();
            System.out.println("Enter book title: ");
            String title = scanner.next();
            System.out.println("Enter book price: ");
            double price = scanner.nextDouble();
            System.out.println("Enter book date released (yyyy-mm-dd): ");
            String dateReleased = scanner.next();
            LocalDate date = LocalDate.parse(dateReleased);
            if (bookType == 1) {
                System.out.println("Enter book pages count: ");
                int pagesCount = scanner.nextInt();
                books[i] = new TextBook(title, price, date, pagesCount);
            } else if (bookType == 2) {
                System.out.println("Enter book duration: ");
                int duration = scanner.nextInt();
                books[i] = new AudioBook(title, price, date, duration);
            }
        }
        scanner.close();

        for(Book book : books) {
            book.print();
        }
    }

    private static int idCounter = 0;
    private int id;
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    private String title;
    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    private LocalDate dateReleased;
    public LocalDate getDateReleased() {
        return dateReleased;
    }


    public void setDateReleased(LocalDate dateReleased) {
        this.dateReleased = dateReleased;
    }

    private double price;

    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }


    public Book(String title, double price, LocalDate dateReleased) {
        this.title = title;
        this.price = price;
        id = idCounter++;
        this.dateReleased = dateReleased;
    }



    abstract void print();

    abstract public String toString();
    abstract public boolean Equals(Book obj);
}


class TextBook extends Book {
    
    private int pagesCount;

    public int getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }

    public TextBook(String title, double price, LocalDate dateReleased, int pagesCount) {
        super(title, price, dateReleased);
        this.pagesCount = pagesCount;
    }

    @Override
    void print() {
        System.out.println("TextBook: " + getTitle() + " " + getPrice() + " " + getDateReleased() + " " + getPagesCount());
    }

    @Override
    public String toString() {
        return "TextBook [pagesCount=" + pagesCount + ", getId()=" + getId() + ", getTitle()=" + getTitle()
                + ", getDateReleased()=" + getDateReleased() + ", getPrice()=" + getPrice() + "]";
    }

    @Override
    public boolean Equals(Book obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof TextBook == false) {
            return false;
        }
        TextBook book = (TextBook) obj;
        
        return book.getPagesCount() == this.getPagesCount()
                && book.getTitle().equals(this.getTitle())
                && book.getDateReleased().equals(this.getDateReleased());
    }
}

class AudioBook extends Book {
    
    private int duration;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public AudioBook(String title, double price, LocalDate dateReleased, int duration) {
        super(title, price, dateReleased);
        this.duration = duration;
    }

    @Override
    void print() {
        System.out.println("AudioBook: " + getTitle() + " " + getPrice() + " " + getDateReleased() + " " + getDuration());
    }

    @Override
    public String toString() {
        return "AudioBook [duration=" + duration + ", getId()=" + getId() + ", getTitle()=" + getTitle()
                + ", getDateReleased()=" + getDateReleased() + ", getPrice()=" + getPrice() + "]";
    }

    @Override
    public boolean Equals(Book obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof AudioBook == false) {
            return false;
        }
        AudioBook book = (AudioBook) obj;
        
        return book.getDuration() == this.getDuration()
                && book.getTitle().equals(this.getTitle())
                && book.getDateReleased().equals(this.getDateReleased());
    }
}
