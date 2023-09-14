public class l215819_Library_PartE {

    public interface Configuration {
        void displayInfo();
    }

    public static class LibraryItem implements Configuration {
        public void displayItemDetails(LibraryItem item) {
            item.displayInfo();
        }

        @Override
        public void displayInfo() {
            System.out.println("Generic Item Information:");
            System.out.println("This is a generic library item.");
        }
    }

    public static class Book extends LibraryItem {
        private String title;
        private String author;
        private int year;

        public Book(String tit, String aut, int yr) {
            title = tit;
            author = aut;
            year = yr;
        }

        @Override
        public void displayInfo() {
            System.out.println("Book Information:");
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("Year: " + year);
            System.out.println();
        }
    }

    public static class Magazine extends LibraryItem {
        private String title;
        private String author;
        private String publisherCompany;
        private int popularityCount;
        private int price;

        public Magazine(String tit, String aut, String pComp, int pCount, int pr) {
            title = tit;
            author = aut;
            publisherCompany = pComp;
            popularityCount = pCount;
            price = pr;
        }

        @Override
        public void displayInfo() {
            System.out.println("Magazine Information:");
            System.out.println("Title: " + title);
            System.out.println("Authors: " + author);
            System.out.println("Publisher Company: " + publisherCompany);
            System.out.println("Popularity Count: " + popularityCount);
            System.out.println("Price: Rs." + price);
            System.out.println();
        }
    }

    public static class Newspaper extends LibraryItem {
        private String title;
        private String publisherCompany;
        private String date;

        public Newspaper(String tit, String pComp, String dt) {
            title = tit;
            publisherCompany = pComp;
            date = dt;
        }

        @Override
        public void displayInfo() {
            System.out.println("Newspaper Information:");
            System.out.println("Title: " + title);
            System.out.println("Publisher Company: " + publisherCompany);
            System.out.println("Date: " + date);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LibraryItem item = new LibraryItem();

        Book book = new Book("The Book One", "Tahoor Asma", 2023);
        Magazine magazine = new Magazine("The Magazine One", "Tahoor Asma", "Company X", 146, 2890);
        Newspaper newspaper = new Newspaper("The Newspaper One", "The Y Company", "13-09-2023");

        item.displayItemDetails(book);
        item.displayItemDetails(magazine);
        item.displayItemDetails(newspaper);
    }
}