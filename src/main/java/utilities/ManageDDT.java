package utilities;

import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class ManageDDT extends CommonOps{

    // Method Name: getDataObject
    // Method Description: This method provides the data from <DDTFile> (DDTFiles/users.csv)
    // Method Parameters: None
    // Method Return: Object[][] (file)
    @DataProvider(name = "data-provider-users")
    public Object[][] getDataObject(){
        return getDataFromCSV(getData("DDTFile")); // <DDTFile> = ./DDTFiles/users.csv
    }

    // Method Name: readCSV
    // Method Description: This method reads lines from a csv file
    // Method Parameters: String
    // Method Return: List<String>
    public static List<String> readCSV(String csvFile){
        List<String> lines = null;
        File file = new File (csvFile);
        try {
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    // Method Name: getDataFromCSV
    // Method Description: This method gets the data from a csv file
    // Method Parameters: String
    // Method Return: Object[][]
    public static Object[][] getDataFromCSV(String filePath) {
        Object[][] data = new Object[3][2];
        List<String> csvData = readCSV(filePath);
        for (int i = 0; i < csvData.size(); i++) {
            data[i][0] = csvData.get(i).split(",")[0];
            data[i][1] = csvData.get(i).split(",")[1];
        }
        return data;
    }
}
