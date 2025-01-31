//Define class
class CircleDetails{
    private double radius;
    //Constructor
    public CircleDetails(double radius){
        this.radius=radius;
    }
    // Method to display Circle details
    public void displayDetails(){
        System.out.println("Area of Circle: "+Math.PI*Math.pow(radius,2));
    }
}
//Main Class to Test
public class Circle {
    public static void main(String[] args) {
        CircleDetails C1=new CircleDetails(2.5);
        CircleDetails C2=new CircleDetails(4);
        System.out.println("\n-----Area of Circle 1-----");
        C1.displayDetails();
        System.out.println("\n-----Area of Circle 2-----");
        C2.displayDetails();
    }
}

