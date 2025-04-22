package Exercise3;

import javax.swing.*;
import java.awt.*;


public class MyFrame extends JFrame{
    MyFrame() throws Exception {
        // basic frame configuration
        this.setTitle("WEATHER");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //EXIT OUT OF APPLICATION
        this.setResizable(false);
        this.setLayout(null);
        this.setPreferredSize(new Dimension(800, 500));
        this.getContentPane().setBackground(Color.orange); //Changes background colour

        Component component = new Component();
        component.setBounds(0, 0, 800, 600);
        this.add(component);
        //lets the component class attributes be used in the frame
        /*
        This section is for the paragraphs of text that contains the forecast data
        This has a few settings to make it work as the backgrounds wouldnt help
        it can not be edited and ccan not be focused,
        the rest of its settings is just text wrapping
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
        /*
        This part is for the scrolling thing for the forecast page as it is long
        this.add puts the stuffs on the GUI
         */
        this.add(scrollPane);

        /*
        This section is for making the forecast into a  string and put it into a map type deal
        it will go through the list of each hour of each day for like a week and then will split it up
        in a way that shows al the variables that want to be seen.

        London is used as the automatic city for testing with.
         */

        OpenMeteoClient.updateCurrentWeather("London");
        OpenMeteoClient.updateForecast("London");
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
                    .append("% \n");
        }
        //This puts the GUI together and sets everything to visible
        //textArea.setText(forecastText.toString());
        this.pack();
        this.setLocationRelativeTo(null); // optional: center on screen
        this.setVisible(true);
    }
}

