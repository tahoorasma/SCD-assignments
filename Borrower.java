package com.mycompany.l215819.scd.a1;

public class Borrower {
    private String borrower = "";
    private String BorrowStatus = "false";
    private double Cost;
    public static int idx = LibraryItem.Index;
    public static String [] BorrowArray = new String[100];
    public static int Bidx = 0;
    public static String [] BorrowerArray = new String[100];
    Borrower(){
    for (int i = 0; i<idx; i++){
        BorrowArray[i] = BorrowStatus+", "+LibraryItem.Array[i];
    }
    }
    public void setPopularityCount(int id) {
        String str = LibraryItem.Array[id-1];
        char itemType = str.charAt(0);
        if (itemType == '1'){
            String[] words = str.split(",");
            String title = words[1];
            String author = words[2];
            words[3] = words[3].trim();
            int year = Integer.parseInt(words[3]);
            words[4] = words[4].trim();
            int popularityCount = Integer.parseInt(words[4]);
            words[5] = words[5].trim();
            int price = Integer.parseInt(words[5]);
            popularityCount++;
            String book = "1,"+title+","+author+", "+year+", "+popularityCount+", "+price;
            LibraryItem.Array[id-1] = book;
            BorrowArray[id-1] = book;
        }
        else if (itemType == '2'){
            char[] ch = str.toCharArray();
                int a;
                String title = "";
            for (a=2; ch[a]!=',';a++){
                title = title+ch[a];
            }
            a++;
                String author="";
            for (; ch[a]!='.';a++){
                author = author+ch[a];
            }
            a++;
            a++;
                String publisherCompany = "";
            for (; ch[a]!=',';a++){
                publisherCompany = publisherCompany+ch[a];
            }
            a++;
                int popularityCount;
                String temp = "";
            for (a++; ch[a]!=',';a++){
                temp = temp+ch[a];
            }
            popularityCount = Integer.parseInt(temp);
            a++;
                int price;
                temp = "";
            for (a++; a<str.length()-1; a++){
                temp = temp+ch[a];
            }
            price = Integer.parseInt(temp);
            popularityCount++;
            String magazine = "2,"+title+","+author+".,"+publisherCompany+", "+popularityCount+", "+price;
            LibraryItem.Array[id-1] = magazine;
            BorrowArray[id-1] = magazine;
        }
        else if (itemType == '3'){
            String[] words = str.split(",");
            String title = words[1];
            String publisherCompany = words[2];
            words[3] = words[3].trim();
            int popularityCount = Integer.parseInt(words[3]);
            String date = words[4];
            popularityCount++;
            String newspaper = "3,"+title+","+publisherCompany+", "+popularityCount+","+date;
            LibraryItem.Array[id-1] = newspaper;
            BorrowArray[id-1] = newspaper;
        }
    }
    public void BorrowItem(String s, int id){
        borrower = s;
        if (id == 0 || id > idx)
        System.out.println("ID not found.");
        else{
        String [] words = BorrowArray[id-1].split(",");
        BorrowStatus = words[0];
        if (BorrowStatus.equals("false")) {
            setPopularityCount(id);
            BorrowStatus = "true";
            BorrowArray[id-1] = BorrowStatus+", "+LibraryItem.Array[id-1];
            System.out.println("\nBorrow details\nBorrowed by: "+borrower);
            CostOfBorrowingAnItem(LibraryItem.Array[id-1]);
            BorrowerArray[Bidx] = BorrowerArray[Bidx]+"\nBorrowed by: "+borrower;
            Bidx++;        
        }
        else {
            System.out.println("Cannot borrow this item.\nThis item has already been borrowed.");
        } 
    }
    }
    public void CostOfBorrowingAnItem(String str){
        char itemType = str.charAt(0);
        if (itemType == '1'){
            String[] words = str.split(",");
            String title = words[1];
            String author = words[2];
            words[3] = words[3].trim();
            int year = Integer.parseInt(words[3]);
            words[4] = words[4].trim();
            int popularityCount = Integer.parseInt(words[4]);
            words[5] = words[5].trim();
            int price = Integer.parseInt(words[5]);
            Cost = price + (0.2 * price) + 200;
            String s = "Book Title: "+title+"\nBook Author: "+author+"\nPublishing Year: "+year+"\nPopularity Count: "+popularityCount+"\nCost (incl. Tax): Rs."+Cost;
            BorrowerArray[Bidx] = s;
            System.out.println(s);
        }
        else if (itemType == '2'){
            char[] ch = str.toCharArray();
                int a;
                String title = "";
            for (a=2; ch[a]!=',';a++){
                title = title+ch[a];
            }
            a++;
                String author="";
            for (; ch[a]!='.';a++){
                author = author+ch[a];
            }
            a++;
            a++;
                String publisherCompany = "";
            for (; ch[a]!=',';a++){
                publisherCompany = publisherCompany+ch[a];
            }
            a++;
                int popularityCount;
                String temp = "";
            for (a++; ch[a]!=',';a++){
                temp = temp+ch[a];
            }
            popularityCount = Integer.parseInt(temp);
            a++;
                int price;
                temp = "";
            for (a++; a<str.length()-1; a++){
                temp = temp+ch[a];
            }
            price = Integer.parseInt(temp);
            Cost = price * popularityCount;
            String s = "Magazine Title: "+title+"\nMagazine Author(s): "+author+"\nPublisher Company: "+publisherCompany+"\nPopularity Count: "+popularityCount+"\nCost: Rs."+Cost;
            BorrowerArray[Bidx] = s;
            System.out.println(s);
        }
        else if (itemType == '3'){
            String[] words = str.split(",");
            String title = words[1];
            String publisherCompany = words[2];
            words[3] = words[3].trim();
            int popularityCount = Integer.parseInt(words[3]);
            String date = words[4];
            Cost = 10;
            String s = "Newspaper Title: "+title+"\nPublisher Company: "+publisherCompany+"\nDate: "+date+"\nPopularity Count: "+popularityCount+"\nCost: Rs."+Cost+" (+Rs.5 Publisher charges)";
            BorrowerArray[Bidx] = s;
            System.out.println(s);
        }
    }
    public void ViewBorrowersList(){
        if (Bidx == 0)
        System.out.println("No current data.");
        else {
        for (int i = 0; i<Bidx; i++){
            System.out.println(BorrowerArray[i]+'\n');
        }}
    }
}