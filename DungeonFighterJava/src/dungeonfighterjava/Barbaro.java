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
public class Barbaro extends Heroi {
    
    public Barbaro() {
        super("Barbaro", 6, 4, 10);
    }

    @Override
    public void usarHabilidadeEspecial() {
        //Golpe Furioso - Desfere um ataque que causa 50% a mais de dano
        if (this.isFlagHabilidade()) {

            this.setFlagHabilidade(false);    
        }
    }
}