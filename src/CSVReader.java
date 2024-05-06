import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JList;

public class CSVReader {

    private static final String COMMA_DELIMITER = ",";
    public ArrayList<String> list = new ArrayList<String>();

    public ArrayList<String> readCSV(String path){
        String[] thing = null;
        int count = 0;
        int index = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            //loops for every line in the csv file with the items
            while ((line = br.readLine()) != null) {
            	
            	thing = line.split(COMMA_DELIMITER); // puts all the comma seperated values into an array per line
            	
                for (int i = 0; i < thing.length; i++) {
                    list.add(thing[i]);
                }

                count++;
                index++;
                
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return list;
    }
}
