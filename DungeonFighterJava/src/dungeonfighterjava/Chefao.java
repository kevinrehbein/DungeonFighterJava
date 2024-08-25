/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dungeonfighterjava;

/**
 *
 * @author kevin
 */
public class Chefao extends Monstro implements Cloneable {
    
    public Chefao() {
        super("Chefao", 8, 8, 20);
    }
    
    @Override
    public Chefao clone() throws CloneNotSupportedException {
        return (Chefao) super.clone();
    }
}
