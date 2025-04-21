import java.lang.Math;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Component extends JComponent implements MouseListener, KeyListener, ActionListener {
    private JButton button;
    private JButton button2;
    private JTextField countrySelect;

    public Component() {
        // Reads Mouse and Keyboard inputs
        addMouseListener(this);
        addKeyListener(this);

        // Makes it so it reads the inputs while focused on the window
        setFocusable(true);
        requestFocusInWindow();
/*
        String[] times = OpenMeteoClient.getForecastTime();
        String[] degrees = OpenMeteoClient.getForecastTemperature();
        String[] rain = OpenMeteoClient.getForecastPrecipitation();

        for (int i = 0; i < Math.min(times.length, degrees.length); i++) {
            System.out.println(times[i] + " -> " + degrees[i] + "°C");
        }*/
        button = new JButton("Refresh");
        button.setBounds(50, 50, 120, 30);
        button.addActionListener(this);
        this.add(button);

        button2 = new JButton("Submit");
        button2.setBounds(250, 100, 120, 30);
        button2.addActionListener(this);
        this.add(button2);
        setLayout(null);

        countrySelect = new JTextField();
        countrySelect.setBounds(50, 100, 150, 20);
        countrySelect.setForeground(new Color(0x7EA16B));

        this.add(countrySelect);


    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        char keyChar = e.getKeyChar();
        System.out.println(keyChar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            Subwindow subWindow = new Subwindow();
        }
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

            String[] times = OpenMeteoClient.getForecastTime();
            String[] degrees = OpenMeteoClient.getForecastTemperature();
            String[] rain = OpenMeteoClient.getForecastPrecipitation();
            for (int i = 0; i < Math.min(times.length, degrees.length); i++) {
                System.out.println(times[i] + " -> " + degrees[i] + "°C" + " -> " + rain[i] + "mm");
            }
            /*
            for(int i = 0; i < 10; i++){
                System.out.println(".");
            }
             */
            System.out.println(countrySelect.getText());
        }
    }
}

