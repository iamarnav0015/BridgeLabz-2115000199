class Book{
    private String title;
    private int publicationYear;
    public Book(String title , int publicationYear){
        this.title=title;
        this.publicationYear=publicationYear;
    }
    public void displayInfo(){
        System.out.println("Book title :"+ title);
        System.out.println("Book PublicationYear"+ publicationYear);
    }

}
class Author extends Book{
    private String name;
    private String bio;
    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name=name;
        this.bio=bio;
    }
    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Author Name" + name);
        System.out.println("Author Bio" + bio);
    }

}
public class LibraryManagement{
    public static void main(String[] args) {
        Author book1 = new Author("The Great Gatsby",1925, " F.Scott Fitzgerald ", " American Novelist and short story writter ");
        book1.displayInfo();
    }

}