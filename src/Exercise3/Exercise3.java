package Exercise3;

import javax.swing.*;

public class Exercise3 {
    public static void main(String[] args) throws Exception {
        /*
        This is the main class,
        First it will display a pop up telling u about the weather widget
        Thread.sleep is basically Time.sleep in python it waits a bit
        Then it initialises the frame.
         */
        int answer = JOptionPane.showConfirmDialog(null,"Welcome to a Weather Widget.","Widget Info",JOptionPane.INFORMATION_MESSAGE);
        if(answer == 0){
            JOptionPane.showMessageDialog(null, "How you use this is by typing a city into the textbox and click either the current box for the current weather or Forecast box for the weather for the week.", "Widget Instructions",JOptionPane.PLAIN_MESSAGE);
        }else {
            System.exit(0);
        }
        Thread.sleep(1000);
        MyFrame window = new MyFrame();    }
}
