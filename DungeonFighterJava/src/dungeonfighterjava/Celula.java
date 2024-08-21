/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dungeonfighterjava;

import java.util.HashSet;
import java.util.Set;
import javax.swing.*;

/**
 *
 * @author kevin
 */
public class Celula {
    
    private Armadilha armadilha = null;
    private Personagem personagem = null;
    private int posX, posY;
    /*
    H: Heroi
    C: Chefão
    M: Monstros menores
    F: Armadilhas de perda fixa
    A: Armadilhas de perda aleatória
    *: Espaços livres
    */

    // Construtor
    public Celula(Personagem personagem, Armadilha armadilha, int x, int y) {
        this.personagem = personagem;
        this.armadilha = armadilha;
        this.posX = x;
        this.posY = y;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }
    public Personagem getPersonagem() {
        return personagem;
    }
    
    public void setArmadilha(Armadilha armadilha) {
        this.armadilha = armadilha;
    }
    
    public Armadilha getArmadilha() {
        return armadilha;
    }
    
}
