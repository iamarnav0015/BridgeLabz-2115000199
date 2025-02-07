class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String describe() {
        return name + " is " + age + " years old.";
    }

    public void makeSound() {
        throw new UnsupportedOperationException("Subclasses must implement this method.");
    }
}

class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof!");
    }
}

class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow!");
    }
}

class Bird extends Animal {
    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Chirp!");
    }
}

public class AnimalHierarchyTest {
    public static void main(String[] args) {
        Animal dog = new Dog("Buddy", 3);
        Animal cat = new Cat("Whiskers", 2);
        Animal bird = new Bird("Tweety", 1);
        Animal[] animals = {dog, cat, bird};
        for (Animal animal : animals) {
            System.out.println(animal.describe());
            animal.makeSound();
            System.out.println("-");
        }
    }
}
