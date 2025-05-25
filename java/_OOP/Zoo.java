package _OOP;

class Animal {
    String name;
    int age;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

class Mammal extends Animal {
    Mammal(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println("Mammal sound");
    }
}

class Bird extends Animal {
    Bird(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println("Bird sound");
    }
}

public class Zoo {
    public static void main(String[] args) {
        Animal genericAnimal = new Animal("Generic Animal", 5);
        Mammal lion = new Mammal("Lion", 3);
        Bird eagle = new Bird("Eagle", 2);

        genericAnimal.makeSound();
        lion.makeSound();
        eagle.makeSound();
    }
}
