/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dungeonfighterjava;

/**
 *
 * @author kevin
 */

public class ArmadilhaPerdaAleatoria extends Armadilha {
    private final int danoMaximo;

    public ArmadilhaPerdaAleatoria() {
        super("ArmadilhaPA");
        this.danoMaximo = 10;
    }

        public int getDanoMaximo(){
            return danoMaximo;
        }
}
