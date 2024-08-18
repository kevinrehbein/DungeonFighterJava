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
public class AttributesFrame extends JFrame {
    
    int pontos = 5;
    int ataque=0, defesa=0, saude=0;
    
    JLabel heroesLabel;
    
    public AttributesFrame(String name){    
           
        super(name);
        this.setSize(500, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel heroesPanel = new JPanel();
        heroesPanel.setLayout(null);
        this.add(heroesPanel);
        
        heroesLabel = new JLabel();
        heroesLabel.setBounds(140, 5, 250, 50); 
        heroesLabel.setText("Distribua " + Integer.toString(pontos) + " pontos entre os atributos:");
        heroesPanel.add(heroesLabel);
        
        JLabel labelAtaque = new JLabel("Ataque");
        labelAtaque.setBounds(225, 50, 50, 50);
        heroesPanel.add(labelAtaque);
        
        JLabel labelDefesa = new JLabel("Defesa");
        labelDefesa.setBounds(225, 110, 50, 50);
        heroesPanel.add(labelDefesa);
        
        JLabel labelSaude = new JLabel("Saude");
        labelSaude.setBounds(225, 170, 50, 50);
        heroesPanel.add(labelSaude);
        
        JButton b1 = new JButton("+");
        b1.setBounds(150, 50, 50, 50);
        heroesPanel.add(b1);
        b1.addActionListener(this::aumentaAtaque);
        
        JButton b2 = new JButton("-");
        b2.setBounds(300, 50, 50, 50);
        heroesPanel.add(b2);
        
        JButton b3 = new JButton("+");
        b3.setBounds(150, 110, 50, 50);
        heroesPanel.add(b3);
        b3.addActionListener(this::aumentaDefesa);
        
        JButton b4 = new JButton("-");
        b4.setBounds(300, 110, 50, 50);
        heroesPanel.add(b4);
        
        JButton b5 = new JButton("+");
        b5.setBounds(150, 170, 50, 50);
        heroesPanel.add(b5);
        b5.addActionListener(this::aumentaSaude);
        
        JButton b6 = new JButton("-");
        b6.setBounds(300, 170, 50, 50);
        heroesPanel.add(b6);
    }
    
    private void aumentaAtaque(ActionEvent actionEventAumentaAtaque){
        if (pontos > 0) {
            ataque ++;
            pontos --;
            heroesLabel.setText("Distribua " + Integer.toString(pontos) + " pontos entre os atributos:");
        } else System.out.println("Pontos esgotados");
    }
    
    private void aumentaDefesa(ActionEvent actionEventAumentaDefesa){
        if (pontos > 0) {
            defesa ++;
            pontos --;
            heroesLabel.setText("Distribua " + Integer.toString(pontos) + " pontos entre os atributos:");
        } else System.out.println("Pontos esgotados");
    }
    
    private void aumentaSaude(ActionEvent actionEventAumentaSaude){
        if (pontos > 0) {
            saude ++;
            pontos --;
            heroesLabel.setText("Distribua " + Integer.toString(pontos) + " pontos entre os atributos:");
        } else System.out.println("Pontos esgotados");
    }
}
