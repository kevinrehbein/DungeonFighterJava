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
public class Guerreiro extends Heroi implements Cloneable {
    
    public Guerreiro() {
        super("Guerreiro", 4, 6, 10);
    }

    @Override
    public void usarHabilidadeEspecial() {
        // Postura Defensiva - aumenta defesa em 50% por dois turnos
        if (this.isFlagHabilidade()) {
            
            this.setDefesa(this.getDefesa() + this.getDefesa()/2);
            
            this.setFlagHabilidade(false);
            
        } else JOptionPane.showMessageDialog(null, "Você já usou a habilidade Especial nessa batalha!");
    }  
    
    @Override
    public Guerreiro clone() throws CloneNotSupportedException {
        return (Guerreiro) super.clone();
    }
}
