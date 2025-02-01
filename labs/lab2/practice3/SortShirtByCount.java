package lab2.practice3;

import java.util.Comparator;

public class SortShirtByCount implements Comparator<Shirt> {

    public int compare(Shirt s1, Shirt s2) {
        Long c1 = s1.getCount();
        Long c2 = s2.getCount();
        return c1.compareTo(c2);
    }
}
