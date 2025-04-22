package Exercise3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Component extends JComponent implements KeyListener, ActionListener {
    /*
    These are declarations for the JFrame stuff so that the component
    could interact with the buttons and stuff
     */
    private JButton button;
    private JButton button2;
    private JTextField countrySelect;

    public Component() {
        // Reads Mouse and Keyboard inputs
        addKeyListener(this);

        // Makes it so it reads the inputs while focused on the window
        setFocusable(true);
        requestFocusInWindow();
        /*
        These are buttons for showing the weather info
        button will open a new page and showcase the whole forecast
        button2 will open a dialog box and showcase the weather information for right now
         */
        button = new JButton("Forecast");
        button.setBounds(450, 250, 150, 30);
        button.addActionListener(this);
        this.add(button);

        button2 = new JButton("Current Weather");
        button2.setBounds(250, 250, 150, 30);
        button2.addActionListener(this);
        this.add(button2);
        setLayout(null);

        countrySelect = new JTextField();
        countrySelect.setBounds(315, 100, 180, 30);
        countrySelect.setForeground(new Color(0x7EA16B));

        this.add(countrySelect);



    }

    @Override
    //This is for testing if the keystrokes work if you click off the textbox and type it will print in the CLI
    public void keyTyped(KeyEvent e) {
        char keyChar = e.getKeyChar();
        System.out.println(keyChar);
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    /*
    This section is about getting button stuff to work
    With the first button which is FORECAST it will open a new page
    and the Second Button will open a dialog box with the weather infor from right now
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            Subwindow subWindow = new Subwindow();
        }
/*
there is a tyr nad catch exception for
the second button to help catch errors such as not putting anything in the text box
 */
        if(e.getSource()==button2){
            String x = countrySelect.getText().trim();
            try {
                OpenMeteoClient.updateCurrentWeather(x);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            try {
                OpenMeteoClient.updateForecast(x);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

            /*
            this part rights all the current information to a string each and then it is
            put into a dialog message box which opens and changes when you reopen it or change the city
             */
            String temp = OpenMeteoClient.getCurrentTemperature();
            String rain = OpenMeteoClient.getCurrentPrecipitation();
            String humidity = OpenMeteoClient.getCurrentHumidity();
            String wind = OpenMeteoClient.getCurrentWind();
            JOptionPane.showMessageDialog(null,x + "\n" +rain + "mm (Precipitation)\n"+ temp + "°C (Temperature)\n" + wind + " MPH (Wind Speed)\n" + humidity + "% (Humidity)\n","Current Weather",JOptionPane.PLAIN_MESSAGE);
            /*
            for(int i = 0; i < 10; i++){
                System.out.println(".");
            }
             */
            //This will print out the City typed in (Would have originally wrote it to a file but it is not necessary)
            System.out.println(countrySelect.getText());
        }
    }
}

