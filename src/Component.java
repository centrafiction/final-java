import java.lang.Math;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Component extends JComponent implements MouseListener, KeyListener {
    JButton button1;

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
}

