import java.io.*;
import java.util.*;

public class WeatherDataIO {
    private static ArrayList<WeatherData> listWeather = new ArrayList<>();

    public static ArrayList<WeatherData> readCSV(String fileName){

        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            if ((line = reader.readLine()) != null && line.startsWith("Year")) {

            }

            while ((line = reader.readLine()) != null) {
                try{

                    String[] section = line.split(",");
                    if(section.length >= 6 && !section[1].isEmpty() && !section[2].isEmpty()
                            && !section[3].isEmpty() && !section[4].isEmpty() && !section[6].isEmpty()) {
                        try {
                            int year = Integer.parseInt(section[1]);
                            int month = Integer.parseInt(section[2]);
                            float maxTemp = Float.parseFloat(section[3]);
                            float minTemp = Float.parseFloat(section[4]);
                            float rainAmount = Float.parseFloat(section[6]);

                            WeatherData items = new WeatherData(year, month, maxTemp, minTemp, rainAmount);
                            listWeather.add(items);
                        } catch (NumberFormatException e) {
                            System.err.println("Invalid number " + line);
                        }
                    } else {
                        System.err.println("Incomplete line " + line);
                    }
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e){
                    System.err.println("Invalid Line" + line);
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found" + fileName);
        } catch (IOException e) {
            System.err.println("Error reading" + e.getMessage());
        }
        return listWeather;
    }

    public static ArrayList<WeatherData> getAllWeatherData(){
        return listWeather;
    }
    public static void searchWeatherData(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a year between 1948 and 2024 to search for: ");

        //This is the user input
        int inputtedYear;
        try {
            inputtedYear = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid Year.");
            return;
        }

        boolean found = false;

        for (WeatherData items: listWeather)  {
            if (items.getYear() == inputtedYear) {
                System.out.printf("%-6d %-7d %-8.1f %-8.1f %-8.1f %-10.1f\n",
                        items.getYear(), items.getMonth(), items.getMaxTemp(),
                        items.getMinTemp(), items.getMeanTemp(), items.getRainAmount());
                found = true;
            }
        }
    }
    public static void getAverageRainfallByYear(){}

    public static void getAverageTemperatureByYear(){}

    public static void get3Coldest(){}

    public static void get3Hottest(){}
}
