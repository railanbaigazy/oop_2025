package lab7.Pet;

public class Cat extends Animal implements Pet {
    private String name;

    public Cat() {
        super(4);
    }
    public Cat(String name) {
        super(4);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public void play() {
        System.out.println(this.name + " likes to play with string.");
    }

    @Override
    public void eat() {
        System.out.println("Cats like to eat spiders and fish.");
    }
}
