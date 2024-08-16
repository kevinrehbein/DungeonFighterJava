package dungeonfighterjava;

import javax.swing.*;

public class DungeonFighterJava {

    public static void main(String[] args) {
        
        JFrame mainScreen = new JFrame("Welcome");
        mainScreen.setVisible(true);
        mainScreen.setSize(500, 300);
        mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mainScreen.setLayout(null);
        JButton button1 = new JButton("Jogar");
        button1.setBounds(150, 125, 200, 50);
        mainScreen.add(button1);
    }
    
}
