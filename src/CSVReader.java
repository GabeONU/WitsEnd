/**
 * Description: 
 * Author: Julian Calvelage, Enzo Bordogna and Gabe Parry
 * Date: 5/9/2024
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides functionality to read items from a CSV file.
 */
public class CSVReader {

    /**
     * Delimiter used in the CSV file.
     */
    private static final String COMMA_DELIMITER = ",";

    /**
     * Reads items from the specified CSV file.
     *
     * @param path the path to the CSV file
     * @return a list of items read from the CSV file
     */
    public List<Item> readItems(String path) {
        List<Item> items = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(COMMA_DELIMITER);
                if (parts.length == 3) {
                    String itemName = parts[0].trim();
                    int itemPrice = Integer.parseInt(parts[1].trim());
                    // Create a new Item object and add it to the list
                    Item item = new Item(itemName, itemPrice, 0, 0);
                    items.add(item);
                    System.out.println("Added item: " + item);
                } else {
                    System.err.println("Invalid line in CSV: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return items;
    }
}
