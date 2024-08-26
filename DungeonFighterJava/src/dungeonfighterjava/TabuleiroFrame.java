/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dungeonfighterjava;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author kevin
 */
public class TabuleiroFrame extends JFrame {
    
    private Tabuleiro tabuleiro, tabuleiroCopia;
    private int x, y, posHeroiX, posHeroiY, countDicas, ataqueCopia, defesaCopia, saudeCopia;
    private boolean visible, flagDica=false, flagContinuarButton = true;
    private JButton[][] b;
    private JPanel gridPanel, attributesPanel;
    private JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19, l20, l21, l22;
    private JButton buttonDica, buttonSair, buttonElixir, buttonElixir2, continuarButton, atacarButton, habilidadeButton;
    
    private Personagem player, inimigo;
    private int w = 10;
    JFrame combatFrame;
    private int habilidadeAtiva;
    String resultadosAtaque, resultadosDefesa, resultadosTotal;
    
    public TabuleiroFrame(String name, Tabuleiro tabuleiro){
        super(name);
        this.tabuleiro = tabuleiro;
        this.visible = false;
        this.countDicas = tabuleiro.getNumDicas();
        criaTabuleiroCopia(tabuleiro);
        criaTabuleiroFrame();
    }
    
    public void criaTabuleiroCopia(Tabuleiro tabuleiro){
        
        this.tabuleiroCopia = new Tabuleiro(tabuleiro.getLinhas(), tabuleiro.getColunas(), tabuleiro.getNumDicas());
        
        for (int x = 0; x < tabuleiro.getLinhas(); x++){
            for (int y = 0; y < tabuleiro.getColunas(); y++){
                if (tabuleiro.getCelula(x, y).getPersonagem() != null){

                    switch (tabuleiro.getCelula(x, y).getPersonagem().getNome()) {
                        case "Paladino":
                            Paladino p1 = new Paladino();
                            int ataque = AttributesFrame.paladinoConfigurado.getAtaque();
                            int defesa = AttributesFrame.paladinoConfigurado.getDefesa();
                            int saude = AttributesFrame.paladinoConfigurado.getSaude();
                            
                            p1.setAtaque(ataque);
                            p1.setDefesa(defesa);
                            p1.setSaude(saude);
                            tabuleiroCopia.getCelula(x, y).setPersonagem(p1);   
                        break;
                        case "Guerreiro":
                            Guerreiro g1 = new Guerreiro();
                            ataque = AttributesFrame.guerreiroConfigurado.getAtaque();
                            defesa = AttributesFrame.guerreiroConfigurado.getDefesa();
                            saude = AttributesFrame.guerreiroConfigurado.getSaude();
                            
                            g1.setAtaque(ataque);
                            g1.setDefesa(defesa);
                            g1.setSaude(saude);
                            tabuleiroCopia.getCelula(x, y).setPersonagem(g1); 

                        break;
                        case "Barbaro":
                            Barbaro b1 = new Barbaro();
                            ataque = AttributesFrame.barbaroConfigurado.getAtaque();
                            defesa = AttributesFrame.barbaroConfigurado.getDefesa();
                            saude = AttributesFrame.barbaroConfigurado.getSaude();
                            
                            b1.setAtaque(ataque);
                            b1.setDefesa(defesa);
                            b1.setSaude(saude);
                            tabuleiroCopia.getCelula(x, y).setPersonagem(b1); 
                        break;
                        case "MonstroMenor":
                            tabuleiroCopia.getCelula(x, y).setPersonagem(new MonstroMenor());
                        break;
                        case "Chefao":
                            tabuleiroCopia.getCelula(x, y).setPersonagem(new Chefao());
                        break;
                    }

                } else if (tabuleiro.getCelula(x, y).getArmadilha() != null){

                    switch (tabuleiro.getCelula(x, y).getArmadilha().getNome()){
                        case "ArmadilhaPF":
                            tabuleiroCopia.getCelula(x, y).setArmadilha(new ArmadilhaPerdaAleatoria());
                        break;
                        case "ArmadilhaPA":
                            tabuleiroCopia.getCelula(x, y).setArmadilha(new ArmadilhaPerdaFixa());
                        break;
                    }

                } else if(tabuleiro.getCelula(x, y).isElixir()){

                    tabuleiroCopia.getCelula(x, y).setElixir();

                }
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    private void criaTabuleiroFrame(){
        
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
                b[x][y].addActionListener(this::gridPressed);
                
                gridPanel.add(b[x][y]);
            }
        }
        
        //Cria lado esquerdo da tela
        attributesPanel = new JPanel();
        //attributesPanel.setPreferredSize(new java.awt.Dimension(100, 100));
        attributesPanel.setLayout(new BoxLayout(attributesPanel, BoxLayout.Y_AXIS));
        attributesPanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        
        attributesPanel.add(Box.createVerticalGlue());
        
        ImageIcon dungeon = new ImageIcon(getClass().getResource("./images/logofundoremovido.png"));
        JLabel imageDungeon = new JLabel(dungeon);
        imageDungeon.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        attributesPanel.add(imageDungeon);
        
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
        
        l9 = new JLabel("Bolsa: " + String.valueOf(tabuleiro.getCelula(posHeroiX, posHeroiY).getHeroi().getElixires()));
        l9.setFont(new Font ("Arial", 1, 12));
        l9.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        attributesPanel.add(l9);

        JPanel elixirPanel = new JPanel();
        elixirPanel.setLayout(new BoxLayout(elixirPanel, BoxLayout.X_AXIS));
        elixirPanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);

        //buttonsPanel.add(Box.createVerticalGlue());
        elixirPanel.add(Box.createHorizontalGlue());

        buttonElixir = new JButton("Elixir");
        buttonElixir.setPreferredSize(new java.awt.Dimension(200, 40));
        buttonElixir.setBackground(Color.LIGHT_GRAY);
        buttonElixir.setAlignmentX(JButton.CENTER_ALIGNMENT);
        buttonElixir.addActionListener(this::elixirPressed);
        elixirPanel.add(buttonElixir);

        elixirPanel.add(Box.createHorizontalGlue());
        //buttonsPanel.add(Box.createVerticalGlue());

        attributesPanel.add(elixirPanel);
        
        
        
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
                        b[x][y].setIcon(new ImageIcon(getClass().getResource("./images/paladinoButton.png")));
                        b[x][y].setBackground(Color.BLACK);
                        this.posHeroiX = x;
                        this.posHeroiY = y;
                    break;
                    case "Guerreiro":
                        b[x][y].setIcon(new ImageIcon(getClass().getResource("./images/guerreiroButton.png")));
                        b[x][y].setBackground(Color.BLACK);
                        this.posHeroiX = x;
                        this.posHeroiY = y;
                    break;
                    case "Barbaro":
                        b[x][y].setIcon(new ImageIcon(getClass().getResource("./images/barbaroButton.png")));
                        b[x][y].setBackground(Color.BLACK);
                        this.posHeroiX = x;
                        this.posHeroiY = y;
                    break;
                    case "MonstroMenor":
                        b[x][y].setIcon(new ImageIcon(getClass().getResource("./images/monstroMenorButton.png")));
                        b[x][y].setBackground(Color.BLACK);
                    break;
                    case "Chefao":
                        b[x][y].setIcon(new ImageIcon(getClass().getResource("./images/chefaoButton.png")));
                        b[x][y].setBackground(Color.BLACK);
                    break;
                }

            } else if (tabuleiro.getCelula(x, y).getArmadilha() != null){

                switch (tabuleiro.getCelula(x, y).getArmadilha().getNome()){
                    case "ArmadilhaPF":
                        b[x][y].setIcon(new ImageIcon(getClass().getResource("./images/armadilhaPerdaFixaButton.png")));
                        b[x][y].setBackground(Color.BLACK);
                    break;
                    case "ArmadilhaPA":
                        b[x][y].setIcon(new ImageIcon(getClass().getResource("./images/armadilhaPerdaAleatoriaButton.png")));
                        b[x][y].setBackground(Color.BLACK);
                    break;
                }

            } else if(tabuleiro.getCelula(x, y).isElixir()){
                
                b[x][y].setIcon(new ImageIcon(getClass().getResource("./images/elixirButton.png")));
                b[x][y].setBackground(Color.BLACK);
                
            } else {
                b[x][y].setBackground(Color.BLACK);
                b[x][y].setIcon(null);
            }

        } else {

            if (tabuleiro.getCelula(x, y).getPersonagem() != null){

                switch (tabuleiro.getCelula(x, y).getPersonagem().getNome()) {
                    case "Paladino":
                        b[x][y].setIcon(new ImageIcon(getClass().getResource("./images/paladinoButton.png")));
                        b[x][y].setBackground(Color.BLACK);
                        this.posHeroiX = x;
                        this.posHeroiY = y;
                    break;
                    case "Guerreiro":
                        b[x][y].setIcon(new ImageIcon(getClass().getResource("./images/guerreiroButton.png")));
                        b[x][y].setBackground(Color.BLACK);
                        this.posHeroiX = x;
                        this.posHeroiY = y;
                    break;
                    case "Barbaro":
                        b[x][y].setIcon(new ImageIcon(getClass().getResource("./images/barbaroButton.png")));
                        b[x][y].setBackground(Color.BLACK);
                        this.posHeroiX = x;
                        this.posHeroiY = y;
                    break;
                    case "Chefao":
                        b[x][y].setIcon(new ImageIcon(getClass().getResource("./images/chefaoButton.png")));
                        b[x][y].setBackground(Color.BLACK);
                    break;
                    default:
                        b[x][y].setIcon(null);
                        b[x][y].setBackground(Color.BLACK);
                    break;
                }

            } else {
                b[x][y].setIcon(null);
                b[x][y].setBackground(Color.BLACK);
            }
        }
    }
    
    public void atualizaLabels(){
        l2.setText("Ataque: " + String.valueOf(tabuleiro.getCelula(posHeroiX, posHeroiY).getPersonagem().getAtaque()));
        l3.setText("Defesa: " + String.valueOf(tabuleiro.getCelula(posHeroiX, posHeroiY).getPersonagem().getDefesa()));
        l4.setText("Saúde: " + String.valueOf(tabuleiro.getCelula(posHeroiX, posHeroiY).getPersonagem().getSaude()));
        l5.setText("Você tem " + String.valueOf(countDicas) + " dicas disponíveis");
        l9.setText("Bolsa: " + String.valueOf(tabuleiro.getCelula(posHeroiX, posHeroiY).getHeroi().getElixires()));
        if (this.l19 != null){
            l19.setText("Bolsa: " + String.valueOf(tabuleiro.getCelula(posHeroiX, posHeroiY).getHeroi().getElixires())); 
        }
    }


    public void gridPressed(ActionEvent gridEvent) {
        
        x = Integer.parseInt((gridEvent.getActionCommand()).substring(0, 1));
        y = Integer.parseInt((gridEvent.getActionCommand()).substring(2, 3));
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
                
                    this.posHeroiX = x;
                    this.posHeroiY = y;

                    atualizaTabuleiroFrame();
                    atualizaLabels();
                    
                } else {
                    
                    //batalhas
                    if (tabuleiro.getCelula(x, y).getPersonagem() != null){

                        switch (tabuleiro.getCelula(x, y).getPersonagem().getNome()) {
                            case "Chefao":    
                                switch (tabuleiro.getCelula(posHeroiX, posHeroiY).getPersonagem().getNome()){
                                    case "Paladino":
                                        combat(tabuleiro.getCelula(posHeroiX, posHeroiY).getPaladino(), tabuleiro.getCelula(x, y).getChefao());
                                        break;
                                    case "Guerreiro":
                                        combat(tabuleiro.getCelula(posHeroiX, posHeroiY).getGuerreiro(), tabuleiro.getCelula(x, y).getChefao());
                                        break;
                                    case "Barbaro":
                                        combat(tabuleiro.getCelula(posHeroiX, posHeroiY).getBarbaro(), tabuleiro.getCelula(x, y).getChefao());
                                        break;
                                }
                                break;
                            
                            case "MonstroMenor":
                                switch (tabuleiro.getCelula(posHeroiX, posHeroiY).getPersonagem().getNome()){
                                    case "Paladino":
                                        combat(tabuleiro.getCelula(posHeroiX, posHeroiY).getPaladino(), tabuleiro.getCelula(x, y).getMonstroMenor());
                                        break;
                                    case "Guerreiro":
                                        combat(tabuleiro.getCelula(posHeroiX, posHeroiY).getGuerreiro(), tabuleiro.getCelula(x, y).getMonstroMenor());
                                        break;
                                    case "Barbaro":
                                        combat(tabuleiro.getCelula(posHeroiX, posHeroiY).getBarbaro(), tabuleiro.getCelula(x, y).getMonstroMenor());
                                        break;
                                }
                                break;
                        }
                    } else {
                        
                        //armadilhas
                        if (tabuleiro.getCelula(x, y).getArmadilha() != null){

                            switch (tabuleiro.getCelula(x, y).getArmadilha().getNome()){
                                case "ArmadilhaPF":
                                    acionarArmadilha(tabuleiro.getCelula(posHeroiX, posHeroiY).getHeroi(), tabuleiro.getCelula(x, y).getArmadilhaPF());
                                break;
                                case "ArmadilhaPA":
                                    acionarArmadilha(tabuleiro.getCelula(posHeroiX, posHeroiY).getHeroi(), tabuleiro.getCelula(x, y).getArmadilhaPA());
                                break;
                            }
                        } else {
                            
                        //elixir
                            int teste; 
                            
                            teste = tabuleiro.getCelula(posHeroiX, posHeroiY).getHeroi().adicionarElixir();
                            
                            if (teste == 0){
                                tabuleiro.getCelula(x, y).removerElixir();
                                
                                JOptionPane.showMessageDialog(null, "Encontrou um elixir!");
                                
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
                                
                                posHeroiX = x;
                                posHeroiY = y;
                                
                                atualizaTabuleiroFrame();
                                atualizaLabels();
                                
                            } else {
                                JOptionPane.showMessageDialog(null, "Encontrou elixir, mas sua bolsa está cheia");
                                
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
                                
                                posHeroiX = x;
                                posHeroiY = y;
                                
                                atualizaTabuleiroFrame();
                                atualizaLabels();
                            }
                        }
                    }
                }
                
                /*
                this.posHeroiX = x;
                this.posHeroiY = y;

                atualizaTabuleiroFrame();
                atualizaLabels();*/
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

    private void dicaPressed(ActionEvent dicaEvent) {
        
        if(countDicas > 0) {
            JOptionPane.showMessageDialog(null, "Selecione qualquer casa do tabuleiro e você saberá quantas armadilhas existem naquela coluna!");
            flagDica = true;
        }
    }
    
    private void sairPressed(ActionEvent sairEvent) {
        this.dispose();
        FinalFrame finalScreen = new FinalFrame(tabuleiroCopia);
    }
    
    private void acionarArmadilha(Heroi heroi, ArmadilhaPerdaFixa armadilha){
        
        heroi.setSaude(heroi.getSaude() - armadilha.getDano());
        
        JOptionPane.showMessageDialog(null, "Você pisou em uma armadilha de dano fixo! Dano recebido: " + armadilha.getDano());
        
        if (tabuleiro.getCelula(posHeroiX, posHeroiY).getHeroi().isAlive()){
                
            switch (tabuleiro.getCelula(posHeroiX, posHeroiY).getPersonagem().getNome()){   
                case "Paladino":
                    tabuleiro.getCelula(x, y).removerArmadilha();
                    tabuleiro.moverHeroi(tabuleiro.getCelula(posHeroiX, posHeroiY).getPaladino(), posHeroiX, posHeroiY, x, y);
                    break;
                case "Guerreiro":
                    tabuleiro.getCelula(x, y).removerArmadilha();
                    tabuleiro.moverHeroi(tabuleiro.getCelula(posHeroiX, posHeroiY).getGuerreiro(), posHeroiX, posHeroiY, x, y);
                    break;
                case "Barbaro":
                    tabuleiro.getCelula(x, y).removerArmadilha();
                    tabuleiro.moverHeroi(tabuleiro.getCelula(posHeroiX, posHeroiY).getBarbaro(), posHeroiX, posHeroiY, x, y);
                    break;
            }
            posHeroiX = x;
            posHeroiY = y;

            atualizaTabuleiroFrame();
            atualizaLabels();
        } else {
            JOptionPane.showMessageDialog(null, "GAME OVER");
            JFrame finalScreen = new FinalFrame(tabuleiroCopia);
            closeWindows();
        }  
    }
    
    private void acionarArmadilha(Heroi heroi, ArmadilhaPerdaAleatoria armadilha){
        int dano;
        Random geradorAleatorio = new Random();
        
        dano = geradorAleatorio.nextInt(armadilha.getDanoMaximo());
        heroi.setSaude(heroi.getSaude() - dano);
        
        JOptionPane.showMessageDialog(null, "Você pisou em uma armadilha de dano aleatório! Dano recebido: " + dano);
        
        if (tabuleiro.getCelula(posHeroiX, posHeroiY).getHeroi().isAlive()){
                
            switch (tabuleiro.getCelula(posHeroiX, posHeroiY).getHeroi().getNome()){
                case "Paladino":
                    tabuleiro.getCelula(x, y).removerArmadilha();
                    tabuleiro.moverHeroi(tabuleiro.getCelula(posHeroiX, posHeroiY).getPaladino(), posHeroiX, posHeroiY, x, y);
                    break;
                case "Guerreiro":
                    tabuleiro.getCelula(x, y).removerArmadilha();
                    tabuleiro.moverHeroi(tabuleiro.getCelula(posHeroiX, posHeroiY).getGuerreiro(), posHeroiX, posHeroiY, x, y);
                    break;
                case "Barbaro":
                    tabuleiro.getCelula(x, y).removerArmadilha();
                    tabuleiro.moverHeroi(tabuleiro.getCelula(posHeroiX, posHeroiY).getBarbaro(), posHeroiX, posHeroiY, x, y);
                    break;
            }
            posHeroiX = x;
            posHeroiY = y;

            atualizaTabuleiroFrame();
            atualizaLabels();
        } else {
            JOptionPane.showMessageDialog(null, "GAME OVER");
            tabuleiroCopia.printTabuleiro();
            JFrame finalScreen = new FinalFrame(tabuleiroCopia);
            setWindowsInvible();
        }    
    }
    
    private void combat(Heroi heroi, Monstro monstro){
        this.player = heroi;
        this.inimigo = monstro;
        
        criaCombatFrame();
    }
    
    private void criaCombatFrame(){
        
        this.setVisible(false);
        
        combatFrame = new JFrame();
        combatFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        combatFrame.setSize(800, 500);
        
        JPanel finalPanel = new JPanel();
        finalPanel.setLayout(new BoxLayout(finalPanel, BoxLayout.X_AXIS));
        finalPanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        
        finalPanel.add(Box.createHorizontalGlue());
        
        
            JPanel heroPanel = new JPanel();
            heroPanel.setLayout(new BoxLayout(heroPanel, BoxLayout.Y_AXIS));
            heroPanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
            
            ImageIcon hero = null;
            switch (tabuleiro.getCelula(posHeroiX, posHeroiY).getPersonagem().getNome()) {
                case "Barbaro":
                    hero = new ImageIcon(getClass().getResource("./images/barbaro.png"));
                    break;
                case "Guerreiro":
                    hero = new ImageIcon(getClass().getResource("./images/guerreiro.png"));
                    break;
                case "Paladino":
                    hero = new ImageIcon(getClass().getResource("./images/paladino.png"));
            }

            if (inimigo != null) {
                JLabel imageHero = new JLabel(hero);
                imageHero.setAlignmentX(JLabel.CENTER_ALIGNMENT);
                heroPanel.add(imageHero);
            }
                    

            l14 = new JLabel(String.valueOf(tabuleiro.getCelula(posHeroiX, posHeroiY).getPersonagem().getNome()));
            l14.setFont(new Font("Arial",1, 18));
            l14.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            heroPanel.add(l14);

            heroPanel.add(new JLabel(" "));
            heroPanel.add(new JLabel(" "));

            l11 = new JLabel("Ataque: " + String.valueOf(tabuleiro.getCelula(posHeroiX, posHeroiY).getPersonagem().getAtaque()));
            l11.setFont(new Font ("Arial", 1, 12));
            l11.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            heroPanel.add(l11);
            heroPanel.add(new JLabel(" "));

            l12 = new JLabel("Defesa: " + String.valueOf(tabuleiro.getCelula(posHeroiX, posHeroiY).getPersonagem().getDefesa()));
            l12.setFont(new Font ("Arial", 1, 12));
            l12.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            heroPanel.add(l12);
            heroPanel.add(new JLabel(" "));

            l13 = new JLabel("Saúde: " + String.valueOf(tabuleiro.getCelula(posHeroiX, posHeroiY).getPersonagem().getSaude()));
            l13.setFont(new Font ("Arial", 1, 12));
            l13.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            heroPanel.add(l13);
            heroPanel.add(new JLabel(" "));
        
        
        finalPanel.add(heroPanel);
        
        JPanel combatPanel = new JPanel();
        combatPanel.setLayout(new BoxLayout(combatPanel, BoxLayout.Y_AXIS));
        combatPanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        
        combatPanel.add(Box.createVerticalGlue());
        
        l6 = new JLabel("Combate");
        l6.setFont(new Font ("Arial", 1, 20));
        l6.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        combatPanel.add(l6);
        
        combatPanel.add(Box.createVerticalGlue());
        
        l7 = new JLabel("Seu Turno");
        l7.setFont(new Font ("Arial", 1, 16));
        l7.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        combatPanel.add(l7);
        combatPanel.add(new JLabel(" "));
        
        l20 = new JLabel();
        l20.setFont(new Font ("Arial", 1, 12));
        l20.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        combatPanel.add(l20);
        combatPanel.add(new JLabel(" "));
        
        l21 = new JLabel();
        l21.setFont(new Font ("Arial", 1, 12));
        l21.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        combatPanel.add(l21);
        combatPanel.add(new JLabel(" "));
        
        l22 = new JLabel();
        l22.setFont(new Font ("Arial", 1, 12));
        l22.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        combatPanel.add(l22);
        combatPanel.add(new JLabel(" "));
        
        combatPanel.add(Box.createHorizontalGlue());
        
        l19 = new JLabel("Bolsa: " + String.valueOf(tabuleiro.getCelula(posHeroiX, posHeroiY).getHeroi().getElixires()));
        l19.setFont(new Font ("Arial", 1, 12));
        l19.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        combatPanel.add(l19);
        
        combatPanel.add(new JLabel(" "));
        
        buttonElixir2 = new JButton("Elixir");
        //buttonElixir2.setPreferredSize(new java.awt.Dimension(200, 40));
        buttonElixir2.setBackground(Color.LIGHT_GRAY);
        buttonElixir2.setAlignmentX(JButton.CENTER_ALIGNMENT);
        buttonElixir2.addActionListener(this::elixirPressed);
        combatPanel.add(buttonElixir2);
        
            JPanel buttonsPanel = new JPanel();
            buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
            buttonsPanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);

            //buttonsPanel.add(Box.createVerticalGlue());
            buttonsPanel.add(Box.createHorizontalGlue());

            atacarButton = new JButton("Atacar");
            atacarButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
            atacarButton.setBackground(Color.LIGHT_GRAY);
            buttonsPanel.add(atacarButton);
            atacarButton.addActionListener(this::atacar);

            buttonsPanel.add(new JLabel("   "));

            habilidadeButton = new JButton("Habilidade Especial");
            habilidadeButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
            habilidadeButton.setBackground(Color.LIGHT_GRAY);
            buttonsPanel.add(habilidadeButton);
            habilidadeButton.addActionListener(this::habilidadeEspecial);
            
            buttonsPanel.add(Box.createHorizontalGlue());
            buttonsPanel.add(Box.createVerticalGlue());

            combatPanel.add(buttonsPanel);
            
        continuarButton = new JButton("Continuar");
        continuarButton.setVisible(false);
        continuarButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        continuarButton.setBackground(Color.LIGHT_GRAY);
        combatPanel.add(continuarButton);
        continuarButton.addActionListener(this::continuar);
            
        l8 = new JLabel();
        l8.setFont(new Font ("Arial", 1, 16));
        l8.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        combatPanel.add(l8);
        
        combatPanel.add(Box.createVerticalGlue());
        
        finalPanel.add(combatPanel);
        
            JPanel inimigoPanel = new JPanel();
            inimigoPanel.setLayout(new BoxLayout(inimigoPanel, BoxLayout.Y_AXIS));
            inimigoPanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
            
            ImageIcon inimigo = null;
            switch (tabuleiro.getCelula(x, y).getPersonagem().getNome()) {
                case "MonstroMenor":
                    inimigo = new ImageIcon(getClass().getResource("./images/monstroMenor.png"));
                    break;
                case "Chefao":
                    inimigo = new ImageIcon(getClass().getResource("./images/chefao.png"));
                    break;
            }

            if (inimigo != null) {
                JLabel imageInimigo = new JLabel(inimigo);
                imageInimigo.setAlignmentX(JLabel.CENTER_ALIGNMENT);
                inimigoPanel.add(imageInimigo);
            }

            l15 = new JLabel(String.valueOf(tabuleiro.getCelula(x, y).getPersonagem().getNome()));
            l15.setFont(new Font("Arial",1, 18));
            l15.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            inimigoPanel.add(l15);

            inimigoPanel.add(new JLabel(" "));
            inimigoPanel.add(new JLabel(" "));

            l16 = new JLabel("Ataque: " + String.valueOf(tabuleiro.getCelula(x, y).getPersonagem().getAtaque()));
            l16.setFont(new Font ("Arial", 1, 12));
            l16.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            inimigoPanel.add(l16);
            inimigoPanel.add(new JLabel(" "));

            l17 = new JLabel("Defesa: " + String.valueOf(tabuleiro.getCelula(x, y).getPersonagem().getDefesa()));
            l17.setFont(new Font ("Arial", 1, 12));
            l17.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            inimigoPanel.add(l17);
            inimigoPanel.add(new JLabel(" "));

            l18 = new JLabel("Saúde: " + String.valueOf(tabuleiro.getCelula(x, y).getPersonagem().getSaude()));
            l18.setFont(new Font ("Arial", 1, 12));
            l18.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            inimigoPanel.add(l18);
            inimigoPanel.add(new JLabel(" "));
        
        
        finalPanel.add(inimigoPanel);
        
        finalPanel.add(Box.createHorizontalGlue());
        
        combatFrame.add(finalPanel);
        combatFrame.setVisible(true);
    }
    
    private void atualizaLabelsCombat(){
        l11.setText("Ataque: " + String.valueOf(tabuleiro.getCelula(posHeroiX, posHeroiY).getPersonagem().getAtaque()));
        l12.setText("Defesa: " + String.valueOf(tabuleiro.getCelula(posHeroiX, posHeroiY).getPersonagem().getDefesa()));
        l13.setText("Saúde: " + String.valueOf(tabuleiro.getCelula(posHeroiX, posHeroiY).getPersonagem().getSaude()));


        l16.setText("Ataque: " + String.valueOf(tabuleiro.getCelula(x, y).getPersonagem().getAtaque()));
        l17.setText("Defesa: " + String.valueOf(tabuleiro.getCelula(x, y).getPersonagem().getDefesa()));
        l18.setText("Saúde: " + String.valueOf(tabuleiro.getCelula(x, y).getPersonagem().getSaude()));
        
    }
    
    private void atacar(ActionEvent atacarEvent){
        
        int ataque = 0, defesa = 0, resultado = 0, rounds = 2, aleatorio1, aleatorio2;
        boolean turno = true;
        
        Random geradorAleatorio = new Random();
        
        aleatorio1 = geradorAleatorio.nextInt(w);
        aleatorio2 = geradorAleatorio.nextInt(w);
        
        
        while (inimigo.isAlive() && player.isAlive() && rounds > 0) {
                
            if (turno){ 
                //atacando     
                if (habilidadeAtiva > 0) {                    
                    //habilidade especial ativa
                    switch (inimigo.getNome()){
                        case ("MonstroMenor"):

                            switch (player.getNome()){
                                case "Barbaro":
                                    //Golpe Furioso - Desfere um ataque que causa 50% a mais de dano
                                    tabuleiro.getCelula(posHeroiX, posHeroiY).getBarbaro().usarHabilidadeEspecial();
                                    ataque = aleatorio1 + tabuleiro.getCelula(posHeroiX, posHeroiY).getBarbaro().getAtaque();
                                    defesa = aleatorio2 + tabuleiro.getCelula(x, y).getMonstroMenor().getDefesa();
                                    ataque = ataque + ataque/2;
                                    resultado = ataque - defesa;
                                    resultadosAtaque = "Seu ataque: ( " + aleatorio1 + " + " + player.getAtaque() + " } * 1.5 = " + ataque;
                                    resultadosDefesa = "Defesa do inimigo: " + aleatorio2 + " + " + inimigo.getDefesa() + " = " + defesa;
                                    resultadosTotal = "Dano total: " + resultado;
                                    //reverte efeito da habilidade
                                    tabuleiro.getCelula(posHeroiX, posHeroiY).getBarbaro().setAtaque(tabuleiro.getCelula(posHeroiX, posHeroiY).getBarbaro().getAtaqueOriginal());
                                    habilidadeAtiva--; 
                                    break;
                                case "Guerreiro":
                                    ataque = aleatorio1 + tabuleiro.getCelula(posHeroiX, posHeroiY).getGuerreiro().getAtaque();
                                    defesa = aleatorio2 + tabuleiro.getCelula(x, y).getMonstroMenor().getDefesa();
                                    resultado = ataque - defesa;
                                    resultadosAtaque = "Seu ataque: " + aleatorio1 + " + " + player.getAtaque() + " = " + ataque;
                                    resultadosDefesa = "Defesa do inimigo: " + aleatorio2 + " + " + inimigo.getDefesa() + " = " + defesa;
                                    resultadosTotal = "Dano total: " + resultado;
                                    break;
                            }
                            break;

                        case "Chefao":

                            switch (player.getNome()){
                                case "Barbaro":
                                     //Golpe Furioso - Desfere um ataque que causa 50% a mais de dano
                                    tabuleiro.getCelula(posHeroiX, posHeroiY).getBarbaro().usarHabilidadeEspecial();
                                    ataque = aleatorio1 + tabuleiro.getCelula(posHeroiX, posHeroiY).getBarbaro().getAtaque();
                                    ataque = ataque + ataque/2;
                                    defesa = aleatorio2 + tabuleiro.getCelula(x, y).getChefao().getDefesa();
                                    resultado = ataque - defesa;
                                    //reverte efeito da habilidade
                                    tabuleiro.getCelula(posHeroiX, posHeroiY).getBarbaro().setAtaque(tabuleiro.getCelula(posHeroiX, posHeroiY).getBarbaro().getAtaqueOriginal());
                                    habilidadeAtiva--; 
                                    break;
                                case "Guerreiro":
                                    ataque = aleatorio1 + tabuleiro.getCelula(posHeroiX, posHeroiY).getGuerreiro().getAtaque();
                                    defesa = aleatorio2 + tabuleiro.getCelula(x, y).getChefao().getDefesa();
                                    resultado = ataque - defesa;
                                    resultadosAtaque = "Seu ataque: " + aleatorio1 + " + " + player.getAtaque() + " = " + ataque;
                                    resultadosDefesa = "Defesa do inimigo: " + aleatorio2 + " + " + inimigo.getDefesa() + " = " + defesa;
                                    resultadosTotal = "Dano total: " + resultado;
                                    break;
                                }
                            break; 
                        
                    }
                    
                } else {
                    //habilidade especial inativada
                    switch (inimigo.getNome()){
                        case ("MonstroMenor"):

                            switch (player.getNome()){
                                case "Barbaro":
                                     ataque = aleatorio1 + tabuleiro.getCelula(posHeroiX, posHeroiY).getBarbaro().getAtaque();
                                     defesa = aleatorio2 + tabuleiro.getCelula(x, y).getMonstroMenor().getDefesa();
                                     resultado = ataque - defesa;
                                     resultadosAtaque = "Seu ataque: " + aleatorio1 + " + " + player.getAtaque() + " = " + ataque;
                                    resultadosDefesa = "Defesa do inimigo: " + aleatorio2 + " + " + inimigo.getDefesa() + " = " + defesa;
                                    resultadosTotal = "Dano total: " + resultado;
                                     break;
                                case "Guerreiro":
                                     ataque = aleatorio1 + tabuleiro.getCelula(posHeroiX, posHeroiY).getGuerreiro().getAtaque();
                                     defesa = aleatorio2 + tabuleiro.getCelula(x, y).getMonstroMenor().getDefesa();
                                     resultado = ataque - defesa;
                                     resultadosAtaque = "Seu ataque: " + aleatorio1 + " + " + player.getAtaque() + " = " + ataque;
                                    resultadosDefesa = "Defesa do inimigo: " + aleatorio2 + " + " + inimigo.getDefesa() + " = " + defesa;
                                    resultadosTotal = "Dano total: " + resultado;
                                     break;
                                case "Paladino":
                                     ataque = aleatorio1 + tabuleiro.getCelula(posHeroiX, posHeroiY).getPaladino().getAtaque();
                                     defesa = aleatorio2 + tabuleiro.getCelula(x, y).getMonstroMenor().getDefesa();
                                     resultado = ataque - defesa;
                                     resultadosAtaque = "Seu ataque: " + aleatorio1 + " + " + player.getAtaque() + " = " + ataque;
                                    resultadosDefesa = "Defesa do inimigo: " + aleatorio2 + " + " + inimigo.getDefesa() + " = " + defesa;
                                    resultadosTotal = "Dano total: " + resultado;
                                     break;
                                }
                            break;

                        case "Chefao":

                            switch (player.getNome()){
                                case "Barbaro":
                                     ataque = aleatorio1 + tabuleiro.getCelula(posHeroiX, posHeroiY).getBarbaro().getAtaque();
                                     defesa = aleatorio2 + tabuleiro.getCelula(x, y).getChefao().getDefesa();
                                     resultado = ataque - defesa;
                                     resultadosAtaque = "Seu ataque: " + aleatorio1 + " + " + player.getAtaque() + " = " + ataque;
                                    resultadosDefesa = "Defesa do inimigo: " + aleatorio2 + " + " + inimigo.getDefesa() + " = " + defesa;
                                    resultadosTotal = "Dano total: " + resultado;
                                     break;
                                case "Guerreiro":
                                     ataque = aleatorio1 + tabuleiro.getCelula(posHeroiX, posHeroiY).getGuerreiro().getAtaque();
                                     defesa = aleatorio2 + tabuleiro.getCelula(x, y).getChefao().getDefesa();
                                     resultado = ataque - defesa;
                                     resultadosAtaque = "Seu ataque: " + aleatorio1 + " + " + player.getAtaque() + " = " + ataque;
                                    resultadosDefesa = "Defesa do inimigo: " + aleatorio2 + " + " + inimigo.getDefesa() + " = " + defesa;
                                    resultadosTotal = "Dano total: " + resultado;
                                     break;
                                case "Paladino":
                                     ataque = aleatorio1 + tabuleiro.getCelula(posHeroiX, posHeroiY).getPaladino().getAtaque();
                                     defesa = aleatorio2 + tabuleiro.getCelula(x, y).getChefao().getDefesa();
                                     resultado = ataque - defesa;
                                     resultadosAtaque = "Seu ataque: " + aleatorio1 + " + " + player.getAtaque() + " = " + ataque;
                                    resultadosDefesa = "Defesa do inimigo: " + aleatorio2 + " + " + inimigo.getDefesa() + " = " + defesa;
                                    resultadosTotal = "Dano total: " + resultado;
                                     break;
                            }

                            break;      
                    }
                        
                }

                if (resultado > 0){
                    inimigo.setSaude(inimigo.getSaude() - resultado);                
                } else player.setSaude(player.getSaude() + resultado);
                
                //resultadosAtaque = "Seu ataque: " + aleatorio1 + " + " + tabuleiro.getCelula(posHeroiX, posHeroiY).getHeroi().getAtaque() + " = " + ataque;
                //resultadosDefesa = "Defesa do inimigo: " + aleatorio2 + " + " + tabuleiro.getCelula(posHeroiX, posHeroiY).getHeroi().getDefesa() + " = " + defesa;
                //resultadosTotal = "Dano total: " + resultado;
                        
                l20.setText(resultadosAtaque);
                l21.setText(resultadosDefesa);
                l22.setText(resultadosTotal);
                
                l19.setVisible(false);
                buttonElixir2.setVisible(false);
                atacarButton.setVisible(false);
                habilidadeButton.setVisible(false);
                continuarButton.setVisible(true);
                //JOptionPane.showMessageDialog(null, "Seu ataque: " + aleatorio1 + " + " + (ataque - aleatorio1) + " = " + ataque + " | Sua Defesa: " + aleatorio2 + " + " + (defesa - aleatorio2) + " = " + defesa + " | Dano total: " + resultado);
                turno = false;
                rounds--;
                
                atualizaLabelsCombat();

            } else {
                //defendendo
                if (habilidadeAtiva > 0){
                    
                    switch(inimigo.getNome()){
                        
                        case "MonstroMenos":
                            // Postura Defensiva - aumenta defesa em 50% por dois turnos 
                            tabuleiro.getCelula(posHeroiX, posHeroiY).getGuerreiro().usarHabilidadeEspecial();
                            ataque = aleatorio1 + tabuleiro.getCelula(x, y).getMonstroMenor().getAtaque();
                            defesa = aleatorio2 + player.getDefesa();
                            resultado = ataque - defesa;
                            resultadosAtaque = "Ataque do inimigo: " + aleatorio1 + " + " + inimigo.getAtaque() + " = " + ataque;
                            resultadosDefesa = "Sua Defesa: " + aleatorio2 + " + " + player.getDefesa() + " = " + defesa;
                            resultadosTotal = "Dano total: " + resultado;
                            //reverte o efeito da habilidade
                            tabuleiro.getCelula(posHeroiX, posHeroiY).getGuerreiro().setDefesa(tabuleiro.getCelula(posHeroiX, posHeroiY).getGuerreiro().getDefesaOriginal());
                            habilidadeAtiva--;
                            break;
                        case "Chefao":
                            // Postura Defensiva - aumenta defesa em 50% por dois turnos 
                            tabuleiro.getCelula(posHeroiX, posHeroiY).getGuerreiro().usarHabilidadeEspecial();
                            ataque = aleatorio1 + tabuleiro.getCelula(x, y).getChefao().getAtaque();
                            defesa = aleatorio2 + player.getDefesa();
                            resultado = ataque - defesa;
                            resultadosAtaque = "Ataque do inimigo: " + aleatorio1 + " + " + inimigo.getAtaque() + " = " + ataque;
                            resultadosDefesa = "Sua Defesa: " + aleatorio2 + " + " + player.getDefesa() + " = " + defesa;
                            resultadosTotal = "Dano total: " + resultado;
                            //reverte o efeito da habilidade
                            tabuleiro.getCelula(posHeroiX, posHeroiY).getGuerreiro().setDefesa(tabuleiro.getCelula(posHeroiX, posHeroiY).getGuerreiro().getDefesaOriginal());
                            habilidadeAtiva--;
                            break;
                    }
                    
                } else {
                    
                    switch (inimigo.getNome()){
                    case "MonstroMenor":

                        switch (player.getNome()){
                            case "Barbaro":
                                ataque = aleatorio1 + tabuleiro.getCelula(x, y).getMonstroMenor().getAtaque();
                                defesa = aleatorio2 + tabuleiro.getCelula(posHeroiX, posHeroiY).getBarbaro().getDefesa();
                                resultado = ataque - defesa;
                                resultadosAtaque = "Ataque do inimigo: " + aleatorio1 + " + " + inimigo.getAtaque() + " = " + ataque;
                                resultadosDefesa = "Sua Defesa: " + aleatorio2 + " + " + player.getDefesa() + " = " + defesa;
                                resultadosTotal = "Dano total: " + resultado;
                                break;
                            case "Guerreiro":
                                ataque = aleatorio1 + tabuleiro.getCelula(x, y).getMonstroMenor().getAtaque();
                                defesa = aleatorio2 + tabuleiro.getCelula(posHeroiX, posHeroiY).getGuerreiro().getDefesa();
                                resultado = ataque - defesa;
                                resultadosAtaque = "Ataque do inimigo: " + aleatorio1 + " + " + inimigo.getAtaque() + " = " + ataque;
                                resultadosDefesa = "Sua Defesa: " + aleatorio2 + " + " + player.getDefesa() + " = " + defesa;
                                resultadosTotal = "Dano total: " + resultado;
                                break;
                            case "Paladino":
                                ataque = aleatorio1 + tabuleiro.getCelula(x, y).getMonstroMenor().getAtaque();
                                defesa = aleatorio2 + tabuleiro.getCelula(posHeroiX, posHeroiY).getPaladino().getDefesa();
                                resultado = ataque - defesa;
                                resultadosAtaque = "Ataque do inimigo: " + aleatorio1 + " + " + inimigo.getAtaque() + " = " + ataque;
                                resultadosDefesa = "Sua Defesa: " + aleatorio2 + " + " + player.getDefesa() + " = " + defesa;
                                resultadosTotal = "Dano total: " + resultado;
                                break;
                            }
                        break;

                    case "Chefao":
                        
                        switch (player.getNome()){
                            case "Barbaro":
                                 ataque = aleatorio1 + tabuleiro.getCelula(x, y).getChefao().getAtaque();
                                 defesa = aleatorio2 + tabuleiro.getCelula(posHeroiX, posHeroiY).getBarbaro().getDefesa();
                                 resultado = ataque - defesa;
                                 resultadosAtaque = "Ataque do inimigo: " + aleatorio1 + " + " + inimigo.getAtaque() + " = " + ataque;
                                 resultadosDefesa = "Sua Defesa: " + aleatorio2 + " + " + player.getDefesa() + " = " + defesa;
                                 resultadosTotal = "Dano total: " + resultado;
                                 break;
                            case "Guerreiro":
                                ataque = aleatorio1 + tabuleiro.getCelula(x, y).getChefao().getAtaque();
                                defesa = aleatorio2 + tabuleiro.getCelula(posHeroiX, posHeroiY).getGuerreiro().getDefesa();
                                resultado = ataque - defesa;
                                resultadosAtaque = "Ataque do inimigo: " + aleatorio1 + " + " + inimigo.getAtaque() + " = " + ataque;
                                resultadosDefesa = "Sua Defesa: " + aleatorio2 + " + " + player.getDefesa() + " = " + defesa;
                                resultadosTotal = "Dano total: " + resultado;
                                break;
                            case "Paladino":
                                 ataque = aleatorio1 + tabuleiro.getCelula(x, y).getChefao().getAtaque();
                                 defesa = aleatorio2 + tabuleiro.getCelula(posHeroiX, posHeroiY).getPaladino().getDefesa();
                                 resultado = ataque - defesa;
                                 resultadosAtaque = "Ataque do inimigo: " + aleatorio1 + " + " + inimigo.getAtaque() + " = " + ataque;
                                resultadosDefesa = "Sua Defesa: " + aleatorio2 + " + " + player.getDefesa() + " = " + defesa;
                                resultadosTotal = "Dano total: " + resultado;
                                 break;
                            }
                        break;      
                    }
                }
                
                

                if (resultado > 0){
                    player.setSaude(player.getSaude() - resultado);                
                } else inimigo.setSaude(inimigo.getSaude() + resultado);
                
                //l20.setText(resultadosAtaque);
                //l21.setText(resultadosDefesa);
                //l22.setText(resultadosTotal);
                
                turno = true;
                rounds--;
            }
        }
        
        //fim da batalha
        if (player.isAlive() == false || inimigo.isAlive() == false){
            
            if (player.isAlive() && inimigo.getNome().equals("MonstroMenor")){
                JOptionPane.showMessageDialog(null, "Você Derrotou o inimigo");
                
                switch (tabuleiro.getCelula(posHeroiX, posHeroiY).getPersonagem().getNome()){
                    case "Paladino":
                        tabuleiro.getCelula(posHeroiX, posHeroiY).getPaladino().setFlagHabilidade(true);
                        tabuleiro.moverHeroi(tabuleiro.getCelula(posHeroiX, posHeroiY).getPaladino(), posHeroiX, posHeroiY, x, y);
                        break;
                    case "Guerreiro":
                        tabuleiro.getCelula(posHeroiX, posHeroiY).getGuerreiro().setFlagHabilidade(true);
                        tabuleiro.moverHeroi(tabuleiro.getCelula(posHeroiX, posHeroiY).getGuerreiro(), posHeroiX, posHeroiY, x, y);
                        break;
                    case "Barbaro":
                        tabuleiro.getCelula(posHeroiX, posHeroiY).getBarbaro().setFlagHabilidade(true);
                        tabuleiro.moverHeroi(tabuleiro.getCelula(posHeroiX, posHeroiY).getBarbaro(), posHeroiX, posHeroiY, x, y);
                        break;
                }
                posHeroiX = x;
                posHeroiY = y;
                
                atualizaTabuleiroFrame();
                atualizaLabels();
                this.setVisible(true);
                combatFrame.dispose();
            }
            
            if (player.isAlive() && inimigo.getNome().equals("Chefao")){
                JOptionPane.showMessageDialog(null, "Parabéns! Você derrotou o Chefao e venceu o jogo!");
                JFrame finalScreen = new FinalFrame(tabuleiroCopia);
                combatFrame.dispose();
                closeWindows();
            }
            
            if (inimigo.isAlive()){
                JOptionPane.showMessageDialog(null, "GAME OVER");
                JFrame finalScreen = new FinalFrame(tabuleiroCopia);
                setWindowsInvible();
                combatFrame.dispose();
            }
        }
    }
    
    private void habilidadeEspecial(ActionEvent habilidadeEvent){

        switch (player.getNome()){
        case "Barbaro":
            if (tabuleiro.getCelula(posHeroiX, posHeroiY).getBarbaro().isFlagHabilidade()) {
                JOptionPane.showMessageDialog(null, "Golpe Furioso - Seu próximo ataque causa 50% a mais de dano");
            } else JOptionPane.showMessageDialog(null, "Você já usou a habilidade Especial nessa batalha!");
            //numero de rounds
            habilidadeAtiva = 1;
            break;
        case "Guerreiro":
            if (tabuleiro.getCelula(posHeroiX, posHeroiY).getGuerreiro().isFlagHabilidade()){
                JOptionPane.showMessageDialog(null, "Postura Defensiva - aumenta defesa em 50% por dois turnos");
            } else JOptionPane.showMessageDialog(null, "Você já usou a habilidade Especial nessa batalha!");
            //numero de rounds
            habilidadeAtiva = 2;
            break;
        case "Paladino":
            if (tabuleiro.getCelula(posHeroiX, posHeroiY).getPaladino().isFlagHabilidade()) {
                JOptionPane.showMessageDialog(null, "Recuperação - Recupera 50% dos seus pontos de vida totais");
            } else JOptionPane.showMessageDialog(null, "Você já usou a habilidade Especial nessa batalha!");
            tabuleiro.getCelula(posHeroiX, posHeroiY).getPaladino().usarHabilidadeEspecial();
            break;
        }    
    }

    private void elixirPressed(ActionEvent elixirEvent) {
        tabuleiro.getCelula(posHeroiX, posHeroiY).getHeroi().usarElixir();
        this.atualizaLabels();
        atualizaLabelsCombat();
    }

    private void continuar(ActionEvent e) {
        
        atualizaLabelsCombat();
        
        if (flagContinuarButton){
            
            l7.setText("Turno do inimigo");
            l20.setText(resultadosAtaque);
            l21.setText(resultadosDefesa);
            l22.setText(resultadosTotal);;
            flagContinuarButton = false;
        } else {
            
            l7.setText("Seu turno");
            l20.setText("");
            l21.setText("");
            l22.setText("");
            flagContinuarButton = true;
            continuarButton.setVisible(false);
            atacarButton.setVisible(true);
            habilidadeButton.setVisible(true);
            
            l19.setVisible(true);
            buttonElixir2.setVisible(true);
        }
        
    }

    public void setTabuleiroVisible(boolean visible) {
        this.visible = visible;
        
        this.atualizaTabuleiroFrame();
    }
    
    public boolean isTabuleiroVisible() {
        return this.visible;
    }
    
    public void closeWindows() {
        for(JFrame frame : MainFrame.openWindows){
            frame.dispose();
        }
        dispose();
    }
    
    public void setWindowsInvible() {
        for(JFrame frame : MainFrame.openWindows){
            frame.setVisible(false);
        }
        dispose();
    }
}
