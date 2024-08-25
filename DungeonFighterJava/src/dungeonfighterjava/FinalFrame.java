/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dungeonfighterjava;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author kevin
 */
public class FinalFrame extends JFrame {
    
    private final Tabuleiro tabuleiroAnterior;
    ImageIcon img = new ImageIcon(getClass().getResource("./images/logofundoremovido.png"));
    JLabel foto = new JLabel(img);

    public FinalFrame(Tabuleiro tabuleiroOriginal) {  
        super("Tela Final");
        this.tabuleiroAnterior = tabuleiroOriginal;
        initializeUI();
    }

    private void initializeUI() {
        tabuleiroAnterior.printTabuleiro();
        foto.setBounds(220, 20, 292, 152);
        add(foto);
        setSize(750, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(Color.DARK_GRAY); // Define a cor de fundo do painel
        add(mainPanel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(70, 10, 10, 10); // 70 para o top pra ficar bem espaçado do logo
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0; // Permite que os botões se expandam horizontalmente
   
        // Botão Reiniciar Jogo
        gbc.gridx = 0; // primeiro botao
        JButton buttonJogar = createButton("Reinicar Jogo", e -> reiniciarJogo());
        mainPanel.add(buttonJogar, gbc);

        // Botão Nov Jogo
        gbc.gridx = 1; // segundo botao
        JButton buttonDebug = createButton("Novo Jogo", e -> novoJogo());
        mainPanel.add(buttonDebug, gbc);

        setVisible(true);
    }

   private JButton createButton(String text, ActionListener actionListener) {
    JButton button = new JButton(text);
    button.setPreferredSize(new Dimension(150, 50));
    button.setFont(new Font("Arial", Font.PLAIN, 16));
    button.setBackground(Color.LIGHT_GRAY);
    button.setForeground(Color.BLACK);
    button.setFocusPainted(false); // Remove a borda de foco padrão
    button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2)); // Define a borda do botão
    button.addActionListener(actionListener);
    return button;
    
    }
   
   private void reiniciarJogo(){
        tabuleiroAnterior.printTabuleiro();
        setWindowsVisible();
        TabuleiroFrame tabuleiroScreen = new TabuleiroFrame("Dungeon_Fighter", tabuleiroAnterior);
        dispose();
   }
    
   private void novoJogo(){
        closeWindows();
        MainFrame mainScreen = new MainFrame("Tela Inicial");
        this.dispose();
    }
    
   public void setWindowsVisible() {
        for(JFrame frame : MainFrame.openWindows){
            frame.setVisible(true);
        }
    }
   
   public void closeWindows() {
        for(JFrame frame : MainFrame.openWindows){
            frame.dispose();
        }
    }
}
