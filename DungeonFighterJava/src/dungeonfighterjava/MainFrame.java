package dungeonfighterjava;


import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class MainFrame extends JFrame {
    
    public static List<JFrame> openWindows = new ArrayList<>();
       
    ImageIcon img = new ImageIcon(getClass().getResource("./images/logofundoremovido.png"));
    JLabel foto = new JLabel(img);
    public static HeroesFrame heroesScreen;
    

    public MainFrame(String title) {  
        super(title);
        heroesScreen = null;
        initializeUI();
        
        openWindows.add(this);
    }

    private void initializeUI() {
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
      
    try {
        if (heroesScreen.getAttributesScreen().getDungeonFighterStart() != null)
          JOptionPane.showMessageDialog(this, "Tabuleiro já criado", "Erro", JOptionPane.ERROR_MESSAGE);
    } catch (NullPointerException nexc){
        heroesScreen = new HeroesFrame("Heroes");
    }
        
       //dispose(); // faz com que somente a tela de seleçao de heroi fique visivel.
    }

    private void debug() {
        try {
            if (heroesScreen.getAttributesScreen().getDungeonFighterStart().getTabuleiroScreen().isTabuleiroVisible()){
                heroesScreen.getAttributesScreen().getDungeonFighterStart().getTabuleiroScreen().setTabuleiroVisible(false);
            } else heroesScreen.getAttributesScreen().getDungeonFighterStart().getTabuleiroScreen().setTabuleiroVisible(true);
            
            JOptionPane.showMessageDialog(null, "Clique novamente para mudar a visibilidade do tabuleiro");
        } catch (NullPointerException nexc) {
            JOptionPane.showMessageDialog(this, "Tabuleiro não criado", "Erro", JOptionPane.ERROR_MESSAGE);
        }
       
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
