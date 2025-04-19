import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame{
    MyFrame() throws Exception {
        // basic frame configuration
        this.setTitle("WEATHER");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //EXIT OUT OF APPLICATION
        //this.setResizable(false);
        this.getContentPane().setBackground(Color.orange); //Changes background colour


        //this.add(new Component());
        //lets the component class attributes be used in the frame
        this.setVisible(true);
        //has the this appear
        JTextArea textArea = new JTextArea();

        textArea.setEditable(false);
        textArea.setFocusable(false);
        //textArea.setOpaque(false);              // make it truly transparent
        //textArea.setBackground(new Color(0,0,0,0));
        textArea.setBorder(null);
        textArea.setFont(new JLabel().getFont()); // matches JLabel font
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(800, 600));

        this.add(scrollPane);
        this.setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.CENTER);


        OpenMeteoClient.updateCurrentWeather("Paris");
        OpenMeteoClient.updateForecast("Paris");
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
        this.pack();
    }
}

