public class Exercise3 {
    public static void main(String[] args) throws Exception {
       OpenMeteoClient.updateCurrentWeather("London");
       System.out.println(OpenMeteoClient.getCurrentTemperature());
    }
}
