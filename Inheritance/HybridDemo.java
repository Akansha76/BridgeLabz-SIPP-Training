//package Inheritance;

//interface 
interface Worker {
    void performDuties();          // contract every worker must fulfil
}

class Person {
    protected String name;
    protected int    id;

    Person(String name, int id) {
        this.name = name;
        this.id   = id;
    }
}


class Chef extends Person implements Worker {
    private String speciality;

    Chef(String name, int id, String speciality) {
        super(name, id);
        this.speciality = speciality;
    }

    @Override
    public void performDuties() {
        System.out.println(
            "Chef " + name + " (ID " + id + ") prepares " + speciality + " dishes."
        );
    }
}


class Waiter extends Person implements Worker {
    private int tablesAssigned;

    Waiter(String name, int id, int tablesAssigned) {
        super(name, id);
        this.tablesAssigned = tablesAssigned;
    }

    @Override
    public void performDuties() {
        System.out.println(
            "Waiter " + name + " (ID " + id + ") serves " + tablesAssigned + " tables."
        );
    }
}


public class HybridDemo {
    public static void main(String[] args) {
        Worker chef   = new Chef("Arjun", 1, "Italian");
        Worker waiter = new Waiter("Neha", 2, 5);

        chef.performDuties();
        waiter.performDuties();
    }
}
