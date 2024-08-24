package dungeonfighterjava;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainFrame extends JFrame {
    
    ImageIcon img = new ImageIcon(getClass().getResource("/images/logofundoremovido.png"));
    JLabel foto = new JLabel(img);

    public MainFrame(String title) {  
        super(title);
        initializeUI();
    }

    private void initializeUI() {
        foto.setBounds(0, 0, 292, 152);
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
        
    
        

        // Botão Jogar
        gbc.gridx = 0; // primeiro botao
        JButton buttonJogar = createButton("Jogar", e -> jogar());
        mainPanel.add(buttonJogar, gbc);

        // Botão Debug
        gbc.gridx = 1; // segundo botao
        JButton buttonDebug = createButton("DEBUG", e -> debug());
        mainPanel.add(buttonDebug, gbc);

        // Botão Sair
        gbc.gridx = 2; // terceiro botao
        JButton buttonSair = createButton("Sair", e -> sair());
        mainPanel.add(buttonSair, gbc);

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


    private void jogar() {
      // abre a tela de selecao de heroi
        HeroesFrame heroesScreen = new HeroesFrame("Heroes");
        
        dispose(); // faz com que somente a tela de seleçao de heroi fique visivel.
    }

    private void debug() {
        // Substitua por sua lógica de debug
        System.out.println("Modo de Debug");
         
         
    }

    private void sair() {
        int response = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja sair?", "Confirmar Saída", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame("Tela Inicial"));
    }
}
