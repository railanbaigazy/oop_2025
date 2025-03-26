package lab7.PetComposition;

public abstract class Animal {
    
    protected int legs;
    
    public Animal(int legs) {
        this.legs = legs;
    }

    public abstract void eat();
    
}