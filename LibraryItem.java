package com.mycompany.l215819.scd.a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LibraryItem implements Configuration {
    Scanner sc = new Scanner(System.in);
    static int arraySize = 100;
    public static String[] Array = new String[arraySize];
    public static int Index = 0;
    private String title;
    private String author;
    private int year;
    private String publisherCompany;
    private int popularityCount;
    private int price;
    private String date;
    public void loader(){
        String fileName = "data.txt";
    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
        String line;
        while ((line = reader.readLine()) != null && Index < arraySize) {
            Array[Index] = line;
            Index++;
        }
        System.out.println("\nLoaded items from file "+fileName);
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
    public void AddItem(LibraryItem item) {
        item.AddItemCon();
    }
    public void EditItem(int id) {
        EditItemCon(id);
    }
    public void DeleteItem(int id) {
        DeleteItemCon(id);
    }
    public void ViewAll(LibraryItem item) {
        item.ViewAllCon();
    }
    public void ViewAllItems() {
        ViewAllItemsCon();
    }
    public void ViewItemById(int id) {
        ViewItemByIdCon(id);
    }
    @Override
    public void ViewAllItemsCon() {
    if (Index == 0){
        System.out.println("No items found");
    }
    else {
    for (int i = 0; i < Index; i++) {
        System.out.println(Array[i]);
    }}
    }
    @Override
    public void AddItemCon() {
        System.out.println("Generic Add Item Function");
    }
    @Override
    public void EditItemCon(int id) {
        String item = Array[id-1];
        if (id == 0 || id > Index)
        System.out.println("ID not found.");
        else{
        char itemType = item.charAt(0);
        if (itemType == '1'){
            String element = Array[id-1];
            String[] words = element.split(",");
            title = words[1];
            author = words[2];
            words[3] = words[3].trim();
            year = Integer.parseInt(words[3]);
            words[4] = words[4].trim();
            popularityCount = Integer.parseInt(words[4]);
            words[5] = words[5].trim();
            price = Integer.parseInt(words[5]);
                if (id == 0 || id > Index)
                System.out.println("Book ID not found.");
                else{
                    System.out.print("What do you want to edit?\n1. Book title\n2. Book author\n3. Publication year\n4. Popularity count\n5. Price\nEnter: ");
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
                        case '4':
                    System.out.print("Edit book popularity count: ");
                    popularityCount = sc.nextInt();
                        break;
                        case '5':
                    System.out.print("Edit book price: ");
                    price = sc.nextInt();
                        break;
                        default:
                        break;}
                    String book = "1,"+title+","+author+", "+year+", "+popularityCount+", "+price;
                    Array[id-1] = book;
                }
                System.out.println("This book has been edited: "+Array[id-1]);
        }
        else if (itemType == '2'){
            String element = Array[id-1];
            char[] str = element.toCharArray();
                int a;
                title = "";
            for (a=2; str[a]!=',';a++){
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
                if (id == 0 || id > Index)
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
                    String magazine = "2,"+title+","+author+".,"+publisherCompany+", "+popularityCount+", "+price;
                    Array[id-1] = magazine;
                }
                System.out.println("This magazine has been edited: "+Array[id-1]);
        }
        else if (itemType == '3'){
            String element = Array[id-1];
            String[] words = element.split(",");
            title = words[1];
            publisherCompany = words[2];
            words[3] = words[3].trim();
            popularityCount = Integer.parseInt(words[3]);
            date = words[4];
                if (id == 0 || id > Index)
                System.out.println("Newspaper ID not found.");
                else{
                    System.out.print("What do you want to edit?\n1. Newspaper title\n2. Newspaper publisher name\n3. Date\n4. Popularity count\nEnter: ");
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
                        case '4':
                    System.out.print("Edit popularity count: ");
                    popularityCount = sc.nextInt();
                        break;
                        default:
                        break;}
                    String newspaper = "3,"+title+","+publisherCompany+", "+popularityCount+","+date;
                    Array[id-1] = newspaper;
                }
                System.out.println("This newspaper has been edited: "+Array[id-1]);
        }
        else
        System.out.println("ItemType is invalid.");}
    }
    @Override
    public void DeleteItemCon(int id) {
        String item = Array[id-1];
        if (id == 0 || id > Index)
        System.out.println("ID not found.");
        else{
            for (int l=id-1; l<Index; l++){
            Array[l] = "";
            Array[l] = Array[l+1];}
            Index--;
        }
        System.out.println("This item has been deleted: "+item);
    }
    @Override
    public void ViewAllCon() {
        System.out.println("Generic View All Items Function");
    }
    @Override
    public void ViewItemByIdCon(int id) {
        if (id == 0 || id > Index)
        System.out.println("ID not found.");
        else
        System.out.println(Array[id-1]);
    }
    public void HotPicks() {
        String [] HotPicksArray = new String[Index];
        for (int m = 0; m<Index; m++){
        HotPicksArray[m] = Array[m];
        }
        for (int i = 0; i<Index-1; i++) {
            for (int j = i; j<Index; j++) {
                int popCnt1 = getPopularityCount(HotPicksArray[i]);
                int popCnt2 = getPopularityCount(HotPicksArray[j]);
                if (popCnt1 > popCnt2) {
                    String temp = HotPicksArray[i];
                    HotPicksArray[i] = HotPicksArray[j];
                    HotPicksArray[j] = temp;
                }
            }
        }
        for (int l = 0; l<Index; l++){
            System.out.println(HotPicksArray[l]);
        }
    }
    public int getPopularityCount(String item) {
        int popCnt = 0;
        char itemType = item.charAt(0);
        if (itemType == '1'){
            String[] words = item.split(",");
            words[4] = words[4].trim();
            popCnt = Integer.parseInt(words[4]);
        }
        else if (itemType == '2'){
            char[] str = item.toCharArray();
                int a;
                title = "";
            for (a=2; str[a]!=',';a++){
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
            popCnt = Integer.parseInt(temp);
        }
        else if (itemType == '3'){
            String[] words = item.split(",");
            words[3] = words[3].trim();
            popCnt = Integer.parseInt(words[3]);
        }
        return popCnt;
    }
}
