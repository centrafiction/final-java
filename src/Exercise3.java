import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.time.*;

public class Exercise3 {
    public static void main(String[] args) throws Exception {
        MyFrame window = new MyFrame();
        //Thread.sleep(2000);
        OpenMeteoClient.updateCurrentWeather("Paris");
        OpenMeteoClient.updateForecast("Paris");
        //System.out.println(OpenMeteoClient.getCurrentPrecipitation());
        //System.out.println(Arrays.toString(OpenMeteoClient.getForecastTime()));


        String[] times = OpenMeteoClient.getForecastTime();
        String[] degrees = OpenMeteoClient.getForecastTemperature();
        String[] rain = OpenMeteoClient.getForecastPrecipitation();
        /*
        LocalDate myObj = LocalDate.now(); // Create a date object
        System.out.println(myObj);
        */

        for (int i = 0; i < Math.min(times.length, degrees.length); i++) {
            System.out.println(times[i] + " -> " + degrees[i] + "°C" + " -> " + rain[i] + "mm");
        }
    }
}
