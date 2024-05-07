import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    private static final String COMMA_DELIMITER = ",";

    public List<Item> readItemsCSV(String path) {
        List<Item> items = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] itemData = line.split(COMMA_DELIMITER);
                String name = itemData[0].trim();
                int cost = Integer.parseInt(itemData[1].trim());
                int weight = Integer.parseInt(itemData[2].trim());
                items.add(new Item(name, cost, weight, 0)); // Assuming pricePerPound is not specified in CSV
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return items;
    }
}
