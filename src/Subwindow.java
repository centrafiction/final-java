import javax.swing.*;
import java.awt.*;

public class Subwindow extends JFrame {
    JFrame subWindow = new JFrame();
    public Subwindow(){
        this.setSize(420,420);
        this.setVisible(true);

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

        StringBuilder forecastText = new StringBuilder();
        for (int i = 0; i < Math.min(times.length, degrees.length); i++) {
            forecastText.append(times[i])
                    .append(" -> ")
                    .append(degrees[i])
                    .append("°C -> ")
                    .append(rain[i])
                    .append("mm\n");
        }
        textArea.setText(forecastText.toString());


    }
}
