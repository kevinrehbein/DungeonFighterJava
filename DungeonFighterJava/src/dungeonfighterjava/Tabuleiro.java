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
        
        private int linhas;
        private int colunas;
        private Celula[][] tabuleiro;
        int i, j, count;
              
        // Construtor 
        public Tabuleiro(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.tabuleiro = new Celula[linhas][colunas];
        criarTabuleiro();
        }

        private void criarTabuleiro() {
            for (i = 0; i < linhas; i++) {
                for (j = 0; j < colunas; j++) {
                    tabuleiro[i][j] = new Celula(null, null, i, j);
                }
            }
        }
        
        public void adicionarPersonagem (Personagem personagem, int posX, int posY){
            Celula celula = getCelula(posX, posY);
            celula.setPersonagem(personagem);
        }
        
        public void removerPersonagem (Personagem personagem, int posX, int posY){
            Celula celula = getCelula(posX, posY);
            celula.setPersonagem(null);
        }
        
        public void moverPersonagem (int origemX, int origemY, int destinoX, int destinoY){
            Celula celulaOrigem = getCelula(origemX, origemY);
            Celula celulaDestino = getCelula(destinoX, destinoY);
            
            if (celulaOrigem.getPersonagem() != null){
                Personagem p = celulaOrigem.getPersonagem();
                this.removerPersonagem(p, origemX, origemY);
                this.adicionarPersonagem(p, destinoX, destinoY);
            }
        }
        
        public void adicionarArmadilha(Armadilha armadilha, int posX, int posY){
            Celula celula = getCelula(posX, posY);
            celula.setArmadilha(armadilha);
        }
        
        public void removerArmadilha(Armadilha armadilha, int posX, int posY){
            Celula celula = getCelula(posX, posY);
            celula.setArmadilha(null);
        }
        
    public Celula getCelula (int x, int y){
        return tabuleiro[x][y];
    }

    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }
    
    public void printTabuleiro() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (tabuleiro[i][j].getPersonagem() != null){
                    System.out.printf("%s ", tabuleiro[i][j].getPersonagem().getNome());
                } else if (tabuleiro[i][j].getArmadilha() != null) {
                    System.out.printf("%s ", tabuleiro[i][j].getArmadilha().getNome());
                } else System.out.printf("X "); // X representa célula vazia
            }
            System.out.println();     
        }
    }
}
