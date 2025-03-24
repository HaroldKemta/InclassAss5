// harold kemta

import java.util.*;

public class DogManager {
    private List<Dog> dogs;

    // Constructor
    public DogManager() {
        this.dogs = new ArrayList<>();
    }

    // Add Dog (only if the name is unique)
    public boolean addDog(Dog dog) {
        for (Dog d : dogs) {
            if (d.getName().equalsIgnoreCase(dog.getName())) {
                return false;  // Duplicate name found
            }
        }
        dogs.add(dog);
        return true;
    }

    // Remove Dog by Name
    public boolean removeDog(String name) {
        Iterator<Dog> iterator = dogs.iterator();
        while (iterator.hasNext()) {
            Dog d = iterator.next();
            if (d.getName().equalsIgnoreCase(name)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    // Search Dog by Name
    public Dog searchDog(String name) {
        for (Dog d : dogs) {
            if (d.getName().equalsIgnoreCase(name)) {
                return d;
            }
        }
        return null;
    }

    // Sort Dogs by Age
    public void sortDogsByAge() {
        dogs.sort(Comparator.comparingInt(Dog::getAge));
    }

    // Get List of All Dogs
    public List<Dog> getAllDogs() {
        return dogs;
    }
}
