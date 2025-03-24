package lab7.Pet;

public class PetMain {

    public static void main(String[] args) {
        Animal a;
        //test a spider with a spider reference
        Spider s = new Spider();
        s.eat();
        s.walk();
        //test a spider with an animal reference
        a = new Spider();
        a.eat();
        a.walk();

        Pet p;

        Fish f = new Fish();
        f.setName("Sazanski");
        f.eat();
        f.walk();
        f.play();
        a = new Fish();
        a.eat();
        a.walk();
        p = new Fish();
        p.setName("Lechanski");
        p.play();

        Cat c = new Cat("Margauski");
        c.setName("Margau");
        c.eat();
        c.walk();
        c.play();
        a = new Cat();
        a.eat();
        a.walk();
        p = new Cat("Tom");
        System.out.println("Name: " + p.getName());
        p.play();

        System.out.println("===Playing===");
        playWithAnimal(s);
        playWithAnimal(f);
        playWithAnimal(c);
    }
    
    public static void playWithAnimal(Animal a) {
        if (a instanceof Pet) {
            Pet p = (Pet) a;
            p.play();
        } else {
            System.out.println("Danger! Wild Animal");
        }
    }
    
}