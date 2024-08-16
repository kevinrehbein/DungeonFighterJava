/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dungeonfighterjava;

/**
 *
 * @author kevin
 */
public class Guerreiro extends Heroi {
    
    public Guerreiro() {
        super("Guerreiro", 9, 6, 100);
    }

    @Override
    public void usarHabilidadeEspecial() {
        // Postura Defensiva - aumenta defesa em 50% por dois turnos
    }
}
