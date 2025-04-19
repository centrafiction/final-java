import javax.swing.*;

public class Exercise3 {
    public static void main(String[] args) throws Exception {
        JFrame window = new JFrame("WEATHER");
        window.setSize(300, 200);
        // basic frame configuration
        window.add(new Component());
        //lets the component class attributes be used in the frame
        window.setVisible(true);
        //has the window appear
        Thread.sleep(2000);
        OpenMeteoClient.updateCurrentWeather("Dubai");
        System.out.println(OpenMeteoClient.getCurrentTemperature());
    }
}
