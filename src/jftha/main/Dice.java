package jftha.main;

import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Dice {

    int roll;

    //Constructor
    public Dice(int maxAmount) {
        Random rand = new Random();
        this.roll = rand.nextInt(maxAmount) + 1;
    }

    protected int getRoll() {
        return roll;
    }

    public int roll(int maxAmount){
        Random rand = new Random();
        this.roll = rand.nextInt(maxAmount) + 1;
        return roll;
    }
    
    public int rollGUI(int maxAmount, JLabel label) { //not done
        Random rand = new Random();
        this.roll = rand.nextInt(6) + 1;
        int timesRolled = 8; //arbitrary

        //Simulate rolling of the die
        for (int i = 0; i < timesRolled; i++){
            changeDieLabelGUI(label);
            this.roll = rand.nextInt(6) + 1;
        }
        return roll;
    }

    private int changeDieLabelGUI(JLabel label) { //not done
        String imageName;
        if (roll == 1) {
            imageName = "die1.png";
        } else if (roll == 2) {
            imageName = "die2.png";
        } else if (roll == 3) {
            imageName = "die3.png";
        } else if (roll == 4) {
            imageName = "die4.png";
        } else if (roll == 5) {
            imageName = "die5.png";
        } else if (roll == 6) {
            imageName = "die6.png";
        } else {
            System.out.println("Invalid roll.");
            return -1;
        }
        ImageIcon icon = new ImageIcon(imageName);
        //icon.getImage();
        label.setIcon(icon);

        //acts as a timer
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return 1;
    }
}
