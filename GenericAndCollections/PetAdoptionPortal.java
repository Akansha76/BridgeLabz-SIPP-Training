import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Pet class
class Pet {
    private String type;
    private int age;
    private boolean isAdopted;

    public Pet(String type, int age, boolean isAdopted) {
        this.type = type;
        this.age = age;
        this.isAdopted = isAdopted;
    }

    public String getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    public boolean isAdopted() {
        return isAdopted;
    }

    public void setAdopted(boolean adopted) {
        isAdopted = adopted;
    }

    @Override
    public String toString() {
        return type + " | Age: " + age + " | Adopted: " + isAdopted;
    }
}

// PetPortal class with Generics
class PetPortal<T extends Pet> {
    private List<T> pets = new ArrayList<>();

    public void addPet(T pet) {
        pets.add(pet);
    }

    public List<T> filterAvailablePets(String type, int maxAge) {
        return pets.stream()
                   .filter(p -> !p.isAdopted() && p.getType().equalsIgnoreCase(type) && p.getAge() <= maxAge)
                   .collect(Collectors.toList());
    }

    public void displayAllPets() {
        for (T pet : pets) {
            System.out.println(pet);
        }
    }
}

// Main class
public class PetAdoptionPortal {
    public static void main(String[] args) {
        PetPortal<Pet> portal = new PetPortal<>();

        // Adding pets
        portal.addPet(new Pet("Dog", 2, false));
        portal.addPet(new Pet("Cat", 1, false));
        portal.addPet(new Pet("Dog", 4, true));
        portal.addPet(new Pet("Bird", 1, false));

        System.out.println("=== All Pets in Portal ===");
        portal.displayAllPets();

        System.out.println("\n=== Available Dogs (Age <= 3) ===");
        List<Pet> availableDogs = portal.filterAvailablePets("Dog", 3);
        for (Pet pet : availableDogs) {
            System.out.println(pet);
        }
    }
}
