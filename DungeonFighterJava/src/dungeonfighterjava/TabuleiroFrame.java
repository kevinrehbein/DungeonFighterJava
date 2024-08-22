/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dungeonfighterjava;

import java.awt.Color;
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
    private int x, y;
    private boolean visible;
    private int posHeroiX, posHeroiY;
    private JButton[][] b;
    private JPanel p1;
    
    public TabuleiroFrame(String name, Tabuleiro tabuleiro, boolean visible) {
        super(name);
        this.tabuleiro = tabuleiro;
        this.visible = visible;
        
        criaTabuleiroFrame();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void criaTabuleiroFrame(){
        
        GridLayout grid = new GridLayout(5, 10);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        
        p1 = new JPanel();
        this.add(p1);
        p1.setLayout(grid);
        
        b = new JButton[tabuleiro.getLinhas()][tabuleiro.getColunas()];
        
        for (x=0; x<tabuleiro.getLinhas(); x++){
            for (y=0; y<tabuleiro.getColunas(); y++){
                
                b[x][y] = new JButton();
                
                paintButtons();
                
                p1.add(b[x][y]);
                
                // identifica botao que faz a action
                b[x][y].setActionCommand(String.valueOf(tabuleiro.getCelula(x, y).getPosX() + "," + String.valueOf(tabuleiro.getCelula(x, y).getPosY())));
                b[x][y].addActionListener(this);
            }
        }
        this.setVisible(true);
        tabuleiro.printTabuleiro();
        System.out.println();
    }
    
    public void atualizaTabuleiroFrame(){

        for (x=0; x<tabuleiro.getLinhas(); x++){
            for (y=0; y<tabuleiro.getColunas(); y++){
                
                paintButtons();
            }
        }
        
        p1.revalidate();
        p1.repaint();
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

    @Override
    public void actionPerformed(ActionEvent e) {
        
        x = Integer.parseInt((e.getActionCommand()).substring(0, 1));
        y = Integer.parseInt((e.getActionCommand()).substring(2, 3));
        System.out.printf("%d %d", x, y);
        
        if ((x <= posHeroiX + 1 && x >= posHeroiX - 1) && (y <= posHeroiY + 1 && y >= posHeroiY - 1)){    // Controla movimentação apenas em casas visinhas
            
            if (tabuleiro.getCelula(x, y).isEmpty()){
                tabuleiro.moverPersonagem(posHeroiX, posHeroiY, x, y);
                this.posHeroiX = x;
                this.posHeroiY = y;
                atualizaTabuleiroFrame();
            } else {
                if (tabuleiro.getCelula(x, y).getPersonagem() != null){

                    switch (tabuleiro.getCelula(x, y).getPersonagem().getNome()) {
                        case "Chefao":
                            JOptionPane.showMessageDialog(null, "Encontrou o Chefao!!!");
                        break;
                        case "MonstroMenor":
                            JOptionPane.showMessageDialog(null, "Bu, monstro menor!");
                        break;
                    }
                } else {

                    switch (tabuleiro.getCelula(x, y).getArmadilha().getNome()){
                        case "ArmadilhaPF":
                            JOptionPane.showMessageDialog(null, "Armadilha Perda Fixa");
                        break;
                        case "ArmadilhaPA":
                            JOptionPane.showMessageDialog(null, "Armadilha Perda Aleatoria");
                        break;
                    }
                }
            }
        }
    }
}
