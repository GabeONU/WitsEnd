import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    private static final String COMMA_DELIMITER = ",";

    public List<Item> readItems(String path) {
        List<Item> items = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(COMMA_DELIMITER);
                if (parts.length == 2) {
                    String itemName = parts[0].trim();
                    int itemPrice = Integer.parseInt(parts[1].trim());
                    // Create a new Item object and add it to the list
                    Item item = new Item(itemName, itemPrice, 0);
                    items.add(item);
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
