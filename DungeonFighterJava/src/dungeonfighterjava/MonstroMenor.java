/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dungeonfighterjava;

/**
 *
 * @author kevin
 */
public class MonstroMenor extends Monstro implements Cloneable{
    
    
    public MonstroMenor() {
        super("MonstroMenor", 5, 4, 12);
    }
    
    @Override
    public MonstroMenor clone() throws CloneNotSupportedException {
        return (MonstroMenor) super.clone();
    }
}
