import java.util.Scanner;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class l215819_Library {
    static int nextId = 1; // Static variable to auto-increment the ID
    private int id;
    private String title;
    private String author;
    private int year;

    public void AddBook() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the title of the book: ");
    title= sc.nextLine();
    System.out.print("Enter the author of the book: ");
    author = sc.nextLine();
    System.out.print("Enter the year of publication of the book: ");
    year = sc.nextInt();
    try {
            File file = new File("library.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String word = scanner.next();
                if (word.equals("Id:")){
                    word = scanner.next();
                    id = Integer.parseInt(word);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    id++; // Assign the next available ID and increment it
    try {
        BufferedWriter writer = new BufferedWriter(new FileWriter("library.txt",true));
        String book = "Id: "+id+"\nTitle: "+title+"\nAuthor: "+author+"\nPublication Year: "+year+'\n';
        writer.write(book);
        writer.newLine();
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    sc.close();
    }

    public void ViewAllBooks(){
        try {
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader("library.txt"));
            String books;
            while ((books = reader.readLine()) != null) {
                System.out.println(books);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ViewBookById(int i){
        boolean flag = false;
            try (BufferedReader reader = new BufferedReader(new FileReader("library.txt"))) {
            File file = new File("library.txt");
            String line;
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String word = scanner.next();
                if (word.equals("Id:")){
                line = reader.readLine();
                    word = scanner.next();
                    if (i == (Integer.parseInt(word))){
                        flag = true;
                    System.out.print("Book info for ID: "+i+"\n");
                for (int l=0; l<3; l++){
                line = reader.readLine();
                System.out.println(line);}
                    break;
                    }
                for (int l=0; l<4; l++){
                line = reader.readLine();}
                }
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (flag == false)
        System.out.println("Book ID not found.");
    }
    
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    l215819_Library library = new l215819_Library();
    char a = 'y';
        while(a == 'y'){
        System.out.print("1. Add a book\n2. View all books\n3. View book by ID\n4. Exit\nEnter your choice: ");
        char op = sc.next().charAt(0);
        switch(op){
                case '1':
                library.AddBook();
                break;
                case '2':
                library.ViewAllBooks();
                break;
                case '3':
                int id = 0;
                System.out.print("Enter id: ");
                id = sc.nextInt();
                library.ViewBookById(id);
                break;
                case '4':
                break;
                default:
                System.out.println("Invalid input");
                break;}
            System.out.print("/nContinue? y/n ");
            a = sc.next().charAt(0);
            if (a == 'N' || a == 'n')
            break;
        }
    sc.close();
    }
}