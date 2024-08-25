package dungeonfighterjava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AttributesFrame extends JFrame {

    private int pontos = 5;
    private int ataque = 0, defesa = 0, saude = 0;
    private final String tipoHeroi;
          
    private Barbaro barbaroConfigurado;
    private Guerreiro guerreiroConfigurado;
    private Paladino paladinoConfigurado;

    private final JLabel heroesLabel;
    
    private DungeonFighterJava dungeonFighterStart;

    public AttributesFrame(String name, String tipoHeroi) {
        super(name);
        this.tipoHeroi = tipoHeroi;
        this.setSize(750, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela

        // Usa GridBagLayout para centralizar os componentes
        JPanel heroesPanel = new JPanel(new GridBagLayout());
        heroesPanel.setBackground(Color.DARK_GRAY);
        this.add(heroesPanel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1; // Define a largura como uma coluna

        // Título
        heroesLabel = new JLabel(tipoHeroi + " - Distribua " + pontos + " pontos entre os atributos: Ataque 0, Defesa 0, Saude 0");
        heroesLabel.setForeground(Color.WHITE);
        heroesLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.anchor = GridBagConstraints.CENTER; // Centraliza o rótulo
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Ocupa toda a linha
        heroesPanel.add(heroesLabel, gbc);

        // Painel para agrupar os atributos e botões
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;

        JPanel attributesPanel = new JPanel(new GridBagLayout());
        attributesPanel.setBackground(Color.DARK_GRAY); // Mantém a cor de fundo

        GridBagConstraints attrGbc = new GridBagConstraints();
        attrGbc.insets = new Insets(5, 5, 5, 5);
        attrGbc.gridx = 0;
        attrGbc.gridy = 0;
        attrGbc.anchor = GridBagConstraints.CENTER;

        // Botões e rótulos para Ataque
        JButton b1 = new JButton("+");
        b1.addActionListener(this::aumentaAtaque);
        b1.setBackground(Color.LIGHT_GRAY);
        attributesPanel.add(b1, attrGbc);

        attrGbc.gridx = 1;
        JLabel labelAtaque = new JLabel("Ataque");
        labelAtaque.setForeground(Color.WHITE);
        attributesPanel.add(labelAtaque, attrGbc);

        attrGbc.gridx = 2;
        JButton b2 = new JButton("-");
        b2.addActionListener(this::diminuiAtaque);
        b2.setBackground(Color.LIGHT_GRAY);
        attributesPanel.add(b2, attrGbc);

        // Botões e rótulos para Defesa
        attrGbc.gridy = 1;
        attrGbc.gridx = 0;
        JButton b3 = new JButton("+");
        b3.addActionListener(this::aumentaDefesa);
        b3.setBackground(Color.LIGHT_GRAY);
        attributesPanel.add(b3, attrGbc);

        attrGbc.gridx = 1;
        JLabel labelDefesa = new JLabel("Defesa");
        labelDefesa.setForeground(Color.WHITE);
        attributesPanel.add(labelDefesa, attrGbc);

        attrGbc.gridx = 2;
        JButton b4 = new JButton("-");
        b4.addActionListener(this::diminuiDefesa);
        b4.setBackground(Color.LIGHT_GRAY);
        attributesPanel.add(b4, attrGbc);

        // Botões e rótulos para Saúde
        attrGbc.gridy = 2;
        attrGbc.gridx = 0;
        JButton b5 = new JButton("+");
        b5.addActionListener(this::aumentaSaude);
        b5.setBackground(Color.LIGHT_GRAY);
        attributesPanel.add(b5, attrGbc);

        attrGbc.gridx = 1;
        JLabel labelSaude = new JLabel("Saúde");
        labelSaude.setForeground(Color.WHITE);
        attributesPanel.add(labelSaude, attrGbc);

        attrGbc.gridx = 2;
        JButton b6 = new JButton("-");
        b6.addActionListener(this::diminuiSaude);
        b6.setBackground(Color.LIGHT_GRAY);
        attributesPanel.add(b6, attrGbc);

        gbc.gridwidth = GridBagConstraints.REMAINDER; // Ocupa toda a linha
        heroesPanel.add(attributesPanel, gbc);

        // Botão Confirmar
        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;

        JButton confirmarButton = new JButton("Confirmar");
        confirmarButton.setBackground(Color.LIGHT_GRAY);
        confirmarButton.setPreferredSize(new Dimension(100, 30));
        confirmarButton.addActionListener(this::confirmarAtributos);
        heroesPanel.add(confirmarButton, gbc);
    }

    // Métodos de ajuste de atributos e confirmação permanecem os mesmos
    private void aumentaAtaque(ActionEvent actionEvent) {
        if (pontos > 0) {
            ataque++;
            pontos--;
            atualizaLabelPontos();
        } else {
            JOptionPane.showMessageDialog(this, "Pontos esgotados", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void diminuiAtaque(ActionEvent actionEvent) {
        if (ataque > 0) {
            ataque--;
            pontos++;
            atualizaLabelPontos();
        } else {
            JOptionPane.showMessageDialog(this, "Ataque não pode ser menor que 0", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void aumentaDefesa(ActionEvent actionEvent) {
        if (pontos > 0) {
            defesa++;
            pontos--;
            atualizaLabelPontos();
        } else {
            JOptionPane.showMessageDialog(this, "Pontos esgotados", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void diminuiDefesa(ActionEvent actionEvent) {
        if (defesa > 0) {
            defesa--;
            pontos++;
            atualizaLabelPontos();
        } else {
            JOptionPane.showMessageDialog(this, "Defesa não pode ser menor que 0", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void aumentaSaude(ActionEvent actionEvent) {
        if (pontos > 0) {
            saude++;
            pontos--;
            atualizaLabelPontos();
        } else {
            JOptionPane.showMessageDialog(this, "Pontos esgotados", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void diminuiSaude(ActionEvent actionEvent) {
        if (saude > 0) {
            saude--;
            pontos++;
            atualizaLabelPontos();
        } else {
            JOptionPane.showMessageDialog(this, "Saúde não pode ser menor que 0", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void atualizaLabelPontos() {
        heroesLabel.setText(tipoHeroi + " - Distribua " + pontos + " pontos entre os atributos: Ataque " + ataque + ", Defesa " + defesa + ", Saúde " + saude);
    }

    private void confirmarAtributos(ActionEvent actionEvent) {
        
        // Cria o herói com os atributos definidos      
        switch (tipoHeroi) {
            case "Barbaro":
                barbaroConfigurado = new Barbaro();
                
                // Aplica os atributos personalizados
                barbaroConfigurado.setAtaque(barbaroConfigurado.getAtaque() + ataque);
                barbaroConfigurado.setDefesa(barbaroConfigurado.getDefesa() + defesa);
                barbaroConfigurado.setSaude(barbaroConfigurado.getSaude() + saude);
                
                // Inicia o jogo com o herói configurado
                iniciarJogo(barbaroConfigurado);
                break;
            case "Guerreiro":
                guerreiroConfigurado = new Guerreiro();
                
                // Aplica os atributos personalizados
                guerreiroConfigurado.setAtaque(guerreiroConfigurado.getAtaque() + ataque);
                guerreiroConfigurado.setDefesa(guerreiroConfigurado.getDefesa() + defesa);
                guerreiroConfigurado.setSaude(guerreiroConfigurado.getSaude() + saude);
                
                // Inicia o jogo com o herói configurado
                iniciarJogo(guerreiroConfigurado);
                break;
            case "Paladino":
                paladinoConfigurado = new Paladino();
                
                // Aplica os atributos personalizados
                paladinoConfigurado.setAtaque(paladinoConfigurado.getAtaque() + ataque);
                paladinoConfigurado.setDefesa(paladinoConfigurado.getDefesa() + defesa);
                paladinoConfigurado.setSaude(paladinoConfigurado.getSaude() + saude);
                
                // Inicia o jogo com o herói configurado
                iniciarJogo(paladinoConfigurado);
                break;
            default:
                throw new IllegalArgumentException("Tipo de herói desconhecido: " + tipoHeroi);
        }
          
        this.dispose(); // Fecha a tela de atributos
    }

    private void iniciarJogo(Barbaro heroi) {
        dungeonFighterStart = new DungeonFighterJava(heroi);
    }
    
    private void iniciarJogo(Guerreiro heroi) {
        dungeonFighterStart = new DungeonFighterJava(heroi);
    }
    
    private void iniciarJogo(Paladino heroi) {
        dungeonFighterStart = new DungeonFighterJava(heroi);
    }

    public DungeonFighterJava getDungeonFighterStart() {
        return dungeonFighterStart;
    }
 
}
