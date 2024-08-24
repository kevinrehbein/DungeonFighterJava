/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dungeonfighterjava;

import javax.swing.JOptionPane;

/**
 *
 * @author kevin
 */
public class Paladino extends Heroi {
    
    private int vidaMaxima;
    private boolean flagHabilidade;
    
    public Paladino(int ataque, int defesa, int saude) {
        super("Paladino", ataque, defesa, saude);
        vidaMaxima = saude;
        flagHabilidade = true;
    }

    @Override
    public void usarHabilidadeEspecial() {
        // Recuperação - restaura 50% dos pontos de vida totais
        if (flagHabilidade) {
            this.setSaude(this.getSaude() + vidaMaxima/2);
        
            if (this.getSaude() > vidaMaxima) {
            this.setSaude(vidaMaxima);
            }
            
            JOptionPane.showMessageDialog(null, "Recuperação - Recupera 50% dos seus pontos de vida totais");
            
            flagHabilidade = false;
        } else JOptionPane.showMessageDialog(null, "Você já usou a habilidade Especial nessa batalha!");
    }

    public void setFlagHabilidade(boolean flagHabilidade) {
        this.flagHabilidade = flagHabilidade;
    }

    
    
    
}


