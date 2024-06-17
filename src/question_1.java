class Animal {
    static void sound(){
        System.out.println("animal sounds");
    }
}
class Dog extends Animal{
    static void sound(){
        System.out.println("bark");

    }
}
class Cat extends Animal{
    static void sound(){
        System.out.println("meow");
    }
}

public class question_1 {
    public static void main(String[] args) {
        Dog obj1 = new Dog();
        Cat obj2 = new Cat();
        obj1.sound();
        obj2.sound();
    }
}
