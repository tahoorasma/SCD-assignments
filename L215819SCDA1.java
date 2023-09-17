package com.mycompany.l215819.scd.a1;

import java.util.Scanner;

public class L215819SCDA1 {

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    LibraryItem item = new LibraryItem();
    item.loader();

    Borrower borrow = new Borrower();

    int id = 0;
    char ch = 'y';
        while(ch == 'y' || ch == 'Y'){
        int op = 0;
        System.out.print("\n1. Hot Picks!\n2. Borrow an Item\n3. Add an Item\n4. Edit an Item\n5. Delete an Item\n6. View All Items\n7. View Item by ID\n8. View Borrowers List\n9. Exit\nEnter your choice: ");
        if (sc.hasNext()){
        op = sc.nextInt();
        sc.nextLine();
        System.out.println();
        switch(op){
            case 1:
                item.HotPicks();
            break;
            case 2:
                System.out.print("Enter your name: ");
                String name = sc.nextLine();
                System.out.print("Enter id: ");
                id = sc.nextInt();
                borrow.BorrowItem(name, id);
            break;
            case 3:
                char n1 = '0';
                System.out.print("1. Add Book\n2. Add Magazine\n3. Add Newspaper\nEnter choice: ");
                if (sc.hasNext()){
                n1 = sc.next().charAt(0);
                sc.nextLine();
                System.out.println();
                switch(n1){
                    case '1':
                Book book = new Book();
                item.AddItem(book);
                    break;
                    case '2':
                Magazine magazine = new Magazine();
                item.AddItem(magazine);
                    break;
                    case '3':
                Newspaper newspaper = new Newspaper();
                item.AddItem(newspaper);
                    break;
                    default:
                System.out.println("Invalid input");
                    break;}
                }
            break;
            case 4:
                System.out.print("Enter id: ");
                id = sc.nextInt();
                item.EditItem(id);
            break;
            case 5:
                System.out.print("Enter id: ");
                id = sc.nextInt();
                item.DeleteItem(id);
            break;
            case 6:
                char n4 = '0';
                System.out.print("1. Books\n2. Magazines\n3. Newspapers\n4. All items\nEnter choice: ");
                if (sc.hasNext()){
                n4 = sc.next().charAt(0);
                sc.nextLine();
                System.out.println();
                switch(n4){
                    case '1':
                Book book = new Book();
                item.ViewAll(book);
                    break;
                    case '2':
                Magazine magazine = new Magazine();
                item.ViewAll(magazine);
                    break;
                    case '3':
                Newspaper newspaper = new Newspaper();
                item.ViewAll(newspaper);
                    break;
                    case '4':
                item.ViewAllItems();
                    break;
                    default:
                System.out.println("Invalid input");
                    break;}
                }
            break;
            case 7:
                System.out.print("Enter id: ");
                id = sc.nextInt();
                item.ViewItemById(id);
            break;
            case 8:
            borrow.ViewBorrowersList();
            break;
            case 9:
                System.out.println("Program Exit succesfully!\n");
                System.exit(0);
            break;
            default:
                System.out.println("Invalid input");
            break; 
            }
        } else {
            System.out.println("No input available.");
            break;
        }
    System.out.print("\nContinue? y/n ");
    if (sc.hasNext()) {
        ch = sc.next().charAt(0);
        sc.nextLine();
    } else {
        System.out.println("No input available.");
        break;
    }
    if (ch == 'N' || ch == 'n'){
        System.out.println("\nApplication terminated!\n");
    break;}
}
sc.close();
}
}
