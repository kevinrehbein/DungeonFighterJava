/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dungeonfighterjava;

/**
 *
 * @author kevin
 */
public abstract class Personagem {
    private String nome;
    private int ataque;
    private int defesa;
    private int saude;
    private final int vidaMaxima, ataqueOriginal, defesaOriginal;
    
    public Personagem(String nome, int ataque, int defesa, int saude) {
        this.nome = nome;
        this.ataque = ataque;
        this.defesa = defesa;
        this.saude = saude;
        this.vidaMaxima = saude;
        this.ataqueOriginal = ataque;
        this.defesaOriginal = defesa;
    }
    
    // Métodos para acessar e modificar atributos
    public String getNome() {
        return nome; 
    }
    public int getAtaque() { 
        return ataque; 
    }
    public void setAtaque(int ataque) {
        this.ataque = ataque; 
    }
    public int getDefesa() {
        return defesa; 
    }
    public void setDefesa(int defesa) {
        this.defesa = defesa; 
    }
    public int getSaude() {
        return saude; 
    }
    public void setSaude(int saude) {
        this.saude = saude; 
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public int getAtaqueOriginal() {
        return ataqueOriginal;
    }

    public int getDefesaOriginal() {
        return defesaOriginal;
    }
    
    // Método para receber dano
    public void receberDano(int dano) {
        this.saude -= dano;
        if (this.saude < 0) this.saude = 0;
    }
    
    // Método para checar se o personagem está vivo
    public boolean isAlive() {
        return saude > 0;
    }
}


