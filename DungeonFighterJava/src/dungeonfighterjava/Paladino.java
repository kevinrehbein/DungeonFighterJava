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
       
    public Paladino() {
        super("Paladino", 5, 5, 10);
    }

    @Override
    public void usarHabilidadeEspecial() {
        // Recuperação - restaura 50% dos pontos de vida totais
        if (this.isFlagHabilidade()) {
            this.setSaude(this.getSaude() + this.getVidaMaxima()/2);
        
            if (this.getSaude() > this.getVidaMaxima()) {
            this.setSaude(this.getVidaMaxima());
            }
            
            this.setFlagHabilidade(false);
        } else JOptionPane.showMessageDialog(null, "Você já usou a habilidade Especial nessa batalha!");
    } 
    
}


