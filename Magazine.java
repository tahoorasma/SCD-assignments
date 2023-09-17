package com.mycompany.l215819.scd.a1;

public class Magazine extends LibraryItem {
    private final int itemType;
    private String title;
    private String author;
    private String publisherCompany;
    private int popularityCount;
    private int price;

    public Magazine() {
        itemType = 2;
        title = "";
        author = "";
        publisherCompany = "";
        popularityCount = 0;
        price = 0;
    }
    public Magazine(String tit, String aut, String pComp, int pCount, int pr) {
        itemType = 2;
        title = tit;
        author = aut;
        publisherCompany = pComp;
        popularityCount = pCount;
        price = pr;
    }
    @Override
    public void AddItemCon() {
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
        String magazine = itemType+", "+title+", "+author+"., "+publisherCompany+", "+popularityCount+", "+price;
        Array[Index] = magazine;
        Index++;
        Borrower.BorrowArray[Borrower.idx] = "false"+", "+magazine;
        Borrower.idx++;
        System.out.println("A new magazine \""+title+" by "+publisherCompany+" ("+author+")\" has been added to items!");
    }
    @Override
    public void ViewAllCon() {
        String [] arr = new String[Index];
        String magazine = "";
        int in = 0;
        for (int i = 0; i<Index; i++){
            magazine = Array[i];
            char it = magazine.charAt(0);
            if (it == '2'){
            arr[in] = Array[i];
            in++;
            }
        }
    if (in == 0){
        System.out.println("No magazine found");
    }
    else {
    for (int l = 0; l < in; l++) {
        System.out.println(arr[l]);
    }}
    }
}
