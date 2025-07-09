class Animal {
    String name;
    int age;
    Animal(String name,int age){
        this.name=name;
        this.age=age;
    }
    void makeSound(){
        System.out.println("Animal make sound");
    }
}
class Dog extends Animal{
    Dog(String name,int age){
        super(name,age);
    }
    @Override
    void makeSound(){
       System.out.println("Dog bark "+name);
   }
}
class Cat extends Animal{
    Cat(String name,int age){
        super(name, age);
    }
    @Override
    void makeSound(){
       System.out.println("Cat make sound meow meow "+name);
   }
}
public class AnimalTest{
    public static void main(String[] args) {
        Animal dog=new Dog("Buddy",10);
        Animal cat=new Cat("Dangy",5);

       dog.makeSound();
       cat.makeSound();
    }
}
