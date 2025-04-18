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
    public static void getAverageRainfallByYear(){
        Map<Integer, List<Float>> averageRainfall = new HashMap<>();

        for (WeatherData items: listWeather){
            int year = items.getYear();
            float rainAmount = items.getRainAmount();

            averageRainfall.putIfAbsent(year, new ArrayList<>());
            averageRainfall.get(year).add(rainAmount);
        }
        for (Map.Entry<Integer, List<Float>> entry : averageRainfall.entrySet()) {
            int year = entry.getKey();
            List<Float> rainfallData = entry.getValue();

            float total = 0;
            for (float x : rainfallData) {
                total += x;
            }
            float average = total / rainfallData.size();
            System.out.printf("%-6d %-8.1f\n", year, average);
        }
        System.out.println("\n Average Rainfall per Year:");
    }

    public static void getAverageTemperatureByYear(){
        Map<Integer, List<Float>> AvTemp = new HashMap<>();

        for (WeatherData items: listWeather){
            int year = items.getYear();
            float meanTemp = items.getMeanTemp();

            AvTemp.putIfAbsent(year, new ArrayList<>());
            AvTemp.get(year).add(meanTemp);
        }
        for (Map.Entry<Integer, List<Float>> entry : AvTemp.entrySet()) {
            int year = entry.getKey();
            List<Float> tempData = entry.getValue();

            float total = 0;
            for (float x : tempData) {
                total += x;
            }
            float average = total / tempData.size();
            System.out.printf("%-6d %-8.1f\n", year, average);
        }
        System.out.println("\n Average Temperature per Year:");
    }


    public static void get3Coldest(){    Map<Integer, List<Float>> Coldest = new HashMap<>();
        for (WeatherData items: listWeather){
            int year = items.getYear();
            float meanTemp = items.getMeanTemp();

            Coldest.putIfAbsent(year, new ArrayList<>());
            Coldest.get(year).add(meanTemp);
        }
        Map<Integer, Float> avTemps = new HashMap<>();

        for (Map.Entry<Integer, List<Float>> entry : Coldest.entrySet()){
            int year = entry.getKey();
            List<Float> temps = entry.getValue();

            float total = 0;
            for (float x : temps) {
                total += x;  // Add all mean temps for the year
            }

            float average = total / temps.size();
            avTemps.put(year, average);
        }

        List<Map.Entry<Integer, Float>> sortedList = new ArrayList<>(avTemps.entrySet());

        sortedList.sort(new Comparator<Map.Entry<Integer, Float>>() {
            public int compare(Map.Entry<Integer, Float> o1, Map.Entry<Integer, Float> o2) {
                return Float.compare(o1.getValue(), o2.getValue());
            }
        });

        System.out.println("The 3 Coldest Years (By Temperature Average):");
        for (int i = 0; i < Math.min(3, sortedList.size()); i++) {
            Map.Entry<Integer, Float> entry = sortedList.get(i);
            System.out.printf("%d: %.2f°C\n", entry.getKey(), entry.getValue());
        }}

    public static void get3Hottest(){
        Map<Integer, List<Float>> Hottest = new HashMap<>();
        for (WeatherData items: listWeather){
            int year = items.getYear();
            float meanTemp = items.getMeanTemp();

            Hottest.putIfAbsent(year, new ArrayList<>());
            Hottest.get(year).add(meanTemp);
        }
        Map<Integer, Float> avTemps = new HashMap<>();

        for (Map.Entry<Integer, List<Float>> entry : Hottest.entrySet()){
            int year = entry.getKey();
            List<Float> temps = entry.getValue();

            float total = 0;
            for (float x : temps) {
                total += x;  // Add all mean temps for the year
            }

            float average = total / temps.size();
            avTemps.put(year, average);
        }

        List<Map.Entry<Integer, Float>> sortedList = new ArrayList<>(avTemps.entrySet());

        sortedList.sort(new Comparator<Map.Entry<Integer, Float>>() {
            public int compare(Map.Entry<Integer, Float> o1, Map.Entry<Integer, Float> o2) {
                return Float.compare(o2.getValue(), o1.getValue());
            }
        });

        System.out.println("The 3 Hottest Years (By Temperature Average):");
        for (int i = 0; i < Math.min(3, sortedList.size()); i++) {
            Map.Entry<Integer, Float> entry = sortedList.get(i);
            System.out.printf("%d: %.2f°C\n", entry.getKey(), entry.getValue());
        }
    }

    public static void getAverageRainfallForAYear(){
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
        float total = 0;
        for (WeatherData items: listWeather)  {
            if (items.getYear() == inputtedYear) {
                total += items.getRainAmount();
                found = true;

            }
        }
        if(inputtedYear == 2024) {
            System.out.println("Average rainfall for "+inputtedYear+ " is: "+ total);
        } else{
            System.out.println("Average rainfall for "+inputtedYear+ " is: "+ total/12);
        }
    }
}
