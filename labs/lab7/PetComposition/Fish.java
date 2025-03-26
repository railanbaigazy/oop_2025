package lab7.PetComposition;

public class Fish extends Animal implements Pet {
    private final Nameable nameable = new NameableImpl();

    public Fish() {
        super(0);
    }

    @Override
    public void eat() {
        System.out.println("Fish eat pond scum.");
    }

    @Override
    public String getName() {
        return nameable.getName();
    }

    @Override
    public void setName(String name) {
        nameable.setName(name);
    }

    @Override
    public void play() {
        System.out.println("Just keep swimming.");
    }
}