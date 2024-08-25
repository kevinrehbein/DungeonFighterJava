/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dungeonfighterjava;

/**
 *
 * @author kevin
 */
public class ArmadilhaPerdaFixa extends Armadilha implements Cloneable {
    private final int dano;
    
    public ArmadilhaPerdaFixa() {
        super("ArmadilhaPF");
        this.dano = 1;
    }
    
    public int getDano(){
        return dano;
    }
    
    @Override
    public ArmadilhaPerdaFixa clone() throws CloneNotSupportedException {
        return (ArmadilhaPerdaFixa) super.clone();
    }
}
