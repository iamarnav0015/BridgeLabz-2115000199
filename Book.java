//Define class
class BookDetails{
    private String title,author;
    private double price;
    //Constructor
    public BookDetails(String title,String author,double price){
        this.title=title;
        this.author=author;
        this.price=price;
    }
    // Method to display Book details
    public void display(){
        System.out.println("Title of the Book: "+title);
        System.out.println("Author of the Book: "+author);
        System.out.println("Price of the Book: "+price);
    }
}
//Main Class to Test
public class Book {
    public static void main(String[] args) {
        BookDetails B1=new BookDetails("The Merchant of Venece","William Shakesphere",250);
        BookDetails B2=new BookDetails("The Tempest","William Shakesphere",350);
        System.out.println("\n---Book 1---");
        B1.display();
        System.out.println("\n---Book 2---");
        B2.display();
    }
}