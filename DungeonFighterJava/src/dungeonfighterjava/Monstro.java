/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dungeonfighterjava;

/**
 *
 * @author kevin
 */
public class Monstro extends Personagem {
    public Monstro(String nome, int ataque, int defesa, int saude) {
        super(nome, ataque, defesa, saude);
    }

    @Override
    public void usarHabilidadeEspecial() {
        // Implementar habilidade especial do monstro, se houver
    }
}

