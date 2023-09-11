import java.util.Scanner;
public class l215819_Book {
    static int nextId = 1; // Static variable to auto-increment the ID
    private int id;
    private String title;
    private String author;
    private int year;

    public l215819_Book(String t, String a, int y) {
    this.id = nextId++; // Assign the next available ID and increment it
    this.title = t;
    this.author = a;
    this.year = y;
    }

    public void display() {
    System.out.println("ID: " + id + " Title: " + title + " by " + author + "(" + year + ")");
    }
//int Book::nextId = 1; // Initialize the static ID counter
public static void main(String[] args) {
    String title, author;
    int year;
    Scanner sc = new Scanner(System.in);
    char ch = 'y';
    while (ch == 'y'){
    System.out.print("Enter the title of the book: ");
    title = sc.nextLine();
    System.out.print("Enter the author of the book: ");
    author = sc.nextLine();
    System.out.print("Enter the year of publication of the book: ");
    year = sc.nextInt();
    sc.nextLine(); // Ignore the newline character
    l215819_Book book = new l215819_Book(title, author, year);
    book.display();
    System.out.print("Continue? y/n ");
    ch = sc.next().charAt(0);
    if (ch == 'N' || ch == 'n')
    break;}
    sc.close();
    }
}