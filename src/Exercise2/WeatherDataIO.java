package Exercise2;

import java.io.*;
import java.util.*;

public class WeatherDataIO {
    private static ArrayList<WeatherData> listWeather = new ArrayList<>();
    //DECLARING THE ARRAY LIST
    public static ArrayList<WeatherData> readCSV(String fileName) {

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            // This is skip the header when comparing the data in the csv
            if ((line = reader.readLine()) != null && line.startsWith("Year")) {

            }

            while ((line = reader.readLine()) != null) {
                try {
                    //This part splits the CSV file into lines
                    String[] section = line.split(",");
                    //In the Heathrow.csv file there is a section of missing data however
                    //this part is to allow the program to read the csv file and find the parts it needs
                    // as some columns are empty. The only columns needed are year, month, max/min temperature, and rain amount
                    // since the csv file has more columns than i want to see it lowers the length to around 6
                    if (section.length >= 6 && !section[1].isEmpty() && !section[2].isEmpty()
                            && !section[3].isEmpty() && !section[4].isEmpty() && !section[6].isEmpty()) {
                        try {
                            int year = Integer.parseInt(section[1]);
                            int month = Integer.parseInt(section[2]);
                            float maxTemp = Float.parseFloat(section[3]);
                            float minTemp = Float.parseFloat(section[4]);
                            float rainAmount = Float.parseFloat(section[6]);

                            WeatherData items = new WeatherData(year, month, maxTemp, minTemp, rainAmount);
                            listWeather.add(items);
                        } catch (NumberFormatException e) { //Exception handling on if numbers in the csv are invalid
                            System.err.println("Invalid number " + line);
                        }
                    } else { // Exception handling to find if any row has missing information
                        System.err.println("Incomplete line " + line);
                    } //Exception Handling
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.err.println("Invalid Line" + line);
                }
            }
            //Exception handling for checkinf if the file exists
        } catch (FileNotFoundException e) {
            System.err.println("File not found" + fileName);
        } catch (IOException e) {
            System.err.println("Error reading" + e.getMessage());
        }
        return listWeather;
    }

    public static ArrayList<WeatherData> getAllWeatherData() {
        return listWeather;
        //Just prints out all the data in the csv that we chose to see
    }

    public static void searchWeatherData() {
        //This part takes in a user input for a specific year they want to see the data for
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a year between 1948 and 2024 to search for: ");

        //This is the user input
        int inputtedYear;
        try {
            inputtedYear = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) { //Exception Handling to stop you from inputting not a number
            System.out.println("Invalid Character.");
            return;
        }
        //Check to see if the Inputted year is in the data
        boolean found = false;

        for (WeatherData items : listWeather) {
            if (items.getYear() == inputtedYear) {
                //Finds the year in the data and lists all the info
                System.out.printf("%-6d %-7d %-8.1f %-8.1f %-8.1f %-10.1f\n",
                        items.getYear(), items.getMonth(), items.getMaxTemp(),
                        items.getMinTemp(), items.getMeanTemp(), items.getRainAmount());
                found = true;
            }

        }
        if (!found){ //If the year isnt in the data it will tell the user it isnt there
            System.out.println("Year not in Data");
        }
    }

    public static void getAverageRainfallByYear() {
        //Establish a Hashmap for printing the data
        Map<Integer, List<Float>> averageRainfall = new HashMap<>();

        //This part only has it that
        // the Year and the Average RAINFALL are used for the grouping
        for (WeatherData items : listWeather) {
            int year = items.getYear();
            float rainAmount = items.getRainAmount();

            averageRainfall.putIfAbsent(year, new ArrayList<>());
            averageRainfall.get(year).add(rainAmount);
        }
        //This section is for matching the year to the average rainfall
        for (Map.Entry<Integer, List<Float>> entry : averageRainfall.entrySet()) {
            int year = entry.getKey();
            List<Float> rainfallData = entry.getValue();

            float total = 0;
            for (float x : rainfallData) {
                total += x;
            }
            //This goes through each monthly average and then adds them and
            // then divides by the number of months on the csv
            float average = total / rainfallData.size();
            System.out.printf("%-6d %-8.1f\n", year, average);
        }
        System.out.println("\n Average Rainfall per Year:");
    }

    public static void getAverageTemperatureByYear() {
        // Establishs a Hashmap to map the data together
        Map<Integer, List<Float>> AvTemp = new HashMap<>();
        //This part only has it that
        // the Year and the Mean Temperature are used for the grouping
        for (WeatherData items : listWeather) {
            int year = items.getYear();
            float meanTemp = items.getMeanTemp();
            //If a Year isnt in the map it adds it to an emptylist
            //then adds the mean temperature for that month
            AvTemp.putIfAbsent(year, new ArrayList<>());
            AvTemp.get(year).add(meanTemp);
        }
        //This section calculates the average temperature of each year
        for (Map.Entry<Integer, List<Float>> entry : AvTemp.entrySet()) {
            int year = entry.getKey();
            List<Float> tempData = entry.getValue();

            float total = 0;
            for (float x : tempData) {
                total += x;
            }
            //This goes through each monthly average and then adds them and
            // then divides by the number of months on the csv
            float average = total / tempData.size();
            System.out.printf("%-6d %-8.1f\n", year, average);
        }
        //Prints all the years and the average temperatures
        System.out.println("\n Average Temperature per Year:");
    }


    public static void get3Coldest() {
        Map<Integer, List<Float>> Coldest = new HashMap<>();
        //Establish a Hashmap for printing the data
        for (WeatherData items : listWeather) {
            //This part only has it that
            // the Year and the Mean Temperature are used for the grouping
            int year = items.getYear();
            float meanTemp = items.getMeanTemp();
            //If a Year isnt in the map it adds it to an emptylist
            //then adds the mean temperature for that month
            Coldest.putIfAbsent(year, new ArrayList<>());
            Coldest.get(year).add(meanTemp);

        }
        Map<Integer, Float> avTemps = new HashMap<>();
        //This section calculates the average temperature of each year
        for (Map.Entry<Integer, List<Float>> entry : Coldest.entrySet()) {
            int year = entry.getKey();
            List<Float> temps = entry.getValue();

            float total = 0;
            for (float x : temps) {
                total += x;  // Add all mean temps for the year
            }
            //This goes through each monthly average and then adds them and
            // then divides by the number of months on the csv
            float average = total / temps.size();
            avTemps.put(year, average);
        }

        List<Map.Entry<Integer, Float>> sortedList = new ArrayList<>(avTemps.entrySet());
        //This section sorts the averages into descending order
        // the bigger the number the coldest the year's average
        sortedList.sort(new Comparator<Map.Entry<Integer, Float>>() {
            public int compare(Map.Entry<Integer, Float> o1, Map.Entry<Integer, Float> o2) {
                return Float.compare(o1.getValue(), o2.getValue());
            }
        });
        //This part prints out the first 3 items in the list which are the coldest
        System.out.println("The 3 Coldest Years (By Temperature Average):");
        for (int i = 0; i < Math.min(3, sortedList.size()); i++) {
            Map.Entry<Integer, Float> entry = sortedList.get(i);
            System.out.printf("%d: %.2f°C\n", entry.getKey(), entry.getValue());
        }
    }

    public static void get3Hottest() {
        Map<Integer, List<Float>> Hottest = new HashMap<>();
        //Establish a Hashmap for printing the data
        for (WeatherData items : listWeather) {
            //This part only has it that
            // the Year and the Mean Temperature are used for the grouping
            int year = items.getYear();
            float meanTemp = items.getMeanTemp();
            //If a Year isnt in the map it adds it to an emptylist
            //then adds the mean temperature for that month

            Hottest.putIfAbsent(year, new ArrayList<>());
            Hottest.get(year).add(meanTemp);
        }
        Map<Integer, Float> avTemps = new HashMap<>();
        //This section calculates the average temperature of each year
        for (Map.Entry<Integer, List<Float>> entry : Hottest.entrySet()) {
            int year = entry.getKey();
            List<Float> temps = entry.getValue();

            float total = 0;
            for (float x : temps) {
                total += x;  // Add all mean temps for the year
            }
            //This goes through each monthly average and then adds them and
            // then divides by the number of months on the csv
            float average = total / temps.size();
            avTemps.put(year, average);
        }

        List<Map.Entry<Integer, Float>> sortedList = new ArrayList<>(avTemps.entrySet());
        //This section sorts the averages into descending order
        // the bigger the number the hottest the year's average
        sortedList.sort(new Comparator<Map.Entry<Integer, Float>>() {
            public int compare(Map.Entry<Integer, Float> o1, Map.Entry<Integer, Float> o2) {
                return Float.compare(o2.getValue(), o1.getValue());
            }
        });
        //This part prints out the first 3 items in the list which are the hottest
        System.out.println("The 3 Hottest Years (By Temperature Average):");
        for (int i = 0; i < Math.min(3, sortedList.size()); i++) {
            Map.Entry<Integer, Float> entry = sortedList.get(i);
            System.out.printf("%d: %.2f°C\n", entry.getKey(), entry.getValue());
        }
    }
}