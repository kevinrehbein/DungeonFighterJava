package dungeonfighterjava;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class HeroesFrame extends JFrame {
    private String tipoHeroi = null;

    public HeroesFrame(String name) {
        super(name);
        initializeUI();
    }

    private void initializeUI() {
        setSize(750, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela

        // Criação do painel principal com GridBagLayout
        JPanel heroesPanel = new JPanel(new GridBagLayout());
        heroesPanel.setBackground(Color.DARK_GRAY);
        add(heroesPanel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Adiciona o texto no topo centralizado
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3; // Ocupa as três colunas
        gbc.anchor = GridBagConstraints.CENTER;
        JLabel heroesLabel = new JLabel("Selecione seu personagem");
        heroesLabel.setForeground(Color.WHITE);
        heroesLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Aumenta o tamanho e negrito
        heroesPanel.add(heroesLabel, gbc);

        // Adiciona as imagens e botões
        String[] nomes = {"Barbaro", "Guerreiro", "Paladino"};
        String[] caminhosImagens = {
            "/images/barbaro.png",
            "/images/guerreiro.png",
            "/images/paladino.png"
        };

        for (int i = 0; i < 3; i++) {
            final String nomeHeroi = nomes[i]; // Variável final ou efetivamente final

            // Adiciona a imagem
            gbc.gridy = 1; // Linha das imagens
            gbc.gridx = i; // Colunas diferentes para cada imagem
            gbc.gridwidth = 1; // Ocupa uma coluna
            gbc.anchor = GridBagConstraints.CENTER;

            ImageIcon icon = new ImageIcon(getClass().getResource(caminhosImagens[i]));
            JLabel imageLabel = new JLabel(icon);
            heroesPanel.add(imageLabel, gbc);

            // Adiciona o botão abaixo da imagem
            gbc.gridy = 2; // Linha dos botões
            gbc.gridx = i; // Colunas diferentes para cada botão
            gbc.gridwidth = 1; // Ocupa uma coluna
            gbc.fill = GridBagConstraints.HORIZONTAL; // Faz com que o botão preencha horizontalmente

            JButton button = new JButton(nomeHeroi);
            button.setPreferredSize(new Dimension(200, 50)); // Aumenta a largura do botão
            button.setFont(new Font("Arial", Font.PLAIN, 16));
            button.setBackground(Color.LIGHT_GRAY);
            button.setForeground(Color.BLACK);
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
            button.addActionListener(e -> heroSelected(nomeHeroi));

            heroesPanel.add(button, gbc);
        }

        setVisible(true);
    }

    private void heroSelected(String heroi) {
        tipoHeroi = heroi;
        AttributesFrame attributesScreen = new AttributesFrame("Atributos", tipoHeroi);    
        dispose(); // Fecha a tela atual e mostra a tela de atributos
    }
}


