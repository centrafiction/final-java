package Exercise3;

import javax.swing.*;
import java.awt.*;

public class Subwindow extends JFrame {
    JFrame subWindow = new JFrame();
    public Subwindow(){
        this.setSize(420,420);
        this.setVisible(true);
        /*
        This is a subwindow for the forecast page which just displays the forecast
        it is set up in the same way as the basic frame
         */
        JTextArea textArea = new JTextArea();

        textArea.setEditable(false);
        textArea.setFocusable(false);
        textArea.setOpaque(true);              // make it truly transparent
        textArea.setBackground(Color.orange);
        textArea.setBorder(null);
        textArea.setFont(new JLabel().getFont()); // matches JLabel font
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setOpaque(false);
        scrollPane.setBorder(null);

        this.add(scrollPane);

        String[] times = OpenMeteoClient.getForecastTime();
        String[] degrees = OpenMeteoClient.getForecastTemperature();
        String[] rain = OpenMeteoClient.getForecastPrecipitation();
        String[] wind = OpenMeteoClient.getForecastWind();
        String[] humidity = OpenMeteoClient.getForecastHumidity();


        StringBuilder forecastText = new StringBuilder();
        for (int i = 0; i < Math.min(times.length, degrees.length); i++) {
            forecastText.append(times[i])
                    .append(" -> ")
                    .append(degrees[i])
                    .append("°C -> ")
                    .append(rain[i])
                    .append("mm -> ")
                    .append(wind[i])
                    .append("MPH -> ")
                    .append(humidity[i])
                    .append("%\n");
        }
        textArea.setText(forecastText.toString());


    }
}
