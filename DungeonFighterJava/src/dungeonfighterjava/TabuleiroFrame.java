/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dungeonfighterjava;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author kevin
 */
public class TabuleiroFrame extends JFrame implements ActionListener{
    private Tabuleiro tabuleiro;
    private int x, y, posHeroiX, posHeroiY, countDicas;
    private boolean visible, flagDica=false;
    private JButton[][] b;
    private JPanel gridPanel, attributesPanel;
    private JLabel l1, l2, l3, l4, l5;
    private JButton buttonDica, buttonSair;
    private CombatFrame combatScreen;
    
    public TabuleiroFrame(String name, Tabuleiro tabuleiro, boolean visible) {
        super(name);
        this.tabuleiro = tabuleiro;
        this.visible = visible;
        this.countDicas = tabuleiro.getNumDicas();
        
        criaTabuleiroFrame();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void criaTabuleiroFrame(){
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1920, 720);

        gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(5, 10));
        gridPanel.setPreferredSize(new java.awt.Dimension(1080, 720));
        this.add(gridPanel, BorderLayout.EAST);
       
        b = new JButton[tabuleiro.getLinhas()][tabuleiro.getColunas()];
        
        for (x=0; x<tabuleiro.getLinhas(); x++){
            for (y=0; y<tabuleiro.getColunas(); y++){
                
                b[x][y] = new JButton();
                
                paintButtons();
                
                // identifica botao que faz a action
                b[x][y].setActionCommand(String.valueOf(tabuleiro.getCelula(x, y).getPosX() + "," + String.valueOf(tabuleiro.getCelula(x, y).getPosY())));
                b[x][y].addActionListener(this);
                
                gridPanel.add(b[x][y]);
            }
        }
        
        //print tabuleiro no terminal
        tabuleiro.printTabuleiro();
        System.out.println();
        
        //Cria lado esquerdo da tela
        attributesPanel = new JPanel();
        //attributesPanel.setPreferredSize(new java.awt.Dimension(100, 100));
        attributesPanel.setLayout(new BoxLayout(attributesPanel, BoxLayout.Y_AXIS));
        attributesPanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        
        attributesPanel.add(Box.createVerticalGlue());
        
        l1 = new JLabel("Atributos " + String.valueOf(tabuleiro.getCelula(posHeroiX, posHeroiY).getPersonagem().getNome()));
        l1.setFont(new Font("Arial",1, 18));
        l1.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        attributesPanel.add(l1);
        
        attributesPanel.add(new JLabel(" "));
        attributesPanel.add(new JLabel(" "));
        
        l2 = new JLabel("Ataque: " + String.valueOf(tabuleiro.getCelula(posHeroiX, posHeroiY).getPersonagem().getAtaque()));
        l2.setFont(new Font ("Arial", 1, 12));
        l2.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        attributesPanel.add(l2);
        attributesPanel.add(new JLabel(" "));
        
        l3 = new JLabel("Defesa: " + String.valueOf(tabuleiro.getCelula(posHeroiX, posHeroiY).getPersonagem().getDefesa()));
        l3.setFont(new Font ("Arial", 1, 12));
        l3.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        attributesPanel.add(l3);
        attributesPanel.add(new JLabel(" "));
        
        l4 = new JLabel("Saúde: " + String.valueOf(tabuleiro.getCelula(posHeroiX, posHeroiY).getPersonagem().getSaude()));
        l4.setFont(new Font ("Arial", 1, 12));
        l4.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        attributesPanel.add(l4);
        attributesPanel.add(new JLabel(" "));
        
        attributesPanel.add(Box.createVerticalGlue());
        
        buttonDica = new JButton("Dica");
        buttonDica.setPreferredSize(new java.awt.Dimension(200, 40));
        buttonDica.setBackground(Color.LIGHT_GRAY);
        buttonDica.setAlignmentX(JButton.CENTER_ALIGNMENT);
        buttonDica.addActionListener(this::dicaPressed);
        attributesPanel.add(buttonDica);
        attributesPanel.add(new JLabel(" "));
        
        l5 = new JLabel("Você tem " + String.valueOf(countDicas) + " dicas disponíveis");
        l5.setFont(new Font ("Arial", 1, 12));
        l5.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        attributesPanel.add(l5);
        
        attributesPanel.add(Box.createVerticalGlue());
        
        buttonSair = new JButton("Sair");
        buttonSair.setPreferredSize(new java.awt.Dimension(200, 40));
        buttonSair.setBackground(Color.GRAY);
        buttonSair.setAlignmentX(JButton.CENTER_ALIGNMENT);
        buttonSair.addActionListener(this::sairPressed);
        attributesPanel.add(buttonSair);
        attributesPanel.add(new JLabel(" "));
        
        this.add(attributesPanel);
        
        this.setVisible(true);
    }
    
    public void atualizaTabuleiroFrame(){

        for (x=0; x<tabuleiro.getLinhas(); x++){
            for (y=0; y<tabuleiro.getColunas(); y++){
                
                paintButtons();
            }
        }
        
        gridPanel.revalidate();
        gridPanel.repaint();
    }
    
    public void paintButtons(){
        
        if (visible) {
                    
            if (tabuleiro.getCelula(x, y).getPersonagem() != null){

                switch (tabuleiro.getCelula(x, y).getPersonagem().getNome()) {
                    case "Paladino":
                        b[x][y].setBackground(Color.RED);
                        this.posHeroiX = x;
                        this.posHeroiY = y;
                    break;
                    case "Guerreiro":
                        b[x][y].setBackground(Color.RED);
                        this.posHeroiX = x;
                        this.posHeroiY = y;
                    break;
                    case "Barbaro":
                        b[x][y].setBackground(Color.RED);
                        this.posHeroiX = x;
                        this.posHeroiY = y;
                    break;
                    case "MonstroMenor":
                        b[x][y].setBackground(Color.MAGENTA);
                    break;
                    case "Chefao":
                        b[x][y].setBackground(Color.BLUE);
                    break;
                }

            } else if (tabuleiro.getCelula(x, y).getArmadilha() != null){

                switch (tabuleiro.getCelula(x, y).getArmadilha().getNome()){
                    case "ArmadilhaPF":
                        b[x][y].setBackground(Color.GRAY);
                    break;
                    case "ArmadilhaPA":
                        b[x][y].setBackground(Color.DARK_GRAY);
                    break;
                }

            } else if(tabuleiro.getCelula(x, y).isElixir()){
                
                b[x][y].setBackground(Color.GREEN);
                
            } else b[x][y].setBackground(Color.WHITE);

        } else {

            if (tabuleiro.getCelula(x, y).getPersonagem() != null){

                switch (tabuleiro.getCelula(x, y).getPersonagem().getNome()) {
                    case "Paladino":
                        b[x][y].setBackground(Color.RED);
                        this.posHeroiX = x;
                        this.posHeroiY = y;
                    break;
                    case "Guerreiro":
                        b[x][y].setBackground(Color.RED);
                        this.posHeroiX = x;
                        this.posHeroiY = y;
                    break;
                    case "Barbaro":
                        b[x][y].setBackground(Color.RED);
                        this.posHeroiX = x;
                        this.posHeroiY = y;
                    break;
                    case "Chefao":
                        b[x][y].setBackground(Color.BLUE);
                    break;
                    default:
                        b[x][y].setBackground(Color.BLACK);
                    break;
                }

            } else b[x][y].setBackground(Color.BLACK);
        }
    }
    
    public void atualizaLabels(){
        l2.setText("Ataque: " + String.valueOf(tabuleiro.getCelula(posHeroiX, posHeroiY).getPersonagem().getAtaque()));
        l3.setText("Defesa: " + String.valueOf(tabuleiro.getCelula(posHeroiX, posHeroiY).getPersonagem().getDefesa()));
        l4.setText("Saúde: " + String.valueOf(tabuleiro.getCelula(posHeroiX, posHeroiY).getPersonagem().getSaude()));
        l5.setText("Você tem " + String.valueOf(countDicas) + " dicas disponíveis");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        x = Integer.parseInt((e.getActionCommand()).substring(0, 1));
        y = Integer.parseInt((e.getActionCommand()).substring(2, 3));
        //System.out.printf("%d %d", x, y);
        
        if (flagDica == false){
            if ((x <= posHeroiX + 1 && x >= posHeroiX - 1) && (y <= posHeroiY + 1 && y >= posHeroiY - 1)){    // Controla movimentação apenas em casas visinhas
                
                if (tabuleiro.getCelula(x, y).isEmpty()){
                    
                    //movimentações
                    switch (tabuleiro.getCelula(posHeroiX, posHeroiY).getPersonagem().getNome()){
                        case "Paladino":
                            tabuleiro.moverHeroi(tabuleiro.getCelula(posHeroiX, posHeroiY).getPaladino(), posHeroiX, posHeroiY, x, y);
                        break;
                        case "Guerreiro":
                            tabuleiro.moverHeroi(tabuleiro.getCelula(posHeroiX, posHeroiY).getGuerreiro(), posHeroiX, posHeroiY, x, y);
                        break;
                        case "Barbaro":
                            tabuleiro.moverHeroi(tabuleiro.getCelula(posHeroiX, posHeroiY).getBarbaro(), posHeroiX, posHeroiY, x, y);
                        break;
                    }
                    
                } else {
                    
                    //batalhas
                    if (tabuleiro.getCelula(x, y).getPersonagem() != null){

                        switch (tabuleiro.getCelula(x, y).getPersonagem().getNome()) {
                            case "Chefao":
                                JOptionPane.showMessageDialog(null, "Encontrou o Chefao!!!");
                            break;
                            case "MonstroMenor":
                                
                                switch (tabuleiro.getCelula(posHeroiX, posHeroiY).getPersonagem().getNome()){
                                    case "Paladino":
                                        //tabuleiro.combat(tabuleiro.getCelula(posHeroiX, posHeroiY).getPaladino(), tabuleiro.getCelula(x, y).getMonstroMenor());
                                    break;
                                    case "Guerreiro":
                                        //tabuleiro.combat(tabuleiro.getCelula(posHeroiX, posHeroiY).getGuerreiro(), tabuleiro.getCelula(x, y).getMonstroMenor());
                                    break;
                                    case "Barbaro":
                                        
                                        combatScreen = new CombatFrame(tabuleiro.getCelula(posHeroiX, posHeroiY).getBarbaro(), tabuleiro.getCelula(x, y).getMonstroMenor());
                                        JOptionPane.showMessageDialog(null, combatScreen, "Dungeon_Fighter", JOptionPane.PLAIN_MESSAGE);
                                        //combatScreen = new CombatFrame(tabuleiro.getCelula(posHeroiX, posHeroiY).getBarbaro(), tabuleiro.getCelula(x, y).getMonstroMenor());
                                        
                                        //tabuleiro.getCelula(posHeroiX, posHeroiY).getBarbaro().setSaude(combatScreen.);
                                        
                                        /*vencedor = tabuleiro.combat(tabuleiro.getCelula(posHeroiX, posHeroiY).getBarbaro(), tabuleiro.getCelula(x, y).getMonstroMenor());
                                        if (vencedor.getNome().equals("Barbaro")){
                                            tabuleiro.moverHeroi(tabuleiro.getCelula(posHeroiX, posHeroiY).getBarbaro(), posHeroiX, posHeroiY, x, y);
                                        } else
                                            JOptionPane.showMessageDialog(null, "GameOver");*/
                                    break;
                                }
                                
                            break;
                        }
                    } else {
                        
                        //armadilhas
                        if (tabuleiro.getCelula(x, y).getArmadilha() != null){

                            switch (tabuleiro.getCelula(x, y).getArmadilha().getNome()){
                                case "ArmadilhaPF":
                                    JOptionPane.showMessageDialog(null, "Armadilha Perda Fixa");
                                break;
                                case "ArmadilhaPA":
                                    JOptionPane.showMessageDialog(null, "Armadilha Perda Aleatoria");
                                break;
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Elixir");
                        }
                    }
                }
                
                this.posHeroiX = x;
                this.posHeroiY = y;

                atualizaTabuleiroFrame();
                atualizaLabels();
            }
        } else {
            
            int countArmadilhas = 0;
            for (x=0; x<tabuleiro.getLinhas(); x++){
                if (tabuleiro.getCelula(x, y).getArmadilha() != null){
                    countArmadilhas++;
                }
            }
            JOptionPane.showMessageDialog(null, "Essa coluna possui " + String.valueOf(countArmadilhas++) + " armadilha(s)!");
            countDicas--;
            flagDica = false;
            atualizaLabels();
        }
    }

    private void dicaPressed(ActionEvent e) {
        
        if(countDicas > 0) {
            JOptionPane.showMessageDialog(null, "Selecione qualquer casa do tabuleiro e você saberá quantas armadilhas existem naquela coluna!");
            flagDica = true;
        }
    }
    
    private void sairPressed(ActionEvent e) {
        this.dispose();
        FinalFrame finalScreen = new FinalFrame();
    }
    
}
