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
    
    private int vidaMaxima, ataqueOriginal;
    private boolean flagHabilidade;
    
    public Barbaro(int ataque, int defesa, int saude) {
        super("Barbaro", ataque, defesa, saude);
        vidaMaxima = saude;
        ataqueOriginal = ataque;
        flagHabilidade = true;
    }

    @Override
    public void usarHabilidadeEspecial() {
        //Golpe Furioso - Desfere um ataque que causa 50% a mais de dano
        if (flagHabilidade) {
            
            //this.setAtaque(this.getAtaque() + this.getAtaque()/2);
            
            flagHabilidade = false;
            
        }
    }

    public void setFlagHabilidade(boolean flagHabilidade) {
        this.flagHabilidade = flagHabilidade;
    }

    public int getAtaqueOriginal() {
        return ataqueOriginal;
    }    

    public boolean isFlagHabilidade() {
        return flagHabilidade;
    }
    
}


