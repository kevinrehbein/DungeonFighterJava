/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dungeonfighterjava;

import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 *
 * @author kevin
 */
public class MainFrame extends JFrame {
    
    public MainFrame(String name) {  
        
        super(name);
        this.setSize(500, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel mainPanel = new JPanel();
        this.add(mainPanel);
        mainPanel.setLayout(null);
        
        JButton button1 = new JButton("Jogar");
        button1.setBounds(175, 50, 150, 50);
        mainPanel.add(button1);
        
        JButton button2 = new JButton("DEBUG");
        button2.setBounds(175, 110, 150, 50);
        mainPanel.add(button2);
        
        JButton buttonSair = new JButton("Sair");
        buttonSair.setBounds(175, 170, 150, 50);
        mainPanel.add(buttonSair);
        
        buttonSair.addActionListener(this::sair);
    }
    
    private void sair(ActionEvent actionEventSair){
        this.dispose();
    }
}
