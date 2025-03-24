// made by Harold kemta


public class Dog {
    private String name;
    private DogBreed breed;
    private int age;
    private double weight;

    // Default Constructor
    public Dog() {
        this.name = "Unknown";
        this.breed = DogBreed.OTHER;
        this.age = 0;
        this.weight = 1.0;
    }

    // Parameterized Constructor
    public Dog(String name, DogBreed breed, int age, double weight) {
        this.name = (name != null && !name.trim().isEmpty()) ? name : "Unknown";
        this.breed = (breed != null) ? breed : DogBreed.OTHER;
        this.age = (age >= 0) ? age : 0;
        this.weight = (weight >= 0) ? weight : 1.0;
    }

    // Getters
    public String getName() { return name; }
    public DogBreed getBreed() { return breed; }
    public int getAge() { return age; }
    public double getWeight() { return weight; }

    // Setters (Mutators) with Validation
    public void setName(String name) {
        this.name = (name != null && !name.trim().isEmpty()) ? name : this.name;
    }

    public void setBreed(DogBreed breed) {
        this.breed = (breed != null) ? breed : DogBreed.OTHER;
    }

    public void setAge(int age) {
        this.age = (age >= 0) ? age : this.age;
    }

    public void setWeight(double weight) {
        this.weight = (weight >= 0) ? weight : this.weight;
    }

    // Equals Method
    public boolean equals(Dog other) {
        return other != null &&
                this.name.equals(other.name) &&
                this.breed == other.breed &&
                this.age == other.age &&
                this.weight == other.weight;
    }

    // toString Method
    @Override
    public String toString() {
        return "[Dog] Name: " + name + " | Breed: " + breed + " | Age: " + age + " | Weight: " + weight;
    }
}
