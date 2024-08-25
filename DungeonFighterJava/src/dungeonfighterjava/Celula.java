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
public class Celula implements Cloneable {
    
    private Armadilha armadilha;
    private ArmadilhaPerdaFixa armadilhaPF;
    private ArmadilhaPerdaAleatoria armadilhaPA;
    private Personagem personagem;
    private Heroi heroi;
    private Barbaro barbaro;
    private Paladino paladino;
    private Guerreiro guerreiro;
    private MonstroMenor monstroMenor;
    private Chefao chefao;
    private int posX, posY;
    private boolean empty, elixir;

    // Construtor
    public Celula(int x, int y) {
        
        this.armadilhaPF = null;
        this.armadilhaPA = null;
        this.personagem = null;
        this.heroi = null;
        this.barbaro = null;
        this.paladino = null;
        this.guerreiro = null;
        this.monstroMenor = null;
        this.chefao = null;
        this.posX = x;
        this.posY = y;
        this.elixir = false;
        setEmpty(true);
    }

    public boolean isElixir() {
        return elixir;
    }

    public void setElixir() {
        this.elixir = true;
        setEmpty(false);
    }
    
    public void removerElixir() {
        this.elixir = false;
        setEmpty(true);
    }
    
    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean status) {  // true == vazio, false == cheio
        this.empty = status;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void removerPersonagem(){
        switch (this.getPersonagem().getNome()){
            case "Paladino":
                this.paladino = null;
                this.heroi = null;
                this.personagem = null;
                break;
            case "Guerreiro":
                this.guerreiro = null;
                this.heroi = null;
                this.personagem = null;
                break;
            case "Barbaro":
                this.barbaro = null;
                this.heroi = null;
                this.personagem = null;
                break;
            case "MonstroMenor":
                this.monstroMenor = null;
                break;
            case "Chefao":
                this.chefao = null;
                break;
        }
        this.personagem = null;
        this.setEmpty(true);
    }
    
    public void setPersonagem(Barbaro personagem) {
        this.barbaro = personagem;
        this.personagem = personagem;
        this.heroi = personagem;
        setEmpty(false);
    }
    public void setPersonagem(Guerreiro personagem) {
        this.guerreiro = personagem;
        this.personagem = personagem;
        this.heroi = personagem;
        setEmpty(false);
    }
    public void setPersonagem(Paladino personagem) {
        this.paladino = personagem;
        this.personagem = personagem;
        this.heroi = personagem;
        setEmpty(false);
    }
    public void setPersonagem(MonstroMenor personagem) {
        this.monstroMenor = personagem;
        this.personagem = personagem;
        setEmpty(false);
    }
    public void setPersonagem(Chefao personagem) {
        this.chefao = personagem;
        this.personagem = personagem;
        setEmpty(false);
    }
    
    
    public Personagem getPersonagem() {
        return personagem;
    }

    public Barbaro getBarbaro() {
        return barbaro;
    }

    public Paladino getPaladino() {
        return paladino;
    }

    public Guerreiro getGuerreiro() {
        return guerreiro;
    }
    
    public Heroi getHeroi(){
        return heroi;
    }
    
    public MonstroMenor getMonstroMenor(){
        return monstroMenor;
    }
    
    public Chefao getChefao(){
        return chefao;
    }
    
    public void setArmadilha(ArmadilhaPerdaFixa armadilha) {
        this.armadilhaPF = armadilha;
        this.armadilha = armadilha;
        setEmpty(false);
    }
    
    public void setArmadilha(ArmadilhaPerdaAleatoria armadilha){
        this.armadilhaPA = armadilha;
        this.armadilha = armadilha;
        setEmpty(false);
    }
    
    public void removerArmadilha (){
        this.armadilha = null;
        this.armadilhaPA = null;
        this.armadilhaPF = null;
    }
    
    public Armadilha getArmadilha() {
        return armadilha;
    }
    
    public ArmadilhaPerdaFixa getArmadilhaPF() {
        return armadilhaPF;
    }
    
    public ArmadilhaPerdaAleatoria getArmadilhaPA() {
        return armadilhaPA;
    }
    
    @Override
    public Celula clone() throws CloneNotSupportedException {
        return (Celula) super.clone();
    }
}

