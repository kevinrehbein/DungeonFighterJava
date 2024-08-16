/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dungeonfighterjava;

/**
 *
 * @author kevin
 */
public class Heroi extends Personagem {
        
    private int elixires;
    private static final int CAPACIDADE_MAX_ELIXIRES = 5;

    public Heroi(String nome, int ataque, int defesa, int saude) {
        super(nome, ataque, defesa, saude);
        this.elixires = 0;
    }
    
    public void adicionarElixir() {
        if (elixires < CAPACIDADE_MAX_ELIXIRES) {
            elixires++;
        }
    }
    
    public void usarElixir() {
        if (elixires > 0) {
            this.setSaude(this.getSaude() + 10); // Supondo que um elixir recupera 10 pontos de vida
            elixires--;
        }
    }
    
    public int getElixires() { 
        return elixires;
    }
    
    @Override
    public void usarHabilidadeEspecial() {
        // Implementar habilidade especial de acordo com o tipo de herói
    }
    
}
