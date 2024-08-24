/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dungeonfighterjava;

import javax.swing.*;

/**
 *
 * @author kevin
 */
public class FinalFrame extends JFrame{
    
    public FinalFrame(){
       
       this.setSize(400, 400);
       this.setVisible(true);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        
       JPanel buttonsPanel = new JPanel();
       buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
       
       buttonsPanel.add(Box.createHorizontalGlue());
       
       JButton buttonReiniciar = new JButton("Reiniciar Jogo");
       buttonsPanel.add(buttonReiniciar);
       
       buttonsPanel.add(Box.createHorizontalGlue());
       
       JButton buttonNovo = new JButton("Novo Jogo");
       buttonsPanel.add(buttonNovo);
       
       buttonsPanel.add(Box.createHorizontalGlue());
       
       this.add(buttonsPanel);
    }
    
}
