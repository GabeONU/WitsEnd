import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Item> items;

    public Store() {
        items = new ArrayList<>();
        setupItems();
    }

    private void setupItems() {
        List<String[]> itemsData = new ArrayList<>();
        itemsData.add(new String[]{"Bedroll", "15", "5"});
        itemsData.add(new String[]{"Blacksmithing Tools", "200", "10"});
        itemsData.add(new String[]{"Books", "75", "3"});
        itemsData.add(new String[]{"Medicine", "10", "1"});
        itemsData.add(new String[]{"Cast Iron Stove", "300", "20"});
        itemsData.add(new String[]{"Chair", "20", "8"});
        itemsData.add(new String[]{"Cookware & Eating Utensils", "75", "4"});
        itemsData.add(new String[]{"Granny's Clock", "15", "3"});
        itemsData.add(new String[]{"Gun Making Tools", "200", "12"});
        itemsData.add(new String[]{"Keepsakes", "40", "2"});
        itemsData.add(new String[]{"Lead Shot", "25", "6"});
        itemsData.add(new String[]{"Mirror", "15", "2"});
        itemsData.add(new String[]{"Gunpowder", "80", "5"});
        itemsData.add(new String[]{"Tent & Gear", "150", "15"});
        itemsData.add(new String[]{"Tools", "50", "7"});
        itemsData.add(new String[]{"Toys", "15", "1"});

        for (String[] itemData : itemsData) {
            String name = itemData[0];
            int weight = Integer.parseInt(itemData[1]);
            int price = Integer.parseInt(itemData[2]);
            items.add(new Item(name, weight, price));
        }
    }

    public List<Item> getItems() {
        return items;
    }
}
