import java.util.Scanner;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class l215819_Library_PartC {
    static int nextId = 1; // Static variable to auto-increment the ID
    private int id;
    private String title;
    private String author;
    private int year;
    private String publisherCompany;
    private int popularityCount;
    private int price;
    private String date;
    int arraySize = 100;
    private String[] booksArray = new String[arraySize];
    private String[] magazinesArray = new String[arraySize];
    private String[] newspapersArray = new String[arraySize];
    int bookIndex = 0; int magazineIndex = 0; int newspaperIndex = 0;

    public void loader() {
        String bookfileName = "books.txt";        
        String magazinefileName = "magazines.txt";
        String newspaperfileName = "newspapers.txt";

        try (BufferedReader readerB = new BufferedReader(new FileReader(bookfileName))) {
            String lineB;
            while ((lineB = readerB.readLine()) != null && bookIndex < arraySize) {
                booksArray[bookIndex] = lineB;
                bookIndex++;
            }
            System.out.println("\nLoaded books from file "+bookfileName+'\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader readerM = new BufferedReader(new FileReader(magazinefileName))) {
            String lineM;
            while ((lineM = readerM.readLine()) != null && magazineIndex < arraySize) {
                magazinesArray[magazineIndex] = lineM;
                magazineIndex++;
            }
            System.out.println("Loaded magazines from file "+magazinefileName+'\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader readerN = new BufferedReader(new FileReader(newspaperfileName))) {
            String lineN;
            while ((lineN = readerN.readLine()) != null && newspaperIndex < arraySize) {
                newspapersArray[newspaperIndex] = lineN;
                newspaperIndex++;
            }
            System.out.println("Loaded newspaper from file "+newspaperfileName+'\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ViewAllBooks(){
        for (int i = 0; i < bookIndex; i++) {
                System.out.println(booksArray[i]);
            }
    }
    public void ViewAllMagazines(){
        for (int i = 0; i < magazineIndex; i++) {
                System.out.println(magazinesArray[i]);
            }
    }
    public void ViewAllNewspapers(){
        for (int i = 0; i < newspaperIndex; i++) {
                System.out.println(newspapersArray[i]);
            }
    }

    public void AddBook() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the title of the book: ");
    title= sc.nextLine();
    System.out.print("Enter the author of the book: ");
    author = sc.nextLine();
    System.out.print("Enter the year of publication of the book: ");
    year = sc.nextInt();
    String book = title+", "+author+", "+year+'\n';
    booksArray[bookIndex] = book;
    bookIndex++;
    System.out.println("A new book has been added to the books file!");
    }
    public void AddMagazine() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the title of the magazine: ");
    title= sc.nextLine();
    System.out.print("Enter the authors of the magazine (comma separated): ");
    author = sc.nextLine();
    System.out.print("Enter the name of the publisher company: ");
    publisherCompany = sc.nextLine();
    System.out.print("Enter the popularity count: ");
    popularityCount = sc.nextInt();
    System.out.print("Enter the price of the magazine: ");
    price = sc.nextInt();
    String magazine = title+", "+author+"., "+publisherCompany+", "+popularityCount+", "+price+'\n';
    magazinesArray[magazineIndex] = magazine;
    magazineIndex++;
    System.out.println("A new magazine has been added to the magazines file!");
    }
    public void AddNewspaper() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the title of the newspaper: ");
    title= sc.nextLine();
    System.out.print("Enter the publisher company name: ");
    publisherCompany = sc.nextLine();
    System.out.print("Enter the date: ");
    date = sc.nextLine();
    String newspaper = title+", "+publisherCompany+", "+date+'\n';
    newspapersArray[newspaperIndex] = newspaper;
    newspaperIndex++;
    System.out.println("A newspaper has been added to the newspaper file!");
    }

    public void ViewBookById(int i){
        if (i == 0 || i > bookIndex)
        System.out.println("Book ID not found.");
        else
        System.out.println(booksArray[i-1]+'\n');
    }
    public void ViewMagazineById(int i){
        if (i == 0 || i > magazineIndex)
        System.out.println("Magazine ID not found.");
        else
        System.out.println(magazinesArray[i-1]+'\n');
    }
    public void ViewNewspaperById(int i){
        if (i == 0 || i > newspaperIndex)
        System.out.println("Newspaper ID not found.");
        else
        System.out.println(newspapersArray[i-1]+'\n');
    }

    public void EditBook(int i){
    Scanner sc = new Scanner(System.in);
    String element = booksArray[i-1];
    String[] words = element.split(",");
    title = words[0];
    author = words[1];
    words[2] = words[2].trim();
    year = Integer.parseInt(words[2]);
        if (i == 0 || i > bookIndex)
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
            booksArray[i-1] = book;
        }
        System.out.println("This book has been edited: "+booksArray[i-1]);
    }
    public void EditMagazine(int i){
    Scanner sc = new Scanner(System.in);
    String element = magazinesArray[i-1];
    char[] str = element.toCharArray();
        int a;
        title = "";
    for (a=0; str[a]!=',';a++){
        title = title+str[a];
    }
    a++;
        author="";
    for (; str[a]!='.';a++){
        author = author+str[a];
    }
    a++;
    a++;
        publisherCompany = "";
    for (; str[a]!=',';a++){
        publisherCompany = publisherCompany+str[a];
    }
    a++;
        popularityCount = 0;
        String temp = "";
    for (a++; str[a]!=',';a++){
        temp = temp+str[a];
    }
    popularityCount = Integer.parseInt(temp);
    a++;
        price = 0;
        temp = "";
    for (a++; a<element.length()-1; a++){
        temp = temp+str[a];
    }
    price = Integer.parseInt(temp);
        if (i == 0 || i > magazineIndex)
        System.out.println("Magazine ID not found.");
        else{
            System.out.print("What do you want to edit?\n1. Magazine title\n2. Magazine authors\n3. Publisher company\n4. Popularity count\n5. Price\nEnter: ");
            char op = sc.next().charAt(0);
            switch(op){
                case '1':
            System.out.print("Edit magazine title: ");
            title = sc.next();
                break;
                case '2':
            System.out.print("Edit magazine authors: ");
            author = sc.next();
                break;
                case '3':
            System.out.print("Edit publisher company of the magazine: ");
            publisherCompany = sc.next();
                break;
                case '4':
            System.out.print("Edit popularity count of the magazine: ");
            popularityCount = sc.nextInt();
                break;
                case '5':
            System.out.print("Edit price of the magazine: ");
            price = sc.nextInt();
                break;
                default:
                break;}
            String magazine = title+","+author+".,"+publisherCompany+", "+popularityCount+", "+price;
            magazinesArray[i-1] = magazine;
        }
        System.out.println("This magazine has been edited: "+magazinesArray[i-1]);
    }
    public void EditNewspaper(int i){
    Scanner sc = new Scanner(System.in);
    String element = newspapersArray[i-1];
    String[] words = element.split(",");
    title = words[0];
    publisherCompany = words[1];
    date = words[2];
        if (i == 0 || i > newspaperIndex)
        System.out.println("Newspaper ID not found.");
        else{
            System.out.print("What do you want to edit?\n1. Newspaper title\n2. Newspaper publisher name\n3. Date \nEnter: ");
            char op = sc.next().charAt(0);
            switch(op){
                case '1':
            System.out.print("Edit newspaper title: ");
            title = sc.next();
                break;
                case '2':
            System.out.print("Edit publisher company of the newspaper: ");
            publisherCompany = sc.next();
                break;
                case '3':
            System.out.print("Edit date: ");
            date = sc.next();
                break;
                default:
                break;}
            String newspaper = title+", "+publisherCompany+","+date;
            newspapersArray[i-1] = newspaper;
        }
        System.out.println("This newspaper has been edited: "+newspapersArray[i-1]);
    }

    public void DeleteBook(int i){
        String book = booksArray[i-1];
        if (i == 0 || i > bookIndex)
        System.out.println("Book ID not found.");
        else{
            for (int l=i-1; l<bookIndex; l++){
            booksArray[l] = "";
            booksArray[l] = booksArray[l+1];}
            bookIndex--;
        }
        System.out.println("This book has been deleted: "+book);
    }
    public void DeleteMagazine(int i){
        String magazine = magazinesArray[i-1];
        if (i == 0 || i > magazineIndex)
        System.out.println("Magazine ID not found.");
        else{
            for (int l=i-1; l<magazineIndex; l++){
            magazinesArray[l] = "";
            magazinesArray[l] = magazinesArray[l+1];}
            magazineIndex--;
        }
        System.out.println("This magazine has been deleted: "+magazine);
    }
    public void DeleteNewspaper(int i){
        String newspaper = newspapersArray[i-1];
        if (i == 0 || i > newspaperIndex)
        System.out.println("Newspaper ID not found.");
        else{
            for (int l=i-1; l<newspaperIndex; l++){
            newspapersArray[l] = "";
            newspapersArray[l] = newspapersArray[l+1];}
            newspaperIndex--;
        }
        System.out.println("This newspaper has been deleted: "+newspaper);
    }
    
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    l215819_Library_PartC library = new l215819_Library_PartC();
    library.loader();
    int id = 0;
    char a = 'y';
        while(a == 'y'){
        int op = 0;
        System.out.print("1. Add item\n2. Edit item\n3. Delete item\n4. View all items\n5. View item by ID\n6. Exit\nEnter your choice: ");
        if (sc.hasNext()){
        op = sc.nextInt();
        sc.nextLine();
        System.out.println();
        switch(op){
                case 1:
                char n1 = '0';
                System.out.print("1. Book\n2. Magazine\n3. Newspaper\nEnter choice: ");
                if (sc.hasNext()){
                n1 = sc.next().charAt(0);
                sc.nextLine();
                System.out.println();
                switch(n1){
                    case '1':
                library.AddBook();
                    break;
                    case '2':
                library.AddMagazine();
                    break;
                    case '3':
                library.AddNewspaper();
                    break;
                    default:
                System.out.println("Invalid input");
                    break;}
                }
                break;
                case 2:
                char n2 = '0';
                System.out.print("1. Book\n2. Magazine\n3. Newspaper\nEnter choice: ");
                if (sc.hasNext()){
                n2 = sc.next().charAt(0);
                sc.nextLine();
                System.out.println();
                switch(n2){
                    case '1':
                System.out.print("Enter id: ");
                id = sc.nextInt();
                library.EditBook(id);
                    break;
                    case '2':
                System.out.print("Enter id: ");
                id = sc.nextInt();
                library.EditMagazine(id);
                    break;
                    case '3':
                System.out.print("Enter id: ");
                id = sc.nextInt();
                library.EditNewspaper(id);
                    break;
                    default:
                System.out.println("Invalid input");
                    break;}
                }
                break;
                case 3:
                char n3 = '0';
                System.out.print("1. Book\n2. Magazine\n3. Newspaper\nEnter choice: ");
                if (sc.hasNext()){
                n3 = sc.next().charAt(0);
                sc.nextLine();
                System.out.println();
                switch(n3){
                    case '1':
                System.out.print("Enter id: ");
                id = sc.nextInt();
                library.DeleteBook(id);
                    break;
                    case '2':
                System.out.print("Enter id: ");
                id = sc.nextInt();
                library.DeleteMagazine(id);
                    break;
                    case '3':
                System.out.print("Enter id: ");
                id = sc.nextInt();
                library.DeleteNewspaper(id);
                    break;
                    default:
                System.out.println("Invalid input");
                    break;}
                }
                break;
                case 4:
                char n4 = '0';
                System.out.print("1. Book\n2. Magazine\n3. Newspaper\nEnter choice: ");
                if (sc.hasNext()){
                n4 = sc.next().charAt(0);
                sc.nextLine();
                System.out.println();
                switch(n4){
                    case '1':
                library.ViewAllBooks();
                    break;
                    case '2':
                library.ViewAllMagazines();
                    break;
                    case '3':
                library.ViewAllNewspapers();
                    break;
                    default:
                System.out.println("Invalid input");
                    break;}
                }
                break;
                case 5:
                char n5 = '0';
                System.out.print("1. Book\n2. Magazine\n3. Newspaper\nEnter choice: ");
                if (sc.hasNext()){
                n5 = sc.next().charAt(0);
                sc.nextLine();
                System.out.println();
                switch(n5){
                    case '1':
                System.out.print("Enter id: ");
                id = sc.nextInt();
                library.ViewBookById(id);
                    break;
                    case '2':
                System.out.print("Enter id: ");
                id = sc.nextInt();
                library.ViewMagazineById(id);
                    break;
                    case '3':
                System.out.print("Enter id: ");
                id = sc.nextInt();
                library.ViewNewspaperById(id);
                    break;
                    default:
                System.out.println("Invalid input");
                    break;}
                }
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