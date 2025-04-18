import java.io.*;
import java.util.ArrayList;

public class WeatherDataIO {
    public static ArrayList<WeatherData> readCSV(String fileName){
        ArrayList<WeatherData> listWeather = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            if ((line = reader.readLine()) != null && line.startsWith("Year")) {

            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found" + fileName);
        } catch (IOException e) {
            System.err.println("Error reading" + e.getMessage());
        }
    }
}
