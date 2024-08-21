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
    private final int perdaMaxima;

    public ArmadilhaPerdaAleatoria() {
        super("ArmadilhaPA");
        this.perdaMaxima = 10;
    }

    @Override
    public void aplicarEfeito(Heroi heroi) {
        int perda = (int) (Math.random() * (perdaMaxima + 1));
        heroi.receberDano(perda);
    }
}
