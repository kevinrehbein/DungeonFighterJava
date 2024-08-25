/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dungeonfighterjava;

/**
 *
 * @author kevin
 */

public class ArmadilhaPerdaAleatoria extends Armadilha implements Cloneable {
    private final int danoMaximo;

    public ArmadilhaPerdaAleatoria() {
        super("ArmadilhaPA");
        this.danoMaximo = 10;
    }

    public int getDanoMaximo(){
        return danoMaximo;
    }
    
    @Override
    public ArmadilhaPerdaAleatoria clone() throws CloneNotSupportedException {
        return (ArmadilhaPerdaAleatoria) super.clone();
    }
}
