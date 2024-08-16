/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dungeonfighterjava;

/**
 *
 * @author kevin
 */
public class Paladino extends Heroi {
    
    public Paladino() {
        super("Paladino", 8, 7, 90);
    }

    @Override
    public void usarHabilidadeEspecial() {
        // Recuperação - restaura 50% dos pontos de vida totais
        this.setSaude(this.getSaude() + this.getSaude() / 2);
    }
}


