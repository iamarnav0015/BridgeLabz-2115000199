public class Book {
    private String title;
    private String author;
    private double price;

    public Book(){
        this.title ="Unknown Title";
        this.author="Unknown Author";
        this.price=0.0;
    }
    public Book(String title , String author ,double price){
        this.title=title;
        this.author=author;
        this.price=price;
    }
    public void displayInfo(){
        System.out.println("Title"+ title);
        System.out.println("Author"+ author);
        System.out.println("Price:"+price);
    }
    public static void main(String[]args){
        Book defaultbook = new Book();
        System.out.println();

        Book customBook = new Book (" The Great Gatsby ",  " F. Scotth Fitzgerald ", 10.99);
        customBook.displayInfo();
    }
}
