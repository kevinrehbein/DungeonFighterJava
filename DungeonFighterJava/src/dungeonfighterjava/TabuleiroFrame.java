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
    
    public TabuleiroFrame(String name, Tabuleiro tabuleiro, boolean visible) {
        super(name);
        this.tabuleiro = tabuleiro;
        this.visible = visible;
        criaTabuleiroFrame();
    }
    
    public void criaTabuleiroFrame(){
        
        GridLayout grid = new GridLayout(5, 10);
        
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        
        JPanel p1 = new JPanel();
        this.add(p1);
        p1.setLayout(grid);
        
        JButton[][] b = new JButton[tabuleiro.getLinhas()][tabuleiro.getColunas()];
        for (x=0; x<tabuleiro.getLinhas(); x++){
            for (y=0; y<tabuleiro.getColunas(); y++){
                b[x][y] = new JButton();
                
                if (visible) {
                    if (tabuleiro.getCelula(x, y).getPersonagem() != null){
                        switch (tabuleiro.getCelula(x, y).getPersonagem().getNome()) {
                            case "Paladino":
                                b[x][y].setBackground(Color.RED);
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
                
                p1.add(b[x][y]);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
