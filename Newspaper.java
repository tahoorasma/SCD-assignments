package com.mycompany.l215819.scd.a1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Newspaper extends LibraryItem {
    private final int itemType;
    private String title;
    private String publisherCompany;
    private int popularityCount; 
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    String formattedDate = sdf.format(date);

    public Newspaper() {
        itemType = 3;
        title = "";
        publisherCompany = "";
    }
    public Newspaper(String tit, String pComp) {
        itemType = 3;
        title = tit;
        publisherCompany = pComp;
    }
    @Override
    public void AddItemCon() {
        System.out.print("Enter the title of the newspaper: ");
        title= sc.nextLine();
        System.out.print("Enter the publisher company name: ");
        publisherCompany = sc.nextLine();
        System.out.print("Enter the popularity count of the newspaper: ");
        popularityCount = sc.nextInt();
        String newspaper = itemType+", "+title+", "+publisherCompany+", "+popularityCount+", "+formattedDate;
        Array[Index] = newspaper;
        Index++;
        Borrower.BorrowArray[Borrower.idx] = "false"+", "+newspaper;
        Borrower.idx++;
        System.out.println("A newspaper \""+title+" by "+publisherCompany+"("+formattedDate+")\" has been added to items!");
    }
    @Override
    public void ViewAllCon() {
        String [] arr = new String[Index];
        String newspaper = "";
        int in = 0;
        for (int i = 0; i<Index; i++){
            newspaper = Array[i];
            char it = newspaper.charAt(0);
            if (it == '3'){
            arr[in] = Array[i];
            in++;
            }
        }
    if (in == 0){
        System.out.println("No Newspaper found");
    }
    else {
    for (int l = 0; l < in; l++) {
        System.out.println(arr[l]);
    }}
    }
}