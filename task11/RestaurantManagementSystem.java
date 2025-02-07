interface Worker {
    void performDuties();
}

class Person {
    protected String name;
    protected int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

class Chef extends Person implements Worker {
    public Chef(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        displayInfo();
        System.out.println("Duties: Cooking delicious meals and managing kitchen operations.");
    }
}

class Waiter extends Person implements Worker {
    public Waiter(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        displayInfo();
        System.out.println("Duties: Serving customers, taking orders, and ensuring a pleasant dining experience.");
    }
}

public class RestaurantManagementSystem {
    public static void main(String[] args) {
        Worker chef = new Chef("Gordon Ramsay", 101);
        Worker waiter = new Waiter("John Doe", 202);

        System.out.println("Restaurant Workers Duties:");
        chef.performDuties();
        System.out.println();
        waiter.performDuties();
    }
}
