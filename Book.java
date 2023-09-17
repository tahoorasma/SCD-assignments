package com.mycompany.l215819.scd.a1;

public class Book extends LibraryItem {
    private final int itemType;
    private String title;
    private String author;
    private int year;
    private int popularityCount;
    private int price;

    public Book() {
        itemType = 1;
        title = "";
        author = "";
        year = 0;
        popularityCount = 0;
        price = 0;
    }
    public Book(String tit, String aut, int yr, int pCount, int pr) {
        itemType = 1;
        title = tit;
        author = aut;
        year = yr;
        popularityCount = pCount;
        price = pr;
    }
    @Override
    public void AddItemCon() {
        System.out.print("Enter the title of the book: ");
        title= sc.nextLine();
        System.out.print("Enter the author of the book: ");
        author = sc.nextLine();
        System.out.print("Enter the year of publication of the book: ");
        year = sc.nextInt();
        System.out.print("Enter the popularity count of the book: ");
        popularityCount = sc.nextInt();
        System.out.print("Enter the price of the book: ");
        price = sc.nextInt();
        String book = itemType+", "+title+", "+author+", "+year+", "+popularityCount+", "+price;
        Array[Index] = book;
        Index++;
        Borrower.BorrowArray[Borrower.idx] = "false"+", "+book;
        Borrower.idx++;
        System.out.println("A new book \""+title+" by "+author+"("+year+")\" has been added to items!");
    }
    @Override
    public void ViewAllCon() {
        String [] arr = new String[Index];
        String book;
        int in = 0;
        for (int i = 0; i<Index; i++){
            book = Array[i];
            char it = book.charAt(0);
            if (it == '1'){
            arr[in] = Array[i];
            in++;
            }
        }
    if (in == 0){
        System.out.println("No book found");
    }
    else {
        for (int l = 0; l < in; l++) {
        System.out.println(arr[l]);
        }
    }
    }
}
