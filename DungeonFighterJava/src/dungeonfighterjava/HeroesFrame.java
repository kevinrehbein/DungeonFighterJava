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
public class HeroesFrame extends JFrame {
    
    public HeroesFrame(String name){
        super(name);
        this.setSize(500, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel heroesPanel = new JPanel();
        heroesPanel.setLayout(null);
        this.add(heroesPanel);
        
        JLabel heroesLabel = new JLabel();
        heroesLabel.setBounds(175, 5, 170, 50); 
        heroesLabel.setText("Selecione seu personagem: ");
        heroesPanel.add(heroesLabel);
        
        JButton buttonBarbaro = new JButton("Barbaro");
        buttonBarbaro.setBounds(175, 50, 150, 50);
        heroesPanel.add(buttonBarbaro);
        buttonBarbaro.addActionListener(this::barbaroSelected);
        
        JButton buttonGuerreiro = new JButton("Guerreiro");
        buttonGuerreiro.setBounds(175, 110, 150, 50);
        heroesPanel.add(buttonGuerreiro);
        buttonGuerreiro.addActionListener(this::guerreiroSelected);
        
        JButton buttonPaladino = new JButton("Paladino");
        buttonPaladino.setBounds(175, 170, 150, 50);
        heroesPanel.add(buttonPaladino);
        buttonPaladino.addActionListener(this::paladinoSelected);
        
    }
    
    private void barbaroSelected(ActionEvent barbaro){
        AttributesFrame attributesScreen = new AttributesFrame("Atributos");
    }
        
    private void guerreiroSelected(ActionEvent actionEventGuerreiro){
        System.out.println("Teste");
    }
    
    private void paladinoSelected(ActionEvent actionEventPaladino){
        
    }
}

