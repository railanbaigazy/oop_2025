package lab2.practice3;

import java.util.Comparator;
import java.util.Map;
import java.util.Properties;
import java.util.PropertyPermission;

public class SortShirtByDesc implements Comparator<Shirt> {

    public int compare(Shirt s1, Shirt s2) {
        return s1.getDescription().compareTo(s2.getDescription());
    }
}
