public class l215819_Library_PartD {

    public static class LibraryItem {
        public void displayItemDetails(LibraryItem item) {
            if (item instanceof Book) {
                Book book = (Book) item;
                System.out.println("Book Information:");
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Year: " + book.getYear());
            } else if (item instanceof Magazine) {
                Magazine magazine = (Magazine) item;
                System.out.println("Magazine Information:");
                System.out.println("Title: " + magazine.getTitle());
                System.out.println("Authors: " + magazine.getAuthor());
                System.out.println("Publisher Company: " + magazine.getPublisherCompany());
                System.out.println("Popularity Count: " + magazine.getPopularityCount());
                System.out.println("Price: Rs." + magazine.getPrice());
            } else if (item instanceof Newspaper) {
                Newspaper newspaper = (Newspaper) item;
                System.out.println("Newspaper Information:");
                System.out.println("Title: " + newspaper.getTitle());
                System.out.println("Publisher Company: " + newspaper.getPublisherCompany());
                System.out.println("Date: " + newspaper.getDate());
            } else {
                System.out.println("Invalid item type.");
            }
            System.out.println();
        }
    }
    
    public static class Book extends LibraryItem {
        private String title;
        private String author;
        private int year;
    
        public Book(String tit, String aut, int yr){
            title = tit;
            author = aut;
            year = yr;
        }
        public String getTitle() {
            return title;
        }
        public String getAuthor() {
            return author;
        }
        public int getYear() {
            return year;
        }
    }
    
    public static class Magazine extends LibraryItem {
        private String title;
        private String author;
        private String publisherCompany;
        private int popularityCount;
        private int price;
    
        public Magazine(String tit, String aut, String pComp, int pCount, int pr){
            title = tit;
            author = aut;
            publisherCompany = pComp;
            popularityCount = pCount;
            price = pr;
        }
        public String getTitle() {
            return title;
        }
        public String getAuthor() {
            return author;
        }
        public String getPublisherCompany() {
            return publisherCompany;
        }
        public int getPopularityCount() {
            return popularityCount;
        }
        public int getPrice() {
            return price;
        }
    }
    
    public static class Newspaper extends LibraryItem {
        private String title;
        private String publisherCompany;
        private String date;
    
        public Newspaper(String tit, String pComp, String dt){
            title = tit;
            publisherCompany = pComp;
            date = dt;
        }
        public String getTitle() {
            return title;
        }
        public String getPublisherCompany() {
            return publisherCompany;
        }
        public String getDate() {
            return date;
        }
    }    
    
public static void main(String[] args) {
    LibraryItem item = new LibraryItem();

    Book book = new Book ("The Book One", "Tahoor Asma", 2023);
    Magazine magazine = new Magazine ("The Magazine One", "Tahoor Asma", "Company X", 146, 2890);
    Newspaper newspaper = new Newspaper ("The Newspaper One", "The Y Company", "13-09-2023");
    
    item.displayItemDetails(book);
    item.displayItemDetails(magazine);
    item.displayItemDetails(newspaper);
    }
}