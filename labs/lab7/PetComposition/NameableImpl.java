package lab7.PetComposition;

public class NameableImpl implements Nameable {
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name.length() < 20) {
            this.name = name;
        } else {
            System.out.println("Name too long");
        }
    }
}
