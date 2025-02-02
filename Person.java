public class Person {
    private String name;
    private int age;

    public Person(String name,int age){
        this.name=name;
        this.age=age;

    }
    public Person(Person other){
        this.name=other.getName();
        this.age= other.getAge();

    }
    public String getName(){
        return name;
    }
    public void setName(String Name){
        this.name=name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;

    }
    public void displayInfo(){
        System.out.println("Name"+ name);
        System.out.println("Age"+ age);
    }
    public static void main(String[]args) {
        Person person1 = new Person("Alice", 30);
        person1.displayInfo();
        System.out.println();

        Person person2 = new Person(person1);
        person2.displayInfo();

        System.out.println();

        // Modifying person2's attributes using setters
        person2.setName("Bob");
        person2.setAge(25);
        person2.displayInfo();
    }
}
