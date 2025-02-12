package lab3.practice2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindText {

    private String fileName = "labs/lab3/practice2/gettys.html";
    // Create Pattern
    private Pattern pattern;
    // Create Matcher
    private Matcher matcher;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the pattern: ");
        String pt = sc.nextLine();

        FindText find = new FindText();
        find.run(pt);
    }

    public void run(String pt) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = "";
            pattern = Pattern.compile(pt);
            int c = 1;
            while ((line = reader.readLine()) != null) {
                // Generate a matcher based on Pattern
                matcher = pattern.matcher(line);
                // Search for text
                if (matcher.find()) {
                    System.out.println(" " + c + " " + line);
                }
                c++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
