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
public abstract class Heroi extends Personagem implements Cloneable{
        
    private int elixires;
    private final int CAPACIDADE_MAX_ELIXIRES = 3;
    private final int pontosElixir = 10;
    private boolean flagHabilidade;

    public Heroi(String nome, int ataque, int defesa, int saude) {
        super(nome, ataque, defesa, saude);
        this.elixires = 0;
        this.flagHabilidade = true;
    }
    
    public int adicionarElixir() {
        if (elixires < CAPACIDADE_MAX_ELIXIRES) {
            elixires++;
            return 0;
        } else return 1;
    }
    
    public void usarElixir() {
        if (elixires > 0) {
            this.setSaude(this.getSaude() + pontosElixir);
            elixires--;
            
            if (this.getSaude() > this.getVidaMaxima()){
                this.setSaude(this.getVidaMaxima());
            }
        } else JOptionPane.showMessageDialog(null, "Sua bolsa está vazia!");
    }
    
    public int getElixires() { 
        return elixires;
    }
    
    public abstract void usarHabilidadeEspecial();

    public boolean isFlagHabilidade() {
        return flagHabilidade;
    }

    public void setFlagHabilidade(boolean flagHabilidade) {
        this.flagHabilidade = flagHabilidade;
    }
    
    @Override
    public Heroi clone() throws CloneNotSupportedException {
        return (Heroi) super.clone();
    }
}
