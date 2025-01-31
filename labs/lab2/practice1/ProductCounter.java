package lab2.practice1;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ProductCounter {
    // Create a Counting Map
    private final HashMap<String, Integer> productCount = new HashMap<>();
    // Create a Name Mapping Map
    private final TreeMap<String, String> productNames;

    public static void main(String[] args) {
        // List of part data
        String[] parts = new String[]{"1S01", "1S01", "1S01", "1S01", "1S01", "1S02", "1S02", "1S02", "1H01", "1H01", "1S02", "1S01", "1S01", "1H01", "1H01", "1H01", "1S02", "1S02", "1M02", "1M02", "1M02"};

        // Create Product Name Part Number map
        Map<String, String> productNames = new TreeMap<>();
        productNames.put("Blue Polo Shirt", "1S01");
        productNames.put("Black Polo Shirt", "1S02");
        productNames.put("Red Ball Cap", "1H01");
        productNames.put("Duke Mug", "1M02");

        // Create Product Counter Object and process data
        ProductCounter pc = new ProductCounter(productNames);
        pc.processList(parts);
        pc.printReport();
    }

    public ProductCounter(Map<String, String> productNames) {
        this.productNames = new TreeMap<>(productNames);
    }

    public void processList(String[] list) {
        for (String product : list) {
            if (productCount.containsKey(product)) {
                productCount.put(product, productCount.get(product) + 1);
            } else {
                productCount.put(product, 1);
            }
        }
    }

    public void printReport() {
        System.out.println("===== Product Count =====");

        int maxLen = 0;
        for (String product : productNames.keySet()) {
            maxLen = Math.max(maxLen, product.length());
        }

        for (String name : productNames.keySet()) {
            String formattedName = String.format("%-" + (maxLen + 7) + "s", name);
            System.out.println(formattedName + productCount.get(productNames.get(name)));
        }
        System.out.println("=".repeat(maxLen + 9));
    }
}
