/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dungeonfighterjava;

import java.util.Random;

/**
 *
 * @author kevin
 */
public class Tabuleiro {
        private String tipoHeroi;
        private int ataque, defesa, saude;
        private final int linhas = 5;
        private final int colunas = 10;
        private final Celula[][] tabuleiro = new Celula[linhas][colunas];
        private final int numeroMonstros = linhas - 1;
        private final int numeroPerdaFixa = 5;
        private final int numeroPerdaAleatoria = 5;
        
        // mapa vazio
        private char[][] mapaTabuleiro = {
        {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
        {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
        {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
        {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
        {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'}
        };
        
    // Construtor 
    public Tabuleiro(String tipoHeroi, int ataque, int defesa, int saude) {
        int i, j, count;
        
        this.tipoHeroi = tipoHeroi;
        this.ataque = ataque;
        this.defesa = defesa;
        this.saude = saude;
        
        Random geradorAleatorio = new Random();
        
        // posiciona Heroi
        mapaTabuleiro[0][geradorAleatorio.nextInt(9)] = 'H';
        
        // posiciona Chefão
        mapaTabuleiro[linhas-1][geradorAleatorio.nextInt(9)] = 'C';
        
        // posiciona Monstros Menores
        count = numeroMonstros;
        while (count != 0){
            i = geradorAleatorio.nextInt(5);
            j = geradorAleatorio.nextInt(9);
            if (mapaTabuleiro[i][j] == '*') {
                mapaTabuleiro[i][j] = 'M';
                count--;
            }
        }
        
        // posiciona armadilhas de perda fixa
        count = numeroPerdaFixa;
        while (count != 0){
            i = geradorAleatorio.nextInt(5);
            j = geradorAleatorio.nextInt(9);
            if (mapaTabuleiro[i][j] == '*') {
                mapaTabuleiro[i][j] = 'F';
                count--;
            }
        }
        
        // posiciona armadilhas de perda aleatoria
        count = numeroPerdaAleatoria;
        while (count != 0){
            i = geradorAleatorio.nextInt(5);
            j = geradorAleatorio.nextInt(9);
            if (mapaTabuleiro[i][j] == '*') {
                mapaTabuleiro[i][j] = 'A';
                count--;
            }
        }
        
        // Cria células com base no mapa
        for (i = 0; i < linhas; i++) {
            for (j = 0; j < colunas; j++) {
                tabuleiro[i][j] = new Celula(mapaTabuleiro[i][j]);
            }
        }
        
    }   
      
    public Celula getTabuleiro(int linha, int coluna){
        return tabuleiro[linha][coluna];
    }
    
    public String getTipoHeroi(){
        return tipoHeroi;
    }
    
    public int getAtaque(){
        return ataque;
    }
    
    public int getDefesa(){
        return defesa;
    }
    
    public int getSaude(){
        return saude;
    }
    
    public void printTabuleiro() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.printf("%c ", mapaTabuleiro[i][j]);
            }
            System.out.println();
        }
    }
}
