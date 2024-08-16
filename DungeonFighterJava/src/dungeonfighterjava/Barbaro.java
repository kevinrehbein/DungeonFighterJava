/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dungeonfighterjava;

/**
 *
 * @author kevin
 */
public class Barbaro extends Heroi {
    
    public Barbaro() {
        super("Barbaro", 10, 5, 100);
    }

    @Override
    public void usarHabilidadeEspecial() {
        // Golpe furioso - aumenta ataque em 50% por um turno
    }
}


