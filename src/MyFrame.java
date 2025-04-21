import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame{
    MyFrame() throws Exception {
        // basic frame configuration
        this.setTitle("WEATHER");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //EXIT OUT OF APPLICATION
        //this.setResizable(false);
        this.setLayout(null);
        this.setPreferredSize(new Dimension(800, 500));
        this.getContentPane().setBackground(Color.orange); //Changes background colour


        //this.add(new Component());
        //lets the component class attributes be used in the frame
        //has the this appear
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
        this.setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.CENTER);

        JButton button = new JButton("Refresh");
        this.add(button, BorderLayout.SOUTH);




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

        //textArea.setText(forecastText.toString());
        this.pack();
        this.setLocationRelativeTo(null); // optional: center on screen
        this.setVisible(true);
    }
}

