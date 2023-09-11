import java.util.Scanner;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class l215819_Library {
    static int nextId = 1; // Static variable to auto-increment the ID
    private int id;
    private String title;
    private String author;
    private int year;
    int arraySize = 100;
    private String[] dataArray = new String[arraySize];
    int index = 0;

    public void loader() {
        String fileName = "books.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null && index < arraySize) {
                dataArray[index] = line;
                index++;
            }
            System.out.println("\nLoaded books from file "+fileName+'\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ViewAllBooks(){
        for (int i = 0; i < index; i++) {
                System.out.println(dataArray[i]);
            }
    }

    public void AddBook() {
    Scanner scc = new Scanner(System.in);
    System.out.print("Enter the title of the book: ");
    title= scc.nextLine();
    System.out.print("Enter the author of the book: ");
    author = scc.nextLine();
    System.out.print("Enter the year of publication of the book: ");
    year = scc.nextInt();
    String book = title+", "+author+", "+year+'\n';
    dataArray[index] = book;
    index++;
    //scc.close();
    System.out.println("A new book has been added!");
    }

    public void ViewBookById(int i){
        if (i == 0 || i > index)
        System.out.println("Book ID not found.");
        else
        System.out.println(dataArray[i-1]+'\n');
    }

    public void EditBook(int i){
    Scanner sc = new Scanner(System.in);
    String element = dataArray[i-1];
    String[] words = element.split(",");
    title = words[0];
    author = words[1];
    words[2] = words[2].trim();
    year = Integer.parseInt(words[2]);
        if (i == 0 || i > index)
        System.out.println("Book ID not found.");
        else{
            System.out.print("What do you want to edit?\n1. Book title\n2. Book author\n3. Publication year\nEnter: ");
            char op = sc.next().charAt(0);
            switch(op){
                case '1':
            System.out.print("Edit book title: ");
            title = sc.next();
                break;
                case '2':
            System.out.print("Edit book author: ");
            author = sc.next();
                break;
                case '3':
            System.out.print("Edit book publication year: ");
            year = sc.nextInt();
                break;
                default:
                break;}
            String book = title+", "+author+", "+year;
            dataArray[i-1] = book;
        }
        System.out.println("This book has been edited: "+dataArray[i-1]);
    }

    public void DeleteBook(int i){
        String book = dataArray[i-1];
        if (i == 0 || i > index)
        System.out.println("Book ID not found.");
        else{
            for (int l=i-1; l<index; l++){
            dataArray[l] = "";
            dataArray[l] = dataArray[l+1];}
            index--;
        }
        System.out.println("This book has been deleted: "+book);
    }
    
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    l215819_Library library = new l215819_Library();
    library.loader();
    int id = 0;
    char a = 'y';
        while(a == 'y'){
        int op = 0;
        System.out.print("1. Add a book\n2. Edit a book\n3. Delete a book\n4. View all books\n5. View book by ID\n6. Exit\nEnter your choice: ");
        if (sc.hasNext()){
        op = sc.nextInt();
        sc.nextLine();
        System.out.println();
        switch(op){
                case 1:
                library.AddBook();
                break;
                case 2:
                System.out.print("Enter id: ");
                id = sc.nextInt();
                library.EditBook(id);
                break;
                case 3:
                System.out.print("Enter id: ");
                id = sc.nextInt();
                library.DeleteBook(id);
                break;
                case 4:
                library.ViewAllBooks();
                break;
                case 5:
                System.out.print("Enter id: ");
                id = sc.nextInt();
                library.ViewBookById(id);
                break;
                case 6:
                System.exit(0);
                break;
                default:
                System.out.println("Invalid input");
                break;}
            } else {
                    System.out.println("No input available.");
                    break;
                }
            System.out.print("\nContinue? y/n ");
            if (sc.hasNext()) {
                a = sc.next().charAt(0);
                sc.nextLine();
            } else {
                System.out.println("No input available.");
                break;
            }
            if (a == 'N' || a == 'n')
            break;
        }
    sc.close();
    }
}