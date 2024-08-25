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
public class Guerreiro extends Heroi {
    
    private int vidaMaxima, defesaOriginal;
    private boolean flagHabilidade;
    
    public Guerreiro(int ataque, int defesa, int saude) {
        super("Paladino", ataque, defesa, saude);
        vidaMaxima = saude;
        defesaOriginal = defesa;
        flagHabilidade = true;
    }

    @Override
    public void usarHabilidadeEspecial() {
        // Postura Defensiva - aumenta defesa em 50% por dois turnos
        if (flagHabilidade) {
            
            this.setDefesa(this.getDefesa() + this.getDefesa()/2);
            
            flagHabilidade = false;
            
        } else JOptionPane.showMessageDialog(null, "Você já usou a habilidade Especial nessa batalha!");
    }
    
    public void setFlagHabilidade(boolean flagHabilidade) {
        this.flagHabilidade = flagHabilidade;
    }

    public int getDefesaOriginal() {
        return defesaOriginal;
    }

    public boolean isFlagHabilidade() {
        return flagHabilidade;
    }
    
}
