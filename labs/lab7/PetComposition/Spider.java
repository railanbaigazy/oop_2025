package lab7.PetComposition;

public class Spider extends Animal {

    private final Ambulatory ambulatory;
    
    public Spider() {
        super(8);
        ambulatory = new AmbulatoryImpl(8);
    }

    @Override
    public void eat() {
        System.out.println("The spider eats a fly.");
    }

    public void walk() {
        ambulatory.walk();
    }
    
}