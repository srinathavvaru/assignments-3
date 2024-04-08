class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }

    // Method overloading
    public void eat() {
        System.out.println("Animal eats");
    }

    public void eat(String food) {
        System.out.println("Animal eats " + food);
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }

    // Method overriding
    @Override
    public void eat() {
        System.out.println("Dog eats bones");
    }
}

public class overloading {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.makeSound(); // Output: Animal makes a sound
        animal.eat(); // Output: Animal eats
        animal.eat("grass"); // Output: Animal eats grass

        Dog dog = new Dog();
        dog.makeSound(); // Output: Dog barks
        dog.eat(); // Output: Dog eats bones
        dog.eat("meat"); // Output: Animal eats meat
    }
}
