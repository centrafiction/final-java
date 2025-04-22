package Exercise2;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise2 {
    // The original heathrow.csv has the amount of rain in the 907th line empty justt to remind you for the future
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //user inputs
        boolean quit = false;
        WeatherDataIO.readCSV("Heathrow.csv");
        System.out.println("===== Weather Data Menu =====");
        while (!quit) {
            //The menu
            System.out.println("1. Display All Weather Data");
            System.out.println("2. Search Weather Data by Year");
            System.out.println("3. Show Average Rainfall by Year");
            System.out.println("4. Calculate Average Temperature by Year");
            System.out.println("5. Calculate 3 Coldest Years");
            System.out.println("6. Calculate 3 Hottest Years");
            System.out.println("Exit Program by typing QUIT");

            String page = scanner.nextLine(); //user input
            // essentially switch is used in replace if..elif..else as i would probably
            // needs a lot for creating this menu and it allows me to know whih part is which
            // without having to fight my own understanding of java syntax (such as having }else which works for some reason
            // default is what is ran if none of the options are picked in the scanner user input
            switch (page) {
                case "1":
                    ArrayList<WeatherData> list = WeatherDataIO.getAllWeatherData();
                    System.out.println("All Weather Data:\n");

                    for (WeatherData items : list) {
                        System.out.println(items.toCSV());
                    }
                    break;
                case "2":
                    WeatherDataIO.searchWeatherData();
                    break;
                case "3":
                    WeatherDataIO.getAverageRainfallByYear();
                    break;
                case "4":
                    WeatherDataIO.getAverageTemperatureByYear();
                    break;
                case "5":
                    WeatherDataIO.get3Coldest();
                    break;
                case "6":
                    WeatherDataIO.get3Hottest();
                    break;
                case "QUIT":
                    quit = true;
                    System.out.println("Ending Program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid Choice. Try again \n");
                    break;
            }
        }
    }


}
